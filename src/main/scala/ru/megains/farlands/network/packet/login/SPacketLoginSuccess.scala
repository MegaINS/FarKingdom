package ru.megains.farlands.network.packet.login

import ru.megains.farlands.network.handler.NetHandlerLoginClient
import ru.megains.farlands.network.packet.{Packet, PacketBuffer}

class SPacketLoginSuccess extends Packet[NetHandlerLoginClient] {


    override def readPacketData(packetBuffer: PacketBuffer): Unit = {

    }

    override def writePacketData(packetBuffer: PacketBuffer): Unit = {

    }

    override def processPacket(handler: NetHandlerLoginClient): Unit = {
        handler.handleLoginSuccess(this)
    }



}
