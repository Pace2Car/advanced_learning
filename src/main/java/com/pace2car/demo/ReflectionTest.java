package com.pace2car.demo;

import lombok.Data;

import java.lang.reflect.Field;

/**
 * 测试反射作用域
 * @author chenjiahao
 * @date 2019/8/21 11:08
 */
public class ReflectionTest {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Demo demo1 = new Demo();
        Field filed1 = demo1.getClass().getDeclaredField("filed1");
        filed1.setAccessible(true);
        filed1.set(demo1, "aaa");
        System.out.println(filed1.get(demo1));
        Field filed2 = demo1.getClass().getDeclaredField("filed1");
        System.out.println(filed2.get(demo1));
    }
}

@Data
class Demo {
    private String filed1;
    private String filed2;
}
