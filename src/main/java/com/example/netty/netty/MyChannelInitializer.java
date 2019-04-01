package com.example.netty.netty;

import com.example.netty.netty.service.TextWebSocketFrameHandler;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("somethingChannelInitializer")
public class MyChannelInitializer extends ChannelInitializer<SocketChannel> {
    @Autowired
    private TextWebSocketFrameHandler textWebSocketFrameHandler;
//    @Override
//    protected void initChannel(Channel channel) throws Exception {
//        ChannelPipeline pipeline = channel.pipeline();
//        pipeline.addLast("http-codec", new HttpServerCodec()); // Http消息编码解码
//        pipeline.addLast("aggregator", new HttpObjectAggregator(65536)); // Http消息组装
//        pipeline.addLast("http-chunked", new ChunkedWriteHandler()); // WebSocket通信支持
//        pipeline.addLast("handler", new MyMatchingHandler());//每两个匹配房间
//
//    }

    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        ChannelPipeline pipeline = socketChannel.pipeline();

        pipeline.addLast(new HttpServerCodec());
        pipeline.addLast(new HttpObjectAggregator(64*1024));
        pipeline.addLast(new ChunkedWriteHandler());
        pipeline.addLast(new WebSocketServerProtocolHandler("/ws"));
        pipeline.addLast(textWebSocketFrameHandler);
    }
}
