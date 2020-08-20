package com.lijia.code

class Mock2Test extends GroovyTestCase {

    void testHello() {

        Mock1 mock = new Mock1()
        assert mock.hello("1", "2") == "12"

        Mock1.metaClass.static.contact = { String a, String b -> return a+ b +"123" }

        assert mock.contact("1", "2") == "12123"

    }
}
