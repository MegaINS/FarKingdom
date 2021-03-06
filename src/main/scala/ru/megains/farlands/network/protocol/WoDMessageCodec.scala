package ru.megains.farlands.network.protocol

import java.io.IOException
import java.util

import io.netty.buffer.ByteBuf
import io.netty.channel.ChannelHandlerContext
import io.netty.handler.codec.ByteToMessageCodec
import ru.megains.farlands.Logger
import ru.megains.farlands.network.{ConnectionState, NetworkManager}
import ru.megains.farlands.network.packet.{Packet, PacketBuffer}

class WoDMessageCodec extends ByteToMessageCodec[Packet[_]] with Logger[WoDMessageCodec]{


    override def encode(ctx: ChannelHandlerContext, msg: Packet[_], out: ByteBuf): Unit = {

        val id = ctx.pipeline().channel().attr(NetworkManager.PROTOCOL_ATTRIBUTE_KEY).get().getClientPacketId(msg.getClass)
        val buffer = new PacketBuffer(out)

        buffer.writeShort(id)
        msg.writePacketData(buffer)
        val size = out.readableBytes()
        val name = ConnectionState.getFromPacket(msg).name
        val packetName = msg.getClass.getSimpleName
        log.info(s"Encoder $name, packet $packetName, id $id, size $size")
    }

    override def decode(ctx: ChannelHandlerContext, in: ByteBuf, out: util.List[AnyRef]): Unit = {
        val size = in.readableBytes()
        if (size != 0) {
            val buffer = new PacketBuffer(in)
            val id = buffer.readShort()

            val packet = ctx.pipeline().channel().attr(NetworkManager.PROTOCOL_ATTRIBUTE_KEY).get().getServerPacket(id)

            if (packet == null) throw new IOException("Bad packet id " + id)
            val name = ConnectionState.getFromPacket(packet).name


            val packetName = packet.getClass.getSimpleName

            log.info(s"Decoder $name, packet $packetName, id $id, size $size")
            packet.readPacketData(buffer)

            if (in.readableBytes > 0) throw new IOException("Packet was larger than I expected, found " + in.readableBytes + " bytes extra whilst reading packet " + id)
            else out.add(packet)

        }
    }
}
