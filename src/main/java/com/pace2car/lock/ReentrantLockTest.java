package com.pace2car.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 可重入锁
 * @author Pace2Car
 * @date 2019/4/17 10:20
 */
public class ReentrantLockTest implements Runnable {
    Lock lock = new ReentrantLock();

    @Override
    public void run() {
        set();
    }

    public synchronized void set() {
        try {
            lock.lock();
            System.out.println("set");
            get();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public synchronized void get() {
        try {
            lock.lock();
            System.out.println("get:重入了set的锁");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        new Thread(new ReentrantSynchronizedTest()).start();
    }
}
