package com.lijia.code;



import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class LocalTimeTest {
    public static void main(String[] args) throws Exception {
        System.out.println(serialize("09:07:05.003233999"));
        System.out.println(LocalTime.now());
        System.out.println(serialize(LocalTime.now()));
    }

    public static String getFormatterPattern(String timeInput) {
        String pattern = "HH:mm:ss";
        if (StringUtils.isEmpty(timeInput)) {
            return pattern;
        }
        if (timeInput.contains(".")) {
            int nanoInputLength = timeInput.split("\\.")[1].length();
            String nano = StringUtils.repeat('S', nanoInputLength);
            pattern = String.format("%s.%s", pattern, nano);
        }
        return pattern;
    }
    public static DateTimeFormatter getFormatter(Object timeIput) {
        return DateTimeFormatter.ofPattern(getFormatterPattern(timeIput.toString()));
    }

    public static String serialize(Object input) throws Exception {
        if (input instanceof LocalTime) {
            LocalTime localTime = (LocalTime)input;
            return getFormatter(localTime).format(localTime);
        } else {
            LocalTime result = convertToLocalTime(input);
            if (result == null) {
                throw new Exception("Invalid value '" + input + "' for LocalTime");
            }
            return getFormatter(input).format(result);
        }
    }
    private static LocalTime convertToLocalTime(Object input) {
        if (input instanceof String) {
            try {
                return LocalTime.parse(input.toString(), getFormatter(input));
            } catch (DateTimeParseException ignored) {
                ignored.printStackTrace();
            }
        }
        return null;
    }
}
