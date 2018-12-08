package ru.megains.farlands.network.packet.play

import ru.megains.farlands.network.handler.NetHandlerPlayClient
import ru.megains.farlands.network.packet.{Packet, PacketBuffer}

class SPacketPlayerInfo extends Packet[NetHandlerPlayClient]{

    var id = 0
    override def readPacketData(buf: PacketBuffer): Unit = {
        id = buf.readInt()
    }

    override def writePacketData(buf: PacketBuffer): Unit = ???

    override def processPacket(handler: NetHandlerPlayClient): Unit = {
        handler.packetPlayerInfo(this)
    }
}
