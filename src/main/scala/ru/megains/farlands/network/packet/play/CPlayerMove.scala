package ru.megains.farlands.network.packet.play

import ru.megains.farlands.network.handler.NetHandlerPlayClient
import ru.megains.farlands.network.packet.{Packet, PacketBuffer}

class CPlayerMove extends Packet[NetHandlerPlayClient]{
    var posX: Int = 0
    var posY: Int = 0

    override def readPacketData(buf: PacketBuffer): Unit = {
        posX = buf.readInt()
        posY = buf.readInt()
    }

    override def writePacketData(buf: PacketBuffer): Unit = {


    }

    override def processPacket(handler: NetHandlerPlayClient): Unit = {
        handler.playerMove(this)
    }
}
