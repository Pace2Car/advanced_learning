package com.pace2car.java8;

/**
 * @author chenjiahao
 * @date 2019/10/23 10:49
 */
public interface DefaultAndStaticDemo2 {
    /**
     * 常规方法定义
     */
    void method();

    default String sayHalo() {
        return "Hi Halo!";
    }

    /**
     * 默认方法
     * @return
     */
    default String sayHi() {
        return "Hi default! 2";
    }

    /**
     * 默认方法
     * @return
     */
    default String sayHi2() {
        return "2 Hi default! 2";
    }

    /**
     * 静态方法
     */
    static void sayHello() {
        System.out.println("Hello static! 2");
    }
}
