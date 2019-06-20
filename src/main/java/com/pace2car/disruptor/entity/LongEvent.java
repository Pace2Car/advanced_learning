package com.pace2car.disruptor.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * event 生产者和消费者传递的数据类型
 * @author Pace2Car
 * @date 2019/4/24 10:17
 */
@Data
@Accessors(chain = true)
public class LongEvent implements Serializable {

    private static final long serialVersionUID = -4254760449273108943L;

    private Long value;

}
