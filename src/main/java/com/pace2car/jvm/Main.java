package com.pace2car.jvm;

/**
 * @author Pace2Car
 * @date 2019/4/30 10:46
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("最大内存：" + Runtime.getRuntime().maxMemory() / 1024 / 1024 + "M");
        System.out.println("可用内存：" + Runtime.getRuntime().freeMemory() / 1024 / 1024 + "M");
        System.out.println("已使用内存：" + Runtime.getRuntime().totalMemory() / 1024 / 1024 + "M");

//       byte[] bytes = new byte[13 * 1024 * 1024];
       Byte[] bytess = new Byte[3 * 1024 * 1024];
    }
}
