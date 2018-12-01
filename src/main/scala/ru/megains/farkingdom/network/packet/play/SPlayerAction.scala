package ru.megains.farkingdom.network.packet.play

import ru.megains.farkingdom.network.packet.{PacketBufferS, PacketWrite}


class SPlayerAction(/*playerAction:PlayerAction,par1:Int = 0,par2:Int = 0,par3:Int = 0,par4:String = ""*/) extends PacketWrite{



   // override def readPacketData(buf: PacketBuffer): Unit = ???

    override def writePacketData(buf: PacketBufferS): Unit = {
//        buf.writeInt(playerAction.id)
//        playerAction match {
//            case MOVE|MINE =>
//                buf.writeInt(par1)
//                buf.writeInt(par2)
//            case CHANGE_LOC =>
//                buf.writeStringToBuffer(par4)
//        }
    }

 //   override def processPacket(handler: INetHandler): Unit = ???
}
