package ru.megains.farkingdom.network.packet

import java.io.IOException

import ru.megains.farkingdom.network.handler.INetHandler

class SPacketDisconnect() extends PacketRead[INetHandler] {

    private var reason: String = _

    def this(text: String) {
        this()
        this.reason = text
    }

    /**
      * Reads the raw packet data from the data stream.
      */
    @throws[IOException]
    def readPacketData(buf: PacketBufferS) {
        this.reason = buf.readStringFromBuffer(32767)
    }

    /**
      * Writes the raw packet data to the data stream.
      */
    @throws[IOException]
    def writePacketData(buf: PacketBufferS) {
        buf.writeStringToBuffer(reason)
    }

    /**
      * Passes this Packet on to the NetHandler for processing.
      */
    def processPacket(handler: INetHandler) {
       // handler.handleDisconnect(this)
    }


}
