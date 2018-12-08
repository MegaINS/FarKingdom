package ru.megains.farlands.network.handler

import ru.megains.farlands.network.packet.Packet

abstract class INetHandler {


    def onDisconnect(msg: String)

    def disconnect(msg: String)

    def sendPacket(packetIn: Packet[_ <: INetHandler]) {}

}
