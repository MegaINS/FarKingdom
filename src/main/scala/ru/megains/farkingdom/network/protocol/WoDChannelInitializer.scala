package ru.megains.farkingdom.network.protocol

import io.netty.channel.{ChannelInitializer, ChannelOption}
import io.netty.channel.socket.nio.NioSocketChannel
import ru.megains.farkingdom.network.NetworkManager


class WoDChannelInitializer() extends ChannelInitializer[NioSocketChannel]{


    override def initChannel(ch: NioSocketChannel): Unit = {
        ch.pipeline()
                .addLast("serverCodec", new WoDServerCodec)
                .addLast("messageCodec", new WoDMessageCodec)
                .addLast("packetHandler", NetworkManager)
        ch.config.setOption(ChannelOption.TCP_NODELAY, Boolean.box(true))

    }
}
