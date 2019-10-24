package com.pace2car.ai;

/**
 * @author chenjiahao
 * @date 2019/8/12 14:00
 */
public class VersionAlgorithm {

    public static void main(String[] args) {
        String a = "32.111.3";
        String b = "32.123.24";
        Boolean i = checkVersion(a, b);

        System.out.println(i);
    }

    private static Boolean checkVersion(String availableVersion, String appVersion) {
        String[] availableVersionArray = availableVersion.split("\\.");
        String[] appVersionArray = appVersion.split("\\.");
        if (availableVersionArray.length != appVersionArray.length) {
            return false;
        }
        for (int i = 0; i < availableVersionArray.length; i++) {
            if (Integer.valueOf(availableVersionArray[i]) > Integer.valueOf(appVersionArray[i])) {
                return false;
            }
        }
        return true;
    }
}
