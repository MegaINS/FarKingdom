package ru.megains.farkingdom.network.packet

import ru.megains.farkingdom.network.handler.INetHandler

abstract class Packet[T <: INetHandler] {

    def isImportant = false

}



