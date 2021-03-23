package com.lijia.code

class Mock2Test extends GroovyTestCase {

    void testHello() {

        Mock1 mock = new Mock1()
        assert mock.hello("1", "2") == "12345"
        Mock1.metaClass.static.contact = {  return "123" }

        assert mock.contact() == "123"
        assert mock.hello("1", "2") == "123"

    }
}
