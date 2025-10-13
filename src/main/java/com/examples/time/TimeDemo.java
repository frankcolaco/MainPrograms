package com.examples.time;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TimeDemo {

    public static void main(String[] args) {

        // time using now();
        LocalTime time = LocalTime.now();
        System.out.println(time);

        // getting specific time using of()
        LocalTime strTime = LocalTime.of(11, 0);
        System.out.println(strTime);
        strTime = LocalTime.of(9,25,33);
        System.out.println(strTime);

        //specific time using parse()
        LocalTime parseTime = LocalTime.parse("13:25");
        System.out.println(parseTime);

        //specific time using parse and datetime formatter
        LocalTime parseFmtTime = LocalTime.parse("02:20", DateTimeFormatter.ofPattern("HH:mm"));
        System.out.println(parseFmtTime);

        //adding seconds, minutes and hours to a given time

        System.out.println("current time plus 1hour:: "+time.plusHours(1));
        System.out.println("current time plus 1min:: "+time.plusMinutes(1));

        //getting minute from time

        System.out.println(parseTime.getMinute());

        System.out.println("isBefore:: "+parseTime.isBefore(time));
        System.out.println("isAfter:: "+parseTime.isAfter(time));
    }
}
