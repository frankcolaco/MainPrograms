package com.examples.time;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Set;

public class ZoneDateTimeDemo {


    /*
    The ZonedDateTime represents date and time with zone information
    In this class we need to provide ZoneId, ZoneId is identifier used to represent different zones.
     */
    public static void main(String[] args) {

        //fetching zoneId for given zone
        ZoneId zoneId = ZoneId.of("America/Marigot");
        System.out.println("zoneId:: "+zoneId);

        Set<String> listOfZoneId = ZoneId.getAvailableZoneIds();
        listOfZoneId.forEach(System.out::println);

        //creating ZonedDateTime using now and of

        ZonedDateTime zDateTime = ZonedDateTime.now();
        System.out.println(zDateTime);

        ZonedDateTime ofZonedDateTime = ZonedDateTime.of(2019,10,24,12,24,30,22233,ZoneId.of("Canada/Atlantic"));
        System.out.println(ofZonedDateTime);

        //fetching date and time of a zonedDateTime

        System.out.println("Year:: "+ ofZonedDateTime.getYear());
        System.out.println("Month:: "+ofZonedDateTime.getMonth());
        System.out.println("Day of Month:: "+ofZonedDateTime.getDayOfMonth());
        System.out.println("Day of week:: "+ofZonedDateTime.getDayOfWeek());
        System.out.println("Day of Year:: "+ofZonedDateTime.getDayOfYear());
        System.out.println("Minute of the day:: "+ofZonedDateTime.getMinute());

        // modifying date and time
        System.out.println("Current Date plus 2 months:: "+zDateTime.plusMonths(2));
        System.out.println("Current Date plus 2 years:: "+zDateTime.plusYears(2));
        System.out.println("Current Date plus 2 days:: "+zDateTime.plusDays(2));
        System.out.println("Current Date plus 2 minutes:: "+zDateTime.plusMinutes(2));
    }
}
