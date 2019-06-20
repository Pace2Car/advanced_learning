package com.pace2car.disruptor.producer;

import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import com.pace2car.disruptor.consumer.LongEventHandler;
import com.pace2car.disruptor.entity.LongEvent;
import com.pace2car.disruptor.factory.LongEventFactory;

import java.nio.ByteBuffer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Pace2Car
 * @date 2019/4/24 10:27
 */
public class Main {
    public static void main(String[] args) {
        // 创建线程池，提供给consumer
        ExecutorService executor = Executors.newCachedThreadPool();
        // 创建事件工厂
        EventFactory<LongEvent> eventFactory = new LongEventFactory();
        // 创建一个ringbuffer大小, 一定要为2的n次方
        int ringbuffer = 1024 * 1024;
        // 创建Disruptor
        Disruptor<LongEvent> disruptor = new Disruptor<>(eventFactory, ringbuffer, executor, ProducerType.MULTI, new YieldingWaitStrategy());
        // 连接消费者-注册消费者
        disruptor.handleEventsWith(new LongEventHandler());
        // 启动disruptor
        disruptor.start();
        // 创建RingBuffer容器
        RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();
        // 创建生产者
        LongEventProducer longEventProducer = new LongEventProducer(ringBuffer);
        // 指定缓冲区大小
        ByteBuffer byteBuffer = ByteBuffer.allocate(8);
        for (int i = 0; i < 100; i++) {
            byteBuffer.putLong(0, i);
            longEventProducer.onDate(byteBuffer);
        }
        // 停止服务
        executor.shutdown();
        disruptor.shutdown();
    }
}
