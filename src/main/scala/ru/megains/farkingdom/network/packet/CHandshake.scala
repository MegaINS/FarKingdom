package ru.megains.farkingdom.network.packet

import ru.megains.farkingdom.network.ConnectionState


class CHandshake() extends PacketWrite {

    var connectionState: ConnectionState = _

    override def isImportant: Boolean = true

    def this(version: Int, ip: String, port: Int, connectionState: ConnectionState) {
        this()
        this.connectionState = connectionState
    }


    override def writePacketData(packetBuffer: PacketBufferS): Unit = {
        packetBuffer.writeByte(connectionState.id)
    }


}
