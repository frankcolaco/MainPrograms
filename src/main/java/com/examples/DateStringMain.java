package com.examples;

import io.micrometer.common.util.StringUtils;

import java.text.SimpleDateFormat;
import java.time.ZoneOffset;
import java.util.TimeZone;

public class DateStringMain {

    public static final String DATE_FORMAT = "yyyy-MM-dd";
    public static final String OPEN_PARENTHESIS = "(";
    public static final String CLOSE_PARENTHESIS = ")";

    public static void main(String[] args) {

    }

    public static String findDatetimeFromString(String stringEpoch) {
        if (StringUtils.isNotBlank(stringEpoch) && stringEpoch.contains(OPEN_PARENTHESIS) && stringEpoch.contains(CLOSE_PARENTHESIS) && stringEpoch.length() < 28) {
            try {
                String substring = stringEpoch.substring(stringEpoch.indexOf(OPEN_PARENTHESIS) + 1, stringEpoch.indexOf(CLOSE_PARENTHESIS));
                String epoch = (substring.length() == 19) ? substring.substring(1, substring.length() - 5) : substring.substring(0, substring.length() - 5);
                String offset = substring.substring(substring.length() - 5);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT);
                ZoneOffset zoneOffSet = ZoneOffset.of(offset);
                simpleDateFormat.setTimeZone(TimeZone.getTimeZone(zoneOffSet));
                return simpleDateFormat.format(Long.valueOf(epoch));
            } catch (Exception e) {
                System.out.println("Datetime: [{}], parsing failed"+ stringEpoch);
                return null;
            }
        } else {
            System.out.println("Datetime received in unexpected format: [{}], parsing failed. Expected: [/Date(xxxxxxxxxxxxx+xxxx)/ Or /Date(-xxxxxxxxxxxxx+xxxx)/]"+ stringEpoch);
        }
        return null;
    }
}
