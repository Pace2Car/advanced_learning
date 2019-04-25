package com.pace2car.disruptor.entity;

import lombok.Data;

/**
 * event 生产者和消费者传递的数据类型
 * @author Pace2Car
 * @date 2019/4/24 10:17
 */
@Data
public class LongEvent {

    private Long value;

}
