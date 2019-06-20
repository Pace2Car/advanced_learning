package com.pace2car.jvm;

/**
 * @author Pace2Car
 * @date 2019/4/30 15:00
 */
public class TestRatio {
    public static void main(String[] args) {
        // -XX:+UseSerialGC -XX:+PrintGCDetails
        // -Xms20m -Xmx20m
        // -Xmn5m -XX:SurvivorRatio=2
        // -XX:NewRatio=2
        byte[] b = null;
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            b = new byte[1024 * 1024];
        }
    }
}
