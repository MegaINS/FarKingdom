package ru.megains.farkingdom.network.protocol

import java.io.IOException
import java.util

import io.netty.buffer.ByteBuf
import io.netty.channel.ChannelHandlerContext
import io.netty.handler.codec.ByteToMessageCodec
import ru.megains.farkingdom.Logger
import ru.megains.farkingdom.network.packet.{PacketBufferS, PacketWrite}
import ru.megains.farkingdom.network.{ConnectionState, NetworkManager}

class WoDMessageCodec extends ByteToMessageCodec[PacketWrite] with Logger[WoDMessageCodec]{


    override def encode(ctx: ChannelHandlerContext, msg: PacketWrite, out: ByteBuf): Unit = {

        val id = ctx.pipeline().channel().attr(NetworkManager.PROTOCOL_ATTRIBUTE_KEY).get().getClientPacketId(msg.getClass)
        val buffer = new PacketBufferS(out)


        id match {
            case Some(value) =>
                buffer.writeShort(value)
                msg.writePacketData(buffer)
                val size = out.readableBytes()
                val name = ConnectionState.getFromPacket(msg).name
                val packetName = msg.getClass.getSimpleName
                log.info(s"Encoder $name, packet $packetName, id $value, size $size")
            case None =>
                throw new IOException("Bad packet class " + msg.getClass)
        }

    }

    override def decode(ctx: ChannelHandlerContext, in: ByteBuf, out: util.List[AnyRef]): Unit = {
        val size = in.readableBytes()
        if (size != 0) {
            val buffer = new PacketBufferS(in)
            val id = buffer.readShort()

                     val packetOpt = ctx.pipeline().channel().attr(NetworkManager.PROTOCOL_ATTRIBUTE_KEY).get().getServerPacket(id)

            packetOpt match {
                case Some(packet)=>
                    val name = ConnectionState.getFromPacket(packet).name
                    val packetName = packet.getClass.getSimpleName
                    log.info(s"Decoder $name, packet $packetName, id $id, size $size")
                    packet.readPacketData(buffer)
                    if (in.readableBytes > 0) throw new IOException("Packet was larger than I expected, found " + in.readableBytes + " bytes extra whilst reading packet " + id)
                    else out.add(packet)
                case None =>
                    throw new IOException("Bad packet id " + id)
            }
        }
    }
}
