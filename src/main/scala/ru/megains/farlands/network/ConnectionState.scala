package ru.megains.farlands.network

import ru.megains.farlands.network.packet._
import ru.megains.farlands.network.packet.login._
import ru.megains.farlands.network.packet.play.{SLocUpdate, _}

import scala.collection.mutable


sealed abstract class ConnectionState(val name: String, val id: Int) {


    val serverPacketId = new mutable.HashMap[Int,Class[_ <: Packet[_]]]()
    val clientIdPacket = new mutable.HashMap[Class[_ <: Packet[_]],Int]()


    def registerServerPacket(packet: Class[_ <: Packet[_]]): Unit = {
        serverPacketId +=  serverPacketId.size -> packet
    }
    def registerClientPacket(packet: Class[_ <: Packet[_]]): Unit = {
        clientIdPacket +=  packet ->clientIdPacket.size
    }
    def getServerPacket(id: Int): Packet[_] = {
        val packet = serverPacketId(id)
        if (packet ne null) packet.newInstance() else null.asInstanceOf[Packet[_]]
    }


    def getClientPacketId(packet: Class[_ <: Packet[_]]): Int = {
        clientIdPacket(packet)

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
        registerClientPacket(classOf[PacketRegister])
    }


    case object PLAY extends ConnectionState("PLAY", 3) {


        registerServerPacket(classOf[SPacketLocInfo])
        registerServerPacket(classOf[CPlayerMove])
        registerServerPacket(classOf[SLocationPlayer])
        registerServerPacket(classOf[SPacketPlayerInfo])
        registerServerPacket(classOf[SLocUpdate])


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
