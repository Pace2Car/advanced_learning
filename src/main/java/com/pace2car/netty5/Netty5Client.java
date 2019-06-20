package com.pace2car.netty5;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

/**
 * @author Pace2Car
 * @date 2019/6/18 18:39
 */
public class Netty5Client {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("客户端启动中...");
        // 1.创建线程池，负责接收客户端
        NioEventLoopGroup bossGroup = new NioEventLoopGroup();
        try {
            // 2.创建辅助类
            Bootstrap b = new Bootstrap();
            b.group(bossGroup)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(SocketChannel ch) throws Exception {
                            // 根据后缀匹配来拆包
                            ByteBuf buf = Unpooled.copiedBuffer("_p2c".getBytes());
                            ch.pipeline()
                                    .addLast(new DelimiterBasedFrameDecoder(1024, buf))
                                    .addLast("decoder", new StringDecoder())
                                    .addLast("encoder", new StringEncoder())
                                    .addLast(new ClientHandler());

                        }
                    });

            // 绑定端口，开始接收进来的连接
            ChannelFuture cf = b.connect("127.0.0.1", 8090).sync();
            String msg = "hello2_p2c";
            cf.channel().writeAndFlush(Unpooled.wrappedBuffer(msg.getBytes()));
            cf.channel().writeAndFlush(Unpooled.wrappedBuffer(msg.getBytes()));
            cf.channel().writeAndFlush(Unpooled.wrappedBuffer(msg.getBytes()));
            cf.channel().writeAndFlush(Unpooled.wrappedBuffer(msg.getBytes()));
//            Thread.sleep(500);
            cf.channel().writeAndFlush(Unpooled.wrappedBuffer(msg.getBytes()));

            System.out.println("发送消息：" + msg);
            // 等待服务器  socket 关闭。
            cf.channel().closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
        }
    }
}
