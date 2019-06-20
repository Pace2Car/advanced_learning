package com.pace2car.netty;

import com.pace2car.disruptor.entity.LongEvent;
import org.jboss.netty.bootstrap.ClientBootstrap;
import org.jboss.netty.channel.*;
import org.jboss.netty.channel.socket.nio.NioClientSocketChannelFactory;
import org.jboss.netty.handler.codec.serialization.ObjectDecoder;
import org.jboss.netty.handler.codec.serialization.ObjectEncoder;
import org.jboss.netty.handler.codec.string.StringDecoder;
import org.jboss.netty.handler.codec.string.StringEncoder;

import java.net.InetSocketAddress;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Pace2Car
 * @date 2019/6/18 16:12
 */
public class NettyClient {
    public static void main(String[] args) {
        // 1.创建服务对象
        ClientBootstrap clientBootstrap = new ClientBootstrap();
        // 2.创建两个线程池 监听端口号/nio监听
        ExecutorService boss = Executors.newCachedThreadPool();
        ExecutorService work = Executors.newCachedThreadPool();
        // 3.将线程池放入工厂
        clientBootstrap.setFactory(new NioClientSocketChannelFactory(boss, work));
        // 4.设置管道工厂
        clientBootstrap.setPipelineFactory(new ChannelPipelineFactory() {
            // 设置管道
            @Override
            public ChannelPipeline getPipeline() throws Exception {
                ChannelPipeline pipeline = Channels.pipeline();
                // 传输数据类型为string类型
                pipeline.addLast("decoder", new ObjectDecoder());
                pipeline.addLast("encoder", new ObjectEncoder());
                // 设置事件监听类
                pipeline.addLast("serverHandler", new ClientHandler());

                return pipeline;
            }
        });
        // 绑定端口号
        ChannelFuture connect = clientBootstrap.connect(new InetSocketAddress("127.0.0.1", 8080));
        System.out.println("客户端已启动...");
        Channel channel = connect.getChannel();
        channel.write(new LongEvent().setValue(10000L));
//        Scanner scanner = new Scanner(System.in);
//        while (true) {
//            System.out.println("请输入内容：");
//            channel.write(scanner.next());
//        }
    }
}
