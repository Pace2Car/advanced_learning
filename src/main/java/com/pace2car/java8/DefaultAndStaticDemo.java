package com.pace2car.java8;

/**
 * @author chenjiahao
 * @date 2019/10/23 10:49
 */
public interface DefaultAndStaticDemo {
    /**
     * 常规方法定义
     */
    void method();

    /**
     * 默认方法
     * @return
     */
    //default String sayHi() {
    //    return "Hi default! 1";
    //}

    /**
     * 默认方法
     * @return
     */
    default String sayHi1() {
        return "1 Hi default! 1";
    }

    /**
     * 静态方法
     */
    static void sayHello() {
        System.out.println("Hello static! 1");
    }
}
