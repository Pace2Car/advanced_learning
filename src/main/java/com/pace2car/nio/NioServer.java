package com.pace2car.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

/**
 * @author Pace2Car
 * @date 2019/6/17 18:38
 */
public class NioServer {
    public static void main(String[] args) throws IOException {
        System.out.println("服务端启动...");
        // 1.创建服务端通道
        ServerSocketChannel ssChannel = ServerSocketChannel.open();
        // 2.切换为异步非阻塞
        ssChannel.configureBlocking(false);
        // 3.绑定连接
        ssChannel.bind(new InetSocketAddress(8080));
        // 4.获取选择器
        Selector selector = Selector.open();
        // 5.将通道注册到选择器中，监听 接收 的事件
        ssChannel.register(selector, SelectionKey.OP_ACCEPT);
        // 6.轮询获取 已准备 的事件
        while (selector.select() > 0) {
            // 7.获取当前注册的选择器 已经监听到 的事件
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()) {
                // 8.获取准备就绪的事件
                SelectionKey selectionKey = iterator.next();
                // 9.判断事件是否可接收
                if (selectionKey.isAcceptable()) {
                    // 10.可接收情况，获取客户端连接
                    SocketChannel channel = ssChannel.accept();
                    // 11.切换为异步非阻塞
                    channel.configureBlocking(false);
                    // 12.将该通道注册到服务器上
                    channel.register(selector, SelectionKey.OP_READ);
                } else if (selectionKey.isReadable()) {
                    // 13.获取 可读 就绪的通道
                    SocketChannel channel = (SocketChannel) selectionKey.channel();
                    // 14.读取数据 -> 输出
                    int length = 0;
                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                    while ((length = channel.read(byteBuffer)) > 0) {
                        byteBuffer.flip();
                        System.out.println(new String(byteBuffer.array(), 0, length));
                        byteBuffer.clear();
                    }
                }
                // 15.关闭选择器
                iterator.remove();
            }
        }
    }
}
