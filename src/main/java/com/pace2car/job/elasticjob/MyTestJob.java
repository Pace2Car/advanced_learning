package com.pace2car.job.elasticjob;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;

import java.time.LocalDateTime;

/**
 * @author Pace2Car
 * @date 2019/6/27 11:05
 */
public class MyTestJob implements SimpleJob {
    @Override
    public void execute(ShardingContext shardingContext) {
        System.out.println(LocalDateTime.now());
    }
}
