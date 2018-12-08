package ru.megains.farkingdom.network.packet.play

import ru.megains.farkingdom.{Army, BUnit}
import ru.megains.farkingdom.network.handler.NetHandlerPlayClient
import ru.megains.farkingdom.network.packet.{PacketBufferS, PacketRead}
import ru.megains.farkingdom.world.GameCell

import scala.collection.mutable

class SPacketWorldLoad extends PacketRead[NetHandlerPlayClient] {

    var x: Int = _
    var y: Int = _
    val map: mutable.Map[Int, GameCell] = new mutable.HashMap[Int, GameCell]()


    override def readPacketData(buf: PacketBufferS): Unit = {

        x = buf.readInt()
        y = buf.readInt()
        val size = buf.readInt()
        for (_ <- 0 until size) {
            val index = buf.readInt()
            val name = buf.readStringFromBuffer(255)

            val x = buf.readInt()
            val y = buf.readInt()
            val gameCell = new GameCell(name, x, y)
            val isArmy = buf.readBoolean()
            if (isArmy){
                val armyName = buf.readStringFromBuffer(255)
                val units = new Array[BUnit](5)
                for (i <- units.indices) {
                    val idIn = buf.readInt()
                    if(idIn!=0){
                        val unit = new BUnit(){
                            id = idIn
                            name =  buf.readStringFromBuffer(255)
                            level = buf.readInt()
                            hp = buf.readInt()
                            midDam = buf.readInt()
                            maxDam = buf.readInt()
                            power = buf.readInt()
                        }
                        units(i) = unit
                    }

                }

                val army = new Army(armyName, units)
                gameCell.army = army
            }

            map(index) = gameCell
        }
    }

    override def processPacket(handler: NetHandlerPlayClient): Unit = {
        handler.processWorldLoad(this)
    }
}
