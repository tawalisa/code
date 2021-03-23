package com.lijia.code.invokefactory;

import com.google.common.collect.ImmutableSet;
import com.google.common.reflect.ClassPath;

import java.io.IOException;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Factory {

    private final Map<String, Executor> map;
    public Factory() throws IOException {
        map = initMap();
    }

    private Map<String, Executor> initMap() throws IOException {
        ImmutableSet<ClassPath.ClassInfo> classes = ClassPath.from(this.getClass().getClassLoader()).getTopLevelClasses(this.getClass().getPackage().getName());

        return  classes.stream().map(ClassPath.ClassInfo::load).filter(aClass -> aClass.isAnnotationPresent(InvokeExecutor.class)).map(aClass -> {
            try {
                return aClass.getDeclaredConstructor().newInstance();
            }  catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }).map(Executor.class::cast).collect(Collectors.toMap(executor -> executor.getName(), executor -> executor));
    }

    Optional<Executor> getExecutor(String name){
        return Optional.ofNullable(map.get(name));
    }

}
