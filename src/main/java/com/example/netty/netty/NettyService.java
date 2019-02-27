//package com.example.netty.netty;
//
//import io.netty.bootstrap.ServerBootstrap;
//import io.netty.channel.Channel;
//import io.netty.channel.EventLoopGroup;
//import io.netty.channel.nio.NioEventLoopGroup;
//import io.netty.channel.socket.nio.NioServerSocketChannel;
//
//public class NettyService {
//    public NettyService() {
//        /*new Thread(() -> {*/
//        System.out.println("启动Netty!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
//        EventLoopGroup bossGroup = new NioEventLoopGroup();
//        EventLoopGroup workerGroup = new NioEventLoopGroup();
//        try {
//            ServerBootstrap serverBootstrap = new ServerBootstrap();
//            serverBootstrap.group(bossGroup, workerGroup)
//                    .channel(NioServerSocketChannel.class)
//                    .childHandler(new MyChannelInitializer());
//            Channel channel = serverBootstrap.bind(8888).sync().channel();
//            channel.closeFuture().sync();
//        } catch (Exception e) {
//            System.err.println(e);
//        } finally {
//            bossGroup.shutdownGracefully();
//            workerGroup.shutdownGracefully();
//        }
//        /*}).start();*/
//    }
//
//}
