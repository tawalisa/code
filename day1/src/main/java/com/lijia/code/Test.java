package com.lijia.code;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test {
    static class Student{
        String gender;

        public Student(String gender) {
            this.gender = gender;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "gender='" + gender + '\'' +
                    '}';
        }
    }
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student("1"));
        list.add(new Student("2"));
        list.add(new Student("3"));
        list.add(new Student("4"));

        Iterator<Student> iterator = list.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if ("1".equals(student.getGender())) {
                iterator.remove();
            }
        }
        System.out.println(list);
    }
}
