package ru.megains.farkingdom.network.packet.play

import ru.megains.farkingdom.network.handler.NetHandlerPlayClient
import ru.megains.farkingdom.network.packet.{PacketBufferS, PacketRead}

import scala.collection.mutable

class SPacketWorldLoad extends PacketRead[NetHandlerPlayClient] {

    var x: Int = _
    var y: Int = _
    val map: mutable.Map[Int, Int] = new mutable.HashMap[Int, Int]()


    override def readPacketData(buf: PacketBufferS): Unit = {

        x = buf.readInt()
        y = buf.readInt()
        val size = buf.readInt()
        for (_ <- 0 until  size) {
            val index = buf.readInt()
            val value = buf.readInt()

            map(index) = value
        }
    }

    override def processPacket(handler: NetHandlerPlayClient): Unit = {
        handler.processWorldLoad(this)
    }
}
