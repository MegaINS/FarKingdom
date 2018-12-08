package ru.megains.farlands.network.packet.play

import ru.megains.farlands.LocAction
import ru.megains.farlands.LocAction.LocAction
import ru.megains.farlands.network.handler.NetHandlerPlayClient
import ru.megains.farlands.network.packet.{Packet, PacketBuffer}

import scala.collection.mutable.ArrayBuffer

class SLocationPlayer extends Packet[NetHandlerPlayClient]{

    var locAction:LocAction =_
    var players:ArrayBuffer[(Int,Int,Int)] = new ArrayBuffer[(Int, Int, Int)]()
    override def readPacketData(buf: PacketBuffer): Unit = {
        locAction = LocAction(buf.readInt())
        var i = buf.readInt()
        while (i>0){
            i-=1
            val player = (buf.readInt(),buf.readInt(),buf.readInt())
            players += player
        }
    }

    override def writePacketData(buf: PacketBuffer): Unit = {




    }

    override def processPacket(handler: NetHandlerPlayClient): Unit = {
        handler.locationPlayer(this)
    }
}
