package com.lijia.code;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.*;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import org.junit.jupiter.api.Test;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = {"com.lijia.code"})
class SpringTestContext {

    @Bean(name = "notebookPC")
    public Computer computer1(){
        return new Computer("笔记本电脑");
    }

    @ConditionalOnMissingBean(Computer.class)
    @Bean("reservePC")
    public Computer computer2(){
        return new Computer("备用电脑");
    }
}
@Data
@AllArgsConstructor(access = AccessLevel.PUBLIC)
class Computer{
    private String name;
}

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = SpringTestContext.class)
public class SpringConditionalTest {
    @Autowired
    Computer computer;

    @Test
    public void test(){
        System.out.println(computer.getName());
        Assertions.assertEquals(1,1);
    }
}
