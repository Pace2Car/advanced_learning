package com.pace2car.java8;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

/**
 * @author chenjiahao
 * @date 2019/10/23 10:32
 */
public class LocalDateTimeDemo {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now.getDayOfWeek());
        System.out.println(now.getDayOfYear());
        LocalDateTime with = now.with(TemporalAdjusters.next(DayOfWeek.TUESDAY));
        System.out.println(with.getDayOfWeek());
        System.out.println(with.getDayOfYear());
    }
}
