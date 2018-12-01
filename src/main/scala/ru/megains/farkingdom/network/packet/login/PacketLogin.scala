package ru.megains.farkingdom.network.packet.login

import ru.megains.farkingdom.network.packet.{PacketBufferS, PacketWrite}

class PacketLogin(name:String,pass:String) extends PacketWrite{




    override def writePacketData(buf: PacketBufferS): Unit = {
        buf.writeStringToBuffer(name)
        buf.writeStringToBuffer(pass)
    }

}
