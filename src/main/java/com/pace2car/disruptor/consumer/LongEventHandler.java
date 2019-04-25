package com.pace2car.disruptor.consumer;

import com.lmax.disruptor.EventHandler;
import com.pace2car.disruptor.entity.LongEvent;

/**
 * 事件消费者
 * 获取生产者推送的数据
 * @author Pace2Car
 * @date 2019/4/24 10:23
 */
public class LongEventHandler implements EventHandler<LongEvent> {

    @Override
    public void onEvent(LongEvent longEvent, long l, boolean b) throws Exception {
        System.out.println("消费者消费数据：" + longEvent.getValue());
    }
}
