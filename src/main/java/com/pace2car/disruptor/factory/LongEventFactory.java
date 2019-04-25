package com.pace2car.disruptor.factory;

import com.lmax.disruptor.EventFactory;
import com.pace2car.disruptor.entity.LongEvent;

/**
 * 工厂 实例化event
 * @author Pace2Car
 * @date 2019/4/24 10:16
 */
public class LongEventFactory implements EventFactory<LongEvent> {
    @Override
    public LongEvent newInstance() {
        return new LongEvent();
    }
}
