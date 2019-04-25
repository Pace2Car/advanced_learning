package com.pace2car.juc;

import java.util.concurrent.*;

/**
 * @author Pace2Car
 * @date 2019/3/25 10:33
 */
public class CallableThreadPoolTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        Future<String> submit = cachedThreadPool.submit(new CallableTask());
        String result = submit.get();
        System.out.println("callable result: " + result);
    }
}

class CallableTask implements Callable<String> {

    @Override
    public String call() throws Exception {
        return "hello future";
    }
}


