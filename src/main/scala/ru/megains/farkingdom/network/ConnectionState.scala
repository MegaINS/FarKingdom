package ru.megains.farkingdom.network

import ru.megains.farkingdom.network.packet._
import ru.megains.farkingdom.network.packet.login.{PacketLogin, SPacketLoginSuccess}
import ru.megains.farkingdom.network.packet.play.{SLocationPlayer, SPacketWorldLoad, SPlayerAction}

import scala.collection.mutable


sealed abstract class ConnectionState(val name: String, val id: Int) {


    val clientIdPacket = new mutable.HashMap[ Class[_ <: PacketWrite],Int]()
    val serverPacketId = new mutable.HashMap[Int,Class[_ <: PacketRead[_]]]()


    def registerClientPacket(packet: Class[_ <: PacketWrite]): Unit = {
        clientIdPacket +=  packet -> clientIdPacket.size
    }
    def registerServerPacket(packet: Class[_ <: PacketRead[_]]): Unit = {
        serverPacketId += serverPacketId.size -> packet
    }
    def getClientPacketId(packet: Class[_ <: PacketWrite]): Option[Int] = {
        clientIdPacket.get(packet)
    }

    def getServerPacket(id: Int): Option[PacketRead[_]] = {
        serverPacketId(id) match {
            case null => None
            case packet => Some(packet.newInstance())
        }
    }
}


object ConnectionState {



    val STATES_BY_CLASS = new mutable.HashMap[Class[_ <: Packet[_]], ConnectionState]()

    def getFromId(id: Int): ConnectionState = {
        STATES_BY_ID(id)
    }


    def getFromPacket(inPacket: Packet[_]): ConnectionState = {
        STATES_BY_CLASS(inPacket.getClass)
    }


    case object HANDSHAKING extends ConnectionState("HANDSHAKING", 0) {
        registerClientPacket(classOf[CHandshake])
    }


    case object STATUS extends ConnectionState("STATUS", 1) {

    }

    case object LOGIN extends ConnectionState("LOGIN", 2) {
        registerServerPacket(classOf[SPacketDisconnect])
        registerServerPacket(classOf[SPacketLoginSuccess])
        registerClientPacket(classOf[PacketLogin])
     //   registerClientPacket(classOf[PacketRegister])
    }


    case object PLAY extends ConnectionState("PLAY", 3) {
        registerServerPacket(classOf[SPacketDisconnect])
        registerServerPacket(classOf[SPacketWorldLoad])
      //  registerServerPacket(classOf[SPacketLocInfo])
       // registerServerPacket(classOf[CPlayerMove])
        registerServerPacket(classOf[SLocationPlayer])
       // registerServerPacket(classOf[SPacketPlayerInfo])
       // registerServerPacket(classOf[SLocUpdate])


        registerClientPacket(classOf[SPlayerAction])
    }


    val STATES_BY_ID = Array(HANDSHAKING, STATUS, LOGIN, PLAY)
    addClass(HANDSHAKING)
    addClass(STATUS)
    addClass(LOGIN)
    addClass(PLAY)

    def addClass(state: ConnectionState): Unit = {
        state.clientIdPacket.keySet.foreach(packet =>
            STATES_BY_CLASS += packet -> state)

        state.serverPacketId.values.foreach(packet =>
            STATES_BY_CLASS += packet -> state)
    }


}
