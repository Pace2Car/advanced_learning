package com.pace2car.lock;

/**
 * 重入synchronized
 * @author Pace2Car
 * @date 2019/4/17 10:12
 */
public class ReentrantSynchronizedTest implements Runnable {
    @Override
    public void run() {
        set();
    }

    public synchronized void set() {
        System.out.println("set");
        get();
    }

    public synchronized void get() {
        System.out.println("get:重入了set的锁");
    }

    public static void main(String[] args) {
        new Thread(new ReentrantSynchronizedTest()).start();
    }
}
