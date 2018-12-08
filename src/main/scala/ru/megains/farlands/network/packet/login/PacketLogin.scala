package ru.megains.farlands.network.packet.login

import ru.megains.farlands.network.packet.{Packet, PacketBuffer}

class PacketLogin(name:String,pass:String) extends Packet{


    override def readPacketData(buf: PacketBuffer): Unit = {

    }

    override def writePacketData(buf: PacketBuffer): Unit = {
        buf.writeStringToBuffer(name)
        buf.writeStringToBuffer(pass)
    }

    override def processPacket(handler: Nothing): Unit = {

    }
}
