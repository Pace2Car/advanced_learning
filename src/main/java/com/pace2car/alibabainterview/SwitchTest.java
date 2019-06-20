package com.pace2car.alibabainterview;

/**
 * @author Pace2Car
 * @date 2019/6/17 15:26
 */
public class SwitchTest {
    public static void main(String[] args) {
        String param = null;
        switch (param) {
            case "null":
                System.out.println("null");
                break;
            default:
                System.out.println("default");
        }
    }
}
