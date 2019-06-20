package com.pace2car.alibabainterview;

import java.math.BigDecimal;

/**
 * @author Pace2Car
 * @date 2019/6/17 15:27
 */
public class BigDecimalTest {
    public static void main(String[] args) {
        BigDecimal a = new BigDecimal(0.1);
        System.out.println(a);
        BigDecimal b = new BigDecimal("0.1");
        System.out.println(b);
        if (a.equals(b)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}
