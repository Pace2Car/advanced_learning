package com.pace2car.demo;

import org.apache.commons.lang3.RandomUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @author chenjiahao
 * @date 2019/5/17 14:34
 */
public class TestList {
    public static void main(String[] args) throws ParseException {
        List<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("aaa");
        list.remove("aaa");
        System.out.println(list.toString());

        // test substring & timeMills
        for (int i = 0; i < 100; i++) {
            int randomInt = (int) ((Math.random() * 9 + 1) * 100000);
            System.out.println(randomInt);
        }
        Long temp = 1564727846995123456L;
        String substring = temp.toString().substring(0, 13);
        System.out.println(Long.valueOf(substring));
        Date date = new Date(2000027846995L);
        System.out.println(date);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date parse = simpleDateFormat.parse("2019-08-03 23:59:59");
        System.out.println(parse.getTime());
    }
}
