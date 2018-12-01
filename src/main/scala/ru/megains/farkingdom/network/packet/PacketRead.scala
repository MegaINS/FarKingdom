package ru.megains.farkingdom.network.packet

import ru.megains.farkingdom.network.handler.INetHandler


abstract class PacketRead[T <: INetHandler] extends Packet[T]{

    def readPacketData(buf: PacketBufferS): Unit

    def processPacket(handler: T): Unit
}
