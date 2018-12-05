package ru.megains.farkingdom.network.packet.play

import ru.megains.farkingdom.LocAction
import ru.megains.farkingdom.LocAction.LocAction
import ru.megains.farkingdom.network.handler.NetHandlerPlayClient
import ru.megains.farkingdom.network.packet.{PacketBufferS, PacketRead}

import scala.collection.mutable.ArrayBuffer

class SLocationPlayer extends PacketRead[NetHandlerPlayClient]{

    var locAction:LocAction =_
    var players:ArrayBuffer[(Int,Boolean,Int,Int)] = new ArrayBuffer[(Int,Boolean, Int, Int)]()
    override def readPacketData(buf: PacketBufferS): Unit = {
        locAction = LocAction(buf.readInt())

        val player = (buf.readInt(),buf.readBoolean(),buf.readInt(),buf.readInt())
        players += player

    }



    override def processPacket(handler: NetHandlerPlayClient): Unit = {
        handler.locationPlayer(this)
    }
}
