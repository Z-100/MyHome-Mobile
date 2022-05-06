package com.myhome.other;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Logger {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    // 2021-03-24 16:48:05
    private static final SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String log(String type, String location, String message) {

        String current = sdf3.format(new Timestamp(System.currentTimeMillis()));

        System.out.printf("%s - [%s] at %s\t- %s%n", current, type, location , message);

        return message;
    }
}
