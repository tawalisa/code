package com.lijia.code.hystrix

import com.netflix.hystrix.exception.HystrixRuntimeException
import spock.lang.Specification

class CommandThatFailsSilentlyTest
        extends Specification
{
    def "no Exception"() {
        given:
        def cm = new CommandThatFailsSilently(false)
        when:
        def result = cm.execute();
        def actual = "success"
        then:
        result == actual
    }

    def "throw Exception"() {
        given:
        def cm = new CommandThatFailsSilently(true)
        when:
        cm.execute();
        then:
        thrown(HystrixRuntimeException)
    }
}
