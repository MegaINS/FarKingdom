package ru.megains.farkingdom.network.handler

import ru.megains.farkingdom.network.{ConnectionState, NetworkManager}
import ru.megains.farkingdom.network.packet.SPacketDisconnect
import ru.megains.farkingdom.network.packet.login.SPacketLoginSuccess

class NetHandlerLoginClient() extends INetHandler {


    def handleDisconnect(packetIn: SPacketDisconnect): Unit = {

    }

    override def onDisconnect(msg: String): Unit = {

    }

    def handleLoginSuccess(packetIn: SPacketLoginSuccess): Unit = {
        NetworkManager.setConnectionState(ConnectionState.PLAY)
        NetworkManager.setNetHandler(new NetHandlerPlayClient())
    }
   // override def handleLoginSuccess(packetIn: Any): Unit = ???

    override def disconnect(msg: String): Unit = ???
}
