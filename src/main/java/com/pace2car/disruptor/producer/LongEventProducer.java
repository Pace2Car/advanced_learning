package com.pace2car.disruptor.producer;

import com.lmax.disruptor.RingBuffer;
import com.pace2car.disruptor.entity.LongEvent;

import java.nio.ByteBuffer;

/**
 * 事件生产者
 * @author Pace2Car
 * @date 2019/4/25 11:16
 */
public class LongEventProducer {
    private RingBuffer<LongEvent> ringBuffer;

    public LongEventProducer(RingBuffer<LongEvent> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }

    public void onDate(ByteBuffer byteBuffer) {
        // 获取时间队列下标位置
        long sequence = ringBuffer.next();
        try {
            // 取出空队列（Event）
            LongEvent longEvent = ringBuffer.get(sequence);
            // 给空队列赋值
            longEvent.setValue(byteBuffer.getLong(0));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("生产者发送数据..." + sequence);
            // 推送数据
            ringBuffer.publish(sequence);
        }
    }
}
