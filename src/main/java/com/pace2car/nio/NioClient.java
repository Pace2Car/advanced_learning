package com.pace2car.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Date;

/**
 * @author Pace2Car
 * @date 2019/6/17 18:23
 */
public class NioClient {
    public static void main(String[] args) throws IOException {
        System.out.println("客户端启动...");
        // 1.创建客户端通道
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 8080));
        // 2.切换为异步非阻塞
        socketChannel.configureBlocking(false);
        // 3.指定缓冲区大小
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.put("hello Server".getBytes());
        // 4.开启读取模式
        buffer.flip();
        socketChannel.write(buffer);
        buffer.clear();
        // 5.关闭通道
        socketChannel.close();
        System.out.println("客户端关闭...");
    }
}
