package com.examples.time;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateTimeDemo {

    public static void main(String[] args) {

        //datetime using now()
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println(dateTime);

        //getting specific datetime using of()

        LocalDateTime strDateTime = LocalDateTime.of(2019,10,24,12,24);
        System.out.println(strDateTime);

        //specific datetime using parse()
        LocalDateTime parseDateTime = LocalDateTime.parse("2019-10-24T12:34");
        System.out.println(parseDateTime);

        //modifying given date
        System.out.println(parseDateTime.plusDays(4));

        System.out.println(strDateTime.plusMonths(2));
    }
}
