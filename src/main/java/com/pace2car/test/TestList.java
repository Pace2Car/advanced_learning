package com.pace2car.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenjiahao
 * @date 2019/5/17 14:34
 */
public class TestList {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("aaa");
        list.remove("aaa");
        System.out.println(list.toString());
    }
}
