package ru.megains.farlands.network.packet.play

import ru.megains.farlands.network.handler.NetHandlerPlayClient
import ru.megains.farlands.network.packet.{Packet, PacketBuffer}

class SLocUpdate extends Packet[NetHandlerPlayClient]{

    var par1:Int = 0
    var par2:Int = 0
    override def readPacketData(buf: PacketBuffer): Unit = {
        par1 = buf.readInt()
        par2 =  buf.readInt()
    }

    override def writePacketData(buf: PacketBuffer): Unit = {

    }

    override def processPacket(handler: NetHandlerPlayClient): Unit = {
        handler.locUpdate(this)
    }
}
