package com.pace2car.nio;

import java.nio.ByteBuffer;

/**
 * @author chenjiahao
 * @date 2019/5/31 17:52
 */
public class BufferTest {

    public static void main(String[] args) {
        //  position 位置
        //  limit 可用大小
        //  capacity 最大大小限制
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());
        //  get() 获取 put() 放入
        byteBuffer.put("abcd".getBytes());
        System.out.println("--------------放入数据后-------------");
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());
        System.out.println("--------------读取数据后-------------");
        //  flip() 读取模式，读取完毕会还原
        byteBuffer.flip();
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());
        byte[] bytes = new byte[byteBuffer.limit()];
        byteBuffer.get(bytes);
        System.out.println(new String(bytes, 0, bytes.length));
        System.out.println("--------------重复读取数据后-------------");
        //  rewind() 重复读模式
        byteBuffer.rewind();
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());
        byte[] bytes2 = new byte[byteBuffer.limit()];
        byteBuffer.get(bytes2);
        System.out.println(new String(bytes2, 0, bytes2.length));
        System.out.println("--------------清空数据后-------------");
        // clear() 清空，数据仍存在，position等数据还原
        byteBuffer.clear();
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());
        byte[] bytes3 = new byte[byteBuffer.limit()];
        byteBuffer.get(bytes3);
        System.out.println(new String(bytes3, 0, bytes3.length));
        // mark() 标记位置信息等

        // reset() 还原到mark位置

    }
}
