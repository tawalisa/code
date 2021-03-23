package com.lijia.code;

import com.google.common.collect.ImmutableSet;
import io.vavr.collection.List;

import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test877 {
    public static void main(String[] args) {
        Map<String, String> map = List.of("1", "2", "3", "1")
                .filter(Objects::nonNull)
                .collect(Collectors.toMap(Function.identity(), dataRow -> dataRow));
        System.out.println(map);
    }
}
