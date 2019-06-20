package com.pace2car.jvm;

/**
 * @author Pace2Car
 * @date 2019/4/30 14:55
 */
public class TestGCLog {
    public static void main(String[] args) {
        // -Xms20m -Xmx20m
        // -XX:+UseSerialGC -XX:+PrintGCDetails
        byte[] b = null;
        for (int i = 0; i < 10; i++) {
            b = new byte[1024 * 1024];
        }
    }
}
