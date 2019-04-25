package com.pace2car.lock;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Pace2Car
 * @date 2019/4/22 9:46
 */
public class AtomicTest implements Runnable {
    /**
     * 原子类
     * 底层为CAS无锁机制，乐观锁实现
     * 线程安全的自增变量
     * 但底层没有上锁
     */
    AtomicInteger atomicInteger = new AtomicInteger();

    @Override
    public void run() {
        while (true) {
            Integer count = getCount();
            if (count > 100) {
                break;
            }
            System.out.println(count);
        }
    }

    public Integer getCount() {
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return atomicInteger.incrementAndGet();
    }

    public static void main(String[] args) {
        AtomicTest atomicTest = new AtomicTest();
        new Thread(atomicTest).start();
        new Thread(atomicTest).start();

    }
}
