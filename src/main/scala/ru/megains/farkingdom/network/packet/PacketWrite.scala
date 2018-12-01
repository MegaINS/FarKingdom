package ru.megains.farkingdom.network.packet

abstract class PacketWrite extends Packet {

    def writePacketData(buf: PacketBufferS): Unit

}
