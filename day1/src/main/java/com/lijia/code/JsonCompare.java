package com.lijia.code;

import com.google.common.collect.Iterators;
import org.json.JSONArray;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.stream.StreamSupport;

public class JsonCompare {
    public static void main(String[] args) {
        List<String> lits1 = Arrays.asList(new String[]{"1","2","3"});

        List<String> lits2 = Arrays.asList(new String[]{"4","5","3"});

        JSONArray jsonArray1= new JSONArray(lits1);

        JSONArray jsonArray2= new JSONArray(lits2);

        System.out.println(Iterators.elementsEqual(jsonArray1.iterator(), jsonArray2.iterator()));

        System.out.println(JSONArrayCompare(jsonArray1, jsonArray2));

        System.out.println(lits1.retainAll(lits2));

    }

    private static boolean JSONArrayCompare(JSONArray jsonArray1, JSONArray jsonArray2) {
//        if(jsonArray1 == jsonArray2){
//            return true;
//        }
//        if(jsonArray1 == null || jsonArray2 == null || jsonArray1.length() != jsonArray2.length()){
//            return false;
//        }
//
//        for(int i = 0 ; i < jsonArray1.length() ; i++){
//            Object obj1 = jsonArray1.get(i);
//            if(! JSONArrayContains(jsonArray2,obj1)){
//                return false
//            }
//        }
        return false;
    }



}
