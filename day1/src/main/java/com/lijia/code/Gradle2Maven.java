package com.lijia.code;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Gradle2Maven {
    public static void main(String[] args) {
        String gradle = "testCompile group: 'junit', name: 'junit', version: '4.12'\n" +
                "    testCompile 'org.spockframework:spock-core:1.1-groovy-2.4'\n" +
                "    testCompile 'org.codehaus.groovy:groovy-all:2.4.13'\n" +
                "    testCompile 'cglib:cglib-nodep:3.3.0'\n" +
                "    testCompile 'org.objenesis:objenesis:2.1'\n" +
                "    testCompile 'com.google.code.gson:gson:2.8.0'\n" +
                "    testCompile 'org.eclipse.jetty:jetty-server:9.4.5.v20170502'\n" +
                "    testCompile 'com.fasterxml.jackson.core:jackson-databind:2.10.0'\n" +
                "    testCompile 'org.slf4j:slf4j-simple:1.7.25'\n" +
                "    testCompile 'org.awaitility:awaitility-groovy:3.0.0'\n" +
                "    testCompile 'com.github.javafaker:javafaker:0.13'\n" +
                "\n" +
                "    testCompile 'org.reactivestreams:reactive-streams-tck:1.0.2'\n" +
                "    testCompile \"io.reactivex.rxjava2:rxjava:2.1.5\"\n" +
                "\n" +
                "    testCompile 'org.testng:testng:6.1.1' // use for reactive streams test inheritance\n" +
                "\n" +
                "    testCompile 'org.openjdk.jmh:jmh-core:1.21'\n" +
                "    testCompile 'org.openjdk.jmh:jmh-generator-annprocess:1.21'";

        String[] lines = gradle.split("\n");
        for(String line : lines){
            Pattern p = Pattern.compile("([^ ]+)[ ][']([^:]+)[:]([^:]+)[:]([^:]+)[']");
            Matcher m = p.matcher(line);
            if(m.find()){
                StringBuffer sb = new StringBuffer();
                String format = "<dependency>\n" +
                        "            <groupId>{1}</groupId>\n" +
                        "            <artifactId>{2}</artifactId>\n" +
                        "            <version>{3}</version>\n" +
                        "            <scope>{4}</scope>\n" +
                        "        </dependency>";
                System.out.println(String.format(format, m.group(2), m.group(3), m.group(4),m.group(1).contains("test")?"test":"compile"));
//                sb.append(m.group(1)).append("===").append(m.group(2)).append("===").append(m.group(3)).append("===").append(m.group(4));
//                System.out.println(sb.toString());
            }
        }
    }
}
