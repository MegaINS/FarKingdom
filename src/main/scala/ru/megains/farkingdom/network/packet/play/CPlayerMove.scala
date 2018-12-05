package ru.megains.farkingdom.network.packet.play

import ru.megains.farkingdom.network.handler.NetHandlerPlayClient
import ru.megains.farkingdom.network.packet.{PacketBufferS, PacketRead}

class CPlayerMove extends PacketRead[NetHandlerPlayClient]{
    var id: Int = 0
    var posX: Int = 0
    var posY: Int = 0

    override def readPacketData(buf: PacketBufferS): Unit = {
        id= buf.readInt()
        posX = buf.readInt()
        posY = buf.readInt()
    }



    override def processPacket(handler: NetHandlerPlayClient): Unit = {
        handler.playerMove(this)
    }
}
