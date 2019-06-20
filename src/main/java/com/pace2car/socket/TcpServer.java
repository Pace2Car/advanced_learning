package com.pace2car.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author chenjiahao
 * @date 2019/5/30 11:46
 */
public class TcpServer {
    public static void main(String[] args) throws IOException {

        System.out.println("tcpServer启动....");
        ExecutorService executorService = Executors.newCachedThreadPool();
        // 创建连接
        ServerSocket tcpServer = new ServerSocket(8080);
        try {
            while (true) {
                // 接受请求 阻塞
                Socket socket = tcpServer.accept();
                System.out.println("客户端已连接,IP:" + socket.getRemoteSocketAddress());
                executorService.execute(() -> {
                    try {
                        InputStream inputStream = socket.getInputStream();
                        // 将字节流转换成String类型
                        byte[] bytes = new byte[1024];
                        int len = inputStream.read(bytes);
                        String msg = new String(bytes, 0, len);
                        System.out.println("接收内容：" + msg);
                        OutputStream outputStream = socket.getOutputStream();
                        outputStream.write("hello tcpClient".getBytes());
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                    } finally {
                        try {
                            socket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            tcpServer.close();
        }
    }
}
