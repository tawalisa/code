package com.lijia.code.hystrix

import spock.lang.Specification

class CommandThatFailsSilentlyTest
        extends Specification
{
    def "123"() {
        given:
        def cm = new CommandThatFailsSilently(false)
        when:
        def result = cm.execute();
        def actual = "success"
        then:
        result == actual
    }
}
