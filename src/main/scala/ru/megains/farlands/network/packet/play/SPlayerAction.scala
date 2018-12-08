package ru.megains.farlands.network.packet.play

import ru.megains.farlands.network.handler.INetHandler
import ru.megains.farlands.network.packet.{Packet, PacketBuffer}
import ru.megains.farlands.player.PlayerAction._


class SPlayerAction(playerAction:PlayerAction,par1:Int = 0,par2:Int = 0,par3:Int = 0,par4:String = "") extends Packet[INetHandler]{



    override def readPacketData(buf: PacketBuffer): Unit = ???

    override def writePacketData(buf: PacketBuffer): Unit = {
        buf.writeInt(playerAction.id)
        playerAction match {
            case MOVE|MINE =>
                buf.writeInt(par1)
                buf.writeInt(par2)
            case CHANGE_LOC =>
                buf.writeStringToBuffer(par4)
        }
    }

    override def processPacket(handler: INetHandler): Unit = ???
}
