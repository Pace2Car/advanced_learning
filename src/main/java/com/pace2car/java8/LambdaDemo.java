package com.pace2car.java8;

import java.util.function.BinaryOperator;
import java.util.function.Consumer;

/**
 * @author chenjiahao
 * @date 2019/10/22 14:53
 */
public class LambdaDemo {
    public static void main(String[] args) {
        // 匿名内部类实现
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("anno");
            }
        };

        // lambda表达式
        Runnable r2 = () -> System.out.println("lambda");

        Consumer<String> c1 = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };

        Consumer<String> c2 = s -> System.out.println(s);

        BinaryOperator<Long> b1 = new BinaryOperator<Long>() {
            @Override
            public Long apply(Long x, Long y) {
                System.out.println("hello");
                return x + y;
            }
        };

        BinaryOperator<Long> b2 = (x, y) -> x + y;
    }
}
