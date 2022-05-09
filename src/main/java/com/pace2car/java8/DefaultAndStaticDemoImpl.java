package com.pace2car.java8;

/**
 * 默认接口方法实现的测试
 *
 * @author Chen Jiahao
 * @since 2022/5/9 17:08
 */
public class DefaultAndStaticDemoImpl implements DefaultAndStaticDemo, DefaultAndStaticDemo2 {

    @Override
    public void method() {

    }

    public static void main(String[] args) {
        DefaultAndStaticDemoImpl defaultAndStaticDemo = new DefaultAndStaticDemoImpl();
        System.out.println(defaultAndStaticDemo.sayHi());
        System.out.println(defaultAndStaticDemo.sayHi1());
        System.out.println(defaultAndStaticDemo.sayHalo());
        DefaultAndStaticDemo.sayHello();
    }
}
