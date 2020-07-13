package com.lijia.code;

import org.apache.commons.lang3.StringUtils;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Objects;
import java.util.regex.Pattern;

public class TimeZone {
    public static void main(String[] args) {
        Instant instant = Instant.now();
        instant.plus(10, ChronoUnit.DAYS);
        System.out.println(instant.toEpochMilli());
        OffsetDateTime offsetDateTime = OffsetDateTime.ofInstant(instant, ZoneId.systemDefault());
        System.out.println(offsetDateTime);
        offsetDateTime = OffsetDateTime.ofInstant(instant, ZoneOffset.UTC);
        System.out.println(offsetDateTime);

        LocalDate localDate=  instant.atOffset(ZoneOffset.UTC).toLocalDate();
        System.out.println(localDate);

        LocalTime localTime=  instant.atOffset(ZoneOffset.UTC).toLocalTime();
        System.out.println(localTime);
        offsetDateTime = instant.atOffset(ZoneOffset.UTC);

    }



    enum DateTimeNowInterval {
        SECOND,
        MINUTE,
        HOUR,
        DAY,
        MONTH,
        YEAR;

        public TemporalUnit convertTemporalUnit() {
            switch (this) {
                case SECOND:
                    return ChronoUnit.SECONDS;
                case MINUTE:
                    return ChronoUnit.MINUTES;
                case HOUR:
                    return ChronoUnit.HOURS;
                case DAY:
                    return ChronoUnit.DAYS;
                case MONTH:
                    return ChronoUnit.MONTHS;
                case YEAR:
                    return ChronoUnit.YEARS;
                default:
                    throw new RuntimeException(String.format("not support interval type: %s", this));
            }
        }
    }
}
