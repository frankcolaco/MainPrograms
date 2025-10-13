package com.examples.time;

import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

public class DateDemo {

    public static void main(String[] args) {

        // current date using now()
        LocalDate date = LocalDate.now();
        System.out.println(date);

        // of() to convert to LocalDate()
        LocalDate convertedDate = LocalDate.of(2019,10,24);
        System.out.println(convertedDate);

        // another flavour
        convertedDate = LocalDate.of(2019, Month.OCTOBER,24);
        System.out.println(convertedDate);

        // parse() to convert to LocalDate()
        LocalDate strToLocalDate = LocalDate.parse("2017-01-22");
        System.out.println(strToLocalDate);

        // parse() with specified date format
        strToLocalDate = LocalDate.parse("22-01-2017", DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        System.out.println(strToLocalDate);

        // adding days and month to given date

        System.out.println("plus 1 day:: "+strToLocalDate.plusDays(1));
        System.out.println("plus 3months:: "+strToLocalDate.plusMonths(3));

        //getting day of the week
        System.out.println("day of the week:: "+strToLocalDate.getDayOfWeek());

        boolean isBefore = convertedDate.isBefore(strToLocalDate);
        System.out.println("isBefore:: "+isBefore);

        boolean isAfter = convertedDate.isAfter(strToLocalDate);
        System.out.println("isAfter:: "+isAfter);

    }
}
