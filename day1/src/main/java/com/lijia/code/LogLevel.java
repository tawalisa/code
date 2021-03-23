package com.lijia.code;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class LogLevel {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();

        map.put("user1", "Debug");
        map.put("user2", "Info");
        map.put("user3", "Error");


        logprint("1");

        MDC.put("level", "info");
        logprint("2");
        MDC.remove("level");
        MDC.put("level", "Error");
        logprint("3");
        MDC.remove("level");

    }

    private static void logprint(String s) {
        log.debug(s);
        log.info(s);
        log.error(s);
        log.warn(s);
    }

}
