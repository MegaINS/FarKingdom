package ru.megains.farkingdom.network.packet.login

import ru.megains.farkingdom.network.handler.NetHandlerLoginClient
import ru.megains.farkingdom.network.packet.{PacketBufferS, PacketRead}

class SPacketLoginSuccess extends PacketRead[NetHandlerLoginClient] {
    override def isImportant: Boolean = true

    override def readPacketData(packetBuffer: PacketBufferS): Unit = {

    }

    override def processPacket(handler: NetHandlerLoginClient): Unit = {
        handler.handleLoginSuccess(this)
    }



}
