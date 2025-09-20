package com.examples;

import java.time.*;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class VoidMain {

    public static void main(String[] args) {

        System.out.println("isNextDayApplicable:: "+isNextDayApplicable("2025-05-06T01:34:00","840","UNITED STATES", TimezoneEnum.PST));

    }

    public static boolean isNextDayApplicable(String date, String pccCountryCode, String pccCountryName, TimezoneEnum zoneId) {
        boolean isWeekend = false;
        boolean isHoliday = false;
        boolean incrementTimeLimit = true;
        boolean isNextDayRuleApplicable = false;

        // Check whether particular country has specified rule
        String nextDayRuleCC = "840";


            // Ticket creation date
            ZonedDateTime creationDate = ZonedDateTime.of(LocalDateTime.parse(date), ZoneId.of(zoneId.getZoneId()));
        System.out.println("CreationDate: " + creationDate);
            // TimeLimit to void the ticket
            ZonedDateTime nextDayTimeLimit = ZonedDateTime.of(creationDate.toLocalDate().plusDays(1), LocalTime.MAX,
                    ZoneId.of(zoneId.getZoneId()));
        System.out.println("NextDayTimeLimit: " + nextDayTimeLimit);

            // Increment TimeLimit in case of Weekend, Holidays
            while (incrementTimeLimit) {
                isWeekend = isWeekend(pccCountryCode, pccCountryName, zoneId, isWeekend, nextDayTimeLimit);
                isHoliday = isHoliday(pccCountryCode, pccCountryName, zoneId, isHoliday, nextDayTimeLimit);
                if (isWeekend || isHoliday) {
                    nextDayTimeLimit = ZonedDateTime.of(nextDayTimeLimit.toLocalDateTime().plusDays(1),
                            ZoneId.of(zoneId.getZoneId()));
                } else {
                    incrementTimeLimit = false;
                }
            }

            ZonedDateTime currentDateTime = ZonedDateTime.now(ZoneId.of(zoneId.getZoneId()));
            // Check CurrentDate is within specified TimeLimit and void the ticket
            if (!currentDateTime.isBefore(creationDate) && currentDateTime.isBefore(nextDayTimeLimit)) {
                isNextDayRuleApplicable = true;
            } else {
                System.out.println("CurrentDateTime is not within NextDayTimeLimit");
            }

        return isNextDayRuleApplicable;
    }

    public static boolean isWeekend(String pccCountryCode, String pccCountryName, TimezoneEnum zoneId, boolean isWeekend,
                             ZonedDateTime nextDayTimeLimit) {

        List<String> weekendDaysForCountries = new ArrayList<>();
        String weekendRuleCC = "840";


            Locale[] locales = Locale.getAvailableLocales();
            String languageTag = "";
            for (Locale locale : locales) {
                if (locale.getDisplayCountry().equalsIgnoreCase(pccCountryName)) {
                    languageTag = locale.toLanguageTag();
                    break;
                }
            }

            DayOfWeek startDate = WeekFields.of(Locale.forLanguageTag(languageTag)).getFirstDayOfWeek();
            DayOfWeek endDate = WeekFields.of(Locale.forLanguageTag(languageTag)).getFirstDayOfWeek().minus(1);
            weekendDaysForCountries.add(startDate.toString());
            weekendDaysForCountries.add(endDate.toString());

            if (weekendDaysForCountries.contains(nextDayTimeLimit.getDayOfWeek().toString())) {
                isWeekend = true;
            } else {
                isWeekend = false;
            }

        return isWeekend;
    }

    /**
     * Method to decide whether given date is holiday or not
     *
     * @param pccCountryCode
     * @param pccCountryName
     * @param zoneId
     * @param isHoliday
     * @return
     */
    public static boolean isHoliday(String pccCountryCode, String pccCountryName, TimezoneEnum zoneId, boolean isHoliday,
                             ZonedDateTime nextDayTimeLimit) {
        String holidayRuleCC = "840";

        return false;
    }
}
 enum TimezoneEnum {
    MST("America/Phoenix"),
    PST("America/Los_Angeles"),
    CST("America/Chicago"),
    BST("Europe/London");

    private String zoneId;

    TimezoneEnum(String timezone) {
        this.zoneId = timezone;
    }

    public String getZoneId() {
        return zoneId;
    }
}