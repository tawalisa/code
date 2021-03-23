package com.lijia.code;

import org.apache.commons.io.FileUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test999 {
    static class Obj{
        String name;
        int id;
        Map map = new HashMap();

        public Obj(String name, int id) {
            this.name = name;
            this.id = id;
            map.put("name", name);
            map.put("id", id);
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

//        @Override
//        public boolean equals(Object o) {
//            System.out.println("equals");
//            if (this == o) return true;
//            if (o == null || getClass() != o.getClass()) return false;
//            Obj obj = (Obj) o;
//            return id == obj.id &&
//                    Objects.equals(name, obj.name);
//        }
//
//        @Override
//        public int hashCode() {
//            System.out.println("hashcode");
//            return Objects.hash(name, id);
//
//        }

        @Override
        public boolean equals(Object o) {
            System.out.println("equals");
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Obj obj = (Obj) o;
            return Objects.equals(map, obj.map);
        }

        @Override
        public int hashCode() {
            System.out.println(this+"hashcode");
            return Objects.hash(map);
        }
    }
    public static void main(String[] args) {
        Map map = new HashMap();
        Obj obj = new Obj("name1", 1);
        Obj obj1 = new Obj("name1", 1);
        map.put(obj, obj);
        System.out.println("==============");
        for(int i = 0; i<1000; i++){
            System.out.println(map.get(obj));
        }


//        String fileName = "inline; filename=\"utf-8' 'C-Capital_CapitalCall_1812.pdf\"";
//
//        String contentDisposition = fileName;
////        if(contentDisposition != null) {
////            Matcher m = p.matcher(contentDisposition);
////            if(m.find()) {
////                fileName = m.group(1);
////                System.out.println(fileName);
////            }
////        }
//        System.out.println("".split("'").length);
//        System.out.println("'''".split("'").length);
//        System.out.println("'as'aa".split("'").length);
//        contentDisposition = "inline; filename=\"utf-8' 'C-Capital_CapitalCall_1812.pdf\"";
//        String re = getFileNameFromContentDisposition(contentDisposition);
    }
    static Pattern contentDispositionPattern = Pattern.compile(".+filename[*]?=\"(.+?)\".*");
    private static String getFileNameFromContentDisposition(String contentDisposition) {
        if(contentDisposition != null) {
            Matcher m = contentDispositionPattern.matcher(contentDisposition);
            if(m.find()) {
                String fileName = m.group(1);

                System.out.println(getArrayLastOne(fileName.split("'"), fileName));
            }
        }
        return contentDisposition;
    }

    private static String getArrayLastOne(String[] split, String defaultValue) {
        return split.length>0?split[split.length-1]:defaultValue;
    }


}
