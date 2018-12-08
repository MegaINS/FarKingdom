package ru.megains.farlands.network.protocol

import io.netty.channel.socket.nio.NioSocketChannel
import io.netty.channel.{ChannelInitializer, ChannelOption}
import ru.megains.farlands.network.NetworkManager


class WoDChannelInitializer() extends ChannelInitializer[NioSocketChannel]{


    override def initChannel(ch: NioSocketChannel): Unit = {
        ch.pipeline()
                .addLast("serverCodec", new WoDServerCodec)
                .addLast("messageCodec", new WoDMessageCodec)
                .addLast("packetHandler", NetworkManager)
        ch.config.setOption(ChannelOption.TCP_NODELAY, Boolean.box(true))

    }
}
