package ru.megains.farlands.network.packet

import ru.megains.farlands.network.ConnectionState
import ru.megains.farlands.network.handler.INetHandler


class CHandshake() extends Packet[INetHandler] {

    var connectionState: ConnectionState = _

    override def isImportant: Boolean = true

    def this(version: Int, ip: String, port: Int, connectionState: ConnectionState) {
        this()
        this.connectionState = connectionState
    }

    override def readPacketData(packetBuffer: PacketBuffer): Unit = {
        connectionState = ConnectionState.getFromId(packetBuffer.readByte())
    }

    override def writePacketData(packetBuffer: PacketBuffer): Unit = {
        packetBuffer.writeByte(connectionState.id)
    }

    override def processPacket(handler: INetHandler): Unit = {

    }
}
