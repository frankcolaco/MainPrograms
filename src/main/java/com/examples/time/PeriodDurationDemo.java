package com.examples.time;

import java.time.*;

public class PeriodDurationDemo {


    /*
    Period represents date-based amount of time in ISO-8601 calendar system, such as 2 years, 3 months and 4 days.
    This class is used to modify a given date or find a difference between dates.
     */

    public static void main(String[] args) {

        //creating period
        Period period = Period.ofDays(3);
        System.out.println(period.getDays());

        Period pMonths = Period.ofMonths(2);
        System.out.println(pMonths.getMonths());

        Period pYears = Period.ofYears(3);
        System.out.println(pYears.getYears());

        Period pYearMonthDays = Period.of(2,1,4);
        System.out.println(pYearMonthDays.getDays()+" "+pYearMonthDays.getMonths()+" "+pYearMonthDays.getYears());

        // finding difference between two dates

        Period diffPeriod = Period.between(LocalDate.parse("2019-10-24"),LocalDate.now());
        System.out.println(diffPeriod);
        // getting specific value from Period

        int year = diffPeriod.getYears();
        int day = diffPeriod.getDays();
        int month = diffPeriod.getMonths();
        System.out.println("Difference between two days is:: "+ year +" year " + day+" day(s) "+ month+" month(s)");

        /*
        Duration represents time-based amount of time in ISO-8601 calendar system suc as 8 minutes.
         */

        // creating duration

        Duration duration = Duration.ofDays(1);
        System.out.println(duration.getSeconds()+" seconds");

        duration = Duration.ofHours(2);
        System.out.println(duration.getSeconds()+" seconds");

        // difference between two values

        Duration diffDuration = Duration.between(LocalTime.parse("12:14"),LocalTime.parse("13:00"));
        System.out.println("Difference is "+diffDuration.getSeconds()+" seconds");
    }
}
