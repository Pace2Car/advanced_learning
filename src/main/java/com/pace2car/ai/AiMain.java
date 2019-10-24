package com.pace2car.ai;

import java.util.Scanner;

/**
 * @author Pace2Car
 * @date 2019/7/25 9:19
 */
public class AiMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str;
        while (true) {
            str = sc.next();
            str = str.replace("吗", "");
            str = str.replace("?", "!");
            str = str.replace("？", "！");
            System.out.println(str);
        }
    }
}
