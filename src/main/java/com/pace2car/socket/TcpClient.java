package com.pace2car.socket;

import java.io.*;
import java.net.Socket;

/**
 * @author chenjiahao
 * @date 2019/5/30 11:16
 */
public class TcpClient {
    public static void main(String[] args) throws IOException {
        System.out.println("tcpClient启动....");
        // 创建
        Socket tcpClient = new Socket("127.0.0.1", 8080);
        OutputStream outputStream = tcpClient.getOutputStream();
        outputStream.write("hello tcpServer".getBytes());
        System.out.println("发送完毕");
        InputStream inputStream = tcpClient.getInputStream();
        // 将字节流转换成String类型
        byte[] bytes = new byte[1024];
        int len = inputStream.read(bytes);
        String msg = new String(bytes, 0, len);
        System.out.println("接收内容：" + msg);
        tcpClient.close();
    }
}
