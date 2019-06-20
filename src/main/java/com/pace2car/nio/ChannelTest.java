package com.pace2car.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author chenjiahao
 * @date 2019/6/3 15:02
 */
public class ChannelTest {
    public static void main(String[] args) throws IOException {
        // 非直接缓冲
        testIndirectBuffer();
        // 直接缓冲
        testDirectBuffer();
    }

    /**
     * 直接缓冲
     *
     * @throws IOException
     */
    private static void testDirectBuffer() throws IOException {
        long currentTimeMillis = System.currentTimeMillis();
        // 创建通道
        FileChannel inChannel = FileChannel.open(Paths.get("E://1.mp4"), StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("E://2.mp4"), StandardOpenOption.READ, StandardOpenOption.WRITE, StandardOpenOption.CREATE);
        // 定义映射文件
        MappedByteBuffer inMappedByteBuffer = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
        MappedByteBuffer outMappedByteBuffer = outChannel.map(FileChannel.MapMode.READ_WRITE, 0, inChannel.size());
        // 直接对缓冲区操作
        byte[] bytes = new byte[inMappedByteBuffer.limit()];
        inMappedByteBuffer.get(bytes);
        outMappedByteBuffer.put(bytes);
        inChannel.close();
        outChannel.close();
        System.out.println("直接缓冲：" + (System.currentTimeMillis()-currentTimeMillis) + "ms");
    }

    /**
     * 非直接缓冲
     * @throws IOException
     */
    private static void testIndirectBuffer() throws IOException {

        long currentTimeMillis = System.currentTimeMillis();
        FileInputStream fis = new FileInputStream("E://1.mp4");
        FileOutputStream fos = new FileOutputStream("E://3.mp4");
        // 创建通道
        FileChannel inChannel = fis.getChannel();
        FileChannel outChannal = fos.getChannel();
        // 分配缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        while (inChannel.read(byteBuffer) != -1) {
            // 开启文件读写
            byteBuffer.flip();
            outChannal.write(byteBuffer);
            byteBuffer.clear();
        }
        inChannel.close();
        outChannal.close();
        fos.close();
        fis.close();
        System.out.println("非直接缓冲：" + (System.currentTimeMillis()-currentTimeMillis) + "ms");
    }
}
