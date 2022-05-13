package com.pace2car.singleton;

import java.io.ObjectStreamException;

/**
 * 单例模式
 * @author Chen Jiahao
 * @since 2022/5/10 10:34
 */
public class Singleton {


    private static final Singleton INSTANCE_HUNGER = new Singleton();
    private static Singleton INSTANCE_LAZY;
    private volatile static Singleton INSTANCE_DOUBLE_CHECK_LOCKING;

    /**
     * 确保单例类只能被自己初始化
     */
    private Singleton() {}

    /**
     * 饿汉初始化实例
     * 饿汉：在创建类时创建实例，无线程安全问题
     * 缺点：无法根据配置文件参数创建
     */
    public static Singleton getInstanceHunger() {
        return INSTANCE_HUNGER;
    }

    /**
     * 懒汉：在初次调用时初始化
     * 必须在获取方法加synchronized解决线程安全问题
     */
    public static synchronized Singleton getInstanceLazy() {
        if (INSTANCE_LAZY == null) {
            INSTANCE_LAZY = new Singleton();
        }
        return INSTANCE_LAZY;
    }

    /**
     * 双重检验锁：优化懒汉锁代码块问题
     * 必须在获取方法加synchronized解决线程安全问题
     */
    private static Singleton getInstanceDoubleCheckLocking() {
        if (INSTANCE_DOUBLE_CHECK_LOCKING == null) {
            synchronized (Singleton.class) {
                if (INSTANCE_DOUBLE_CHECK_LOCKING == null) {
                    INSTANCE_DOUBLE_CHECK_LOCKING = new Singleton();
                }
            }
        }
        return INSTANCE_DOUBLE_CHECK_LOCKING;
    }

    private static class SingletonHolder {
        private static final Singleton INSTANCE_INNER_CLASS = new Singleton();
    }

    /**
     * 静态内部类：JVM层面保证线程安全
     */
    private static Singleton getInstanceInnerClass() {
        return SingletonHolder.INSTANCE_INNER_CLASS;
    }

    /**
     * 钩子函数，JDK在序列化的时候自动查找运行
     * 通过readResolve方法来使反序列化恢复的对象和用new关键字创建的对象是同一个
     * 解决序列化/反序列化破坏单例的问题
     */
    private Object readResolve() {
        return INSTANCE_HUNGER;
    }


    /**
     * 枚举实现单例：解决序列化/反序列化、反射破坏单例的问题
     */
    public enum EnumSingleton {
        /**
         * 单例实体
         */
        SINGLETON;

        private String name = "000";

        public String sayHi() {
            return "Hi, my name is " + SINGLETON.name;
        }

        public void setName(String name) {
            SINGLETON.name = name;
        }

        public String getName() {
            return SINGLETON.name;
        }
    }

    public static void main(String[] args) {
        EnumSingleton singleton = EnumSingleton.SINGLETON;
        System.out.println(singleton.sayHi());

        singleton.setName("111");

        EnumSingleton singleton2 = EnumSingleton.SINGLETON;

        System.out.println(singleton2.sayHi());

    }
}
