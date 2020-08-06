package com.lijia.code;
import com.fasterxml.jackson.databind.JsonNode;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.burt.jmespath.Adapter;
import io.burt.jmespath.BaseRuntime;
import io.burt.jmespath.JmesPath;
import io.burt.jmespath.Expression;
import io.burt.jmespath.jackson.JacksonRuntime;
import io.burt.jmespath.jcf.JcfRuntime;

import java.util.LinkedHashMap;
import java.util.Map;

public class JemspathTest {


    public static void main(String[] args) {

        map2json();
        map();
    }

    private static void map() {
        ObjectMapper objectMapper = new ObjectMapper();

        JmesPath<Object> jmespath = new JcfRuntime();

        Expression<Object> expression = jmespath.compile("a");
        System.out.println(expression);
        LinkedHashMap map = new LinkedHashMap();
        map.put("a", 1);
        map.put("b", 2);
//        JsonNode input = objectMapper.convertValue(map, JsonNode.class);
        Object result = expression.search(map);
        System.out.println(result);
    }

    private static void map2json() {
        ObjectMapper objectMapper = new ObjectMapper();

        JmesPath<JsonNode> jmespath = new JacksonRuntime();

        Expression<JsonNode> expression = jmespath.compile("a");
        System.out.println(expression);
        LinkedHashMap map = new LinkedHashMap();
        map.put("a", 1);
        map.put("b", 2);
        JsonNode input = objectMapper.convertValue(map, JsonNode.class);
        JsonNode result = expression.search(input);
        System.out.println(result);
    }
}
