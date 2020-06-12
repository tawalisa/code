package com.lijia.code;

import com.jayway.jsonpath.Filter;
import com.jayway.jsonpath.JsonPath;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.*;

import static com.jayway.jsonpath.Criteria.where;

public class TestJSonPath {
    public static void main(String[] args) {
//        testNumber();
//        testDate();

        for(int i = 0 ; i < 200; i ++){
            System.out.print("\""+i +"\",");
        }
//        OffsetDateTime offsetDateTime = OffsetDateTime.now();
//        List valueAsList = new ArrayList<>();
//        Map map1 = new LinkedHashMap();
//        map1.put("MaximumValue",offsetDateTime);
//        valueAsList.add(map1);
//        Object ret = null;
//        ret = JsonPath.parse(valueAsList).read("$[?]", Filter.filter(where("MaximumValue").gte(new Date())));
//        System.out.println(ret);
    }

    private static void testDate() {
        OffsetDateTime offsetDateTime = OffsetDateTime.now();
        List valueAsList = new ArrayList<>();
        Map map1 = new LinkedHashMap();
        map1.put("MaximumValue",offsetDateTime);
        valueAsList.add(map1);
        map1 = new LinkedHashMap();
        map1.put("MaximumValue",new BigDecimal("372.000000000"));
        valueAsList.add(map1);

        map1 = new LinkedHashMap();
        map1.put("MaximumValue",373.000000000D);
        valueAsList.add(map1);

        map1 = new LinkedHashMap();
        map1.put("MaximumValue",374);
        valueAsList.add(map1);
        Object ret = null;
        ret = JsonPath.parse(valueAsList).read("$[?]", Filter.filter(where("MaximumValue").gte(new Date())));
        System.out.println(ret);
        ret = JsonPath.parse(valueAsList).read("$[?]", Filter.filter(where("MaximumValue").gte(offsetDateTime)));
        System.out.println(ret);
    }

    private static void testNumber() {
        List valueAsList = new ArrayList<>();
        Map map1 = new LinkedHashMap();
        map1.put("MaximumValue","371.000000000");
        valueAsList.add(map1);
        map1 = new LinkedHashMap();
        map1.put("MaximumValue",new BigDecimal("372.000000000"));
        valueAsList.add(map1);

        map1 = new LinkedHashMap();
        map1.put("MaximumValue",373.000000000D);
        valueAsList.add(map1);

        map1 = new LinkedHashMap();
        map1.put("MaximumValue",374);
        valueAsList.add(map1);
        BigDecimal b = new BigDecimal("360.000000000");
        Object ret = JsonPath.parse(valueAsList).read("$[?]", Filter.filter(where("MaximumValue").gte(b)));
        System.out.println(ret);
        ret = JsonPath.parse(valueAsList).read("$[?]", Filter.filter(where("MaximumValue").gte(b.toString())));

        System.out.println(ret);
    }
}
