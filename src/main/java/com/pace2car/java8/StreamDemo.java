package com.pace2car.java8;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author chenjiahao
 * @date 2019/10/22 16:32
 */
public class StreamDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("s1");
        list.add("s2");
        list.add("s3");
        list.add("s4");
        list.add("s5");

        List<String> collect = list.stream().filter(s -> "s1".equals(s)).collect(Collectors.toList());
        collect.forEach(System.out::println);

    }
}
