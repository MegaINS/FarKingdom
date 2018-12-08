package ru.megains.farlandsOld.net;


import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.handler.codec.frame.DelimiterBasedFrameDecoder;
import org.jboss.netty.handler.codec.frame.Delimiters;
import org.jboss.netty.handler.codec.string.StringDecoder;
import org.jboss.netty.handler.codec.string.StringEncoder;
import org.jboss.netty.util.CharsetUtil;


class ClientPipelineFactory implements ChannelPipelineFactory {
    public ClientPipelineFactory() {
    }

    public ChannelPipeline getPipeline() throws Exception {
        ChannelPipeline pipeline = Channels.pipeline();
        pipeline.addLast("framer", new DelimiterBasedFrameDecoder(2147483647, Delimiters.nulDelimiter()));
        pipeline.addLast("decoder", new StringDecoder(CharsetUtil.UTF_8));
        pipeline.addLast("encoder", new StringEncoder(CharsetUtil.UTF_8));
        pipeline.addLast("handler", new ClientHandler());
        return pipeline;
    }
}

