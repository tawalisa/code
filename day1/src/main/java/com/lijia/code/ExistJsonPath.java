package com.lijia.code;

import com.jayway.jsonpath.Filter;
import com.jayway.jsonpath.JsonPath;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.*;

import static com.jayway.jsonpath.Criteria.where;

public class ExistJsonPath {
    public static void main(String[] args) {
        testExist();
    }

    private static void testExist() {

        List valueAsList = new ArrayList<>();
        Map map1 = new LinkedHashMap();
        map1.put("MaximumValue",1);
        map1.put("MaximumValue1",2);
        List attrList = new ArrayList<>();
        valueAsList.add(map1);

        map1 = new LinkedHashMap();
        map1.put("MaximumValue",3);
        valueAsList.add(map1);

        map1 = new LinkedHashMap();
        map1.put("MaximumValue",4);
        valueAsList.add(map1);
        Object ret = null;
        ret = JsonPath.parse(valueAsList).read("$[?]", Filter.filter(where("MaximumValue1").exists(false)));
        System.out.println(ret);
//        ret = JsonPath.parse(valueAsList).read("$[?]", Filter.filter(where("MaximumValue").gte(offsetDateTime)));
//        System.out.println(ret);
    }
}
