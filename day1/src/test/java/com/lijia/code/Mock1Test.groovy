package com.lijia.code

import spock.lang.Specification

class Mock1Test1 extends Specification {

    def "hello"() {

        setup:
        GroovyMock(Mock1, global: true)
        Mock1.contact(String.class, String.class) >> "Business"
        Mock1 m = new Mock1()

        when:
//        def result = m.hello("1","2")
        def result = Mock1.contact("1", "2")
        def actual = "12"
        then:
        result == actual
    }
}
