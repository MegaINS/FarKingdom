package ru.megains.farlands.network.packet.play

import ru.megains.farlands.gameScreen.{GameScreen, GameScreenMine, GameScreenTiled}
import ru.megains.farlands.network.handler.NetHandlerPlayClient
import ru.megains.farlands.network.packet.{Packet, PacketBuffer}

class SPacketLocInfo extends Packet[NetHandlerPlayClient]{

    var locationId:Int = 0
    var tupe:Int = 0
    var posX:Int = 0
    var posY:Int = 0
    var location:GameScreen = _
    override def readPacketData(buf: PacketBuffer): Unit = {
        locationId =  buf.readInt()
        tupe =  buf.readInt()
        posX =  buf.readInt()
        posY =  buf.readInt()
        location = if(tupe==1) new GameScreenTiled(locationId,"") else new GameScreenMine()
        location.read(buf)
    }

    override def writePacketData(buf: PacketBuffer): Unit = {

    }

    override def processPacket(handler: NetHandlerPlayClient): Unit = {
        handler.packetLocInfo(this)
    }

}
