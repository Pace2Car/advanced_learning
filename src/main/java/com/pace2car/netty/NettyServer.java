package com.pace2car.netty;

import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;
import org.jboss.netty.handler.codec.serialization.ObjectDecoder;
import org.jboss.netty.handler.codec.serialization.ObjectEncoder;

import java.net.InetSocketAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Pace2Car
 * @date 2019/6/18 11:36
 */
public class NettyServer {
    public static void main(String[] args) {
        // 1.创建服务对象
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        // 2.创建两个线程池 监听端口号/nio监听
        ExecutorService boss = Executors.newCachedThreadPool();
        ExecutorService work = Executors.newCachedThreadPool();
        // 3.将线程池放入工厂
        serverBootstrap.setFactory(new NioServerSocketChannelFactory(boss, work));
        // 4.设置管道工厂
        serverBootstrap.setPipelineFactory(new ChannelPipelineFactory() {
            // 设置管道
            @Override
            public ChannelPipeline getPipeline() throws Exception {
                ChannelPipeline pipeline = Channels.pipeline();
                // 传输数据类型为string类型
                pipeline.addLast("decoder", new ObjectDecoder());
                pipeline.addLast("encoder", new ObjectEncoder());
                // 设置事件监听类
                pipeline.addLast("serverHandler", new ServerHandler());

                return pipeline;
            }
        });
        // 绑定端口号
        serverBootstrap.bind(new InetSocketAddress(8080));
        System.out.println("服务端已启动...");
    }
}

