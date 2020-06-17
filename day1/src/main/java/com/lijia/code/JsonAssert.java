package com.lijia.code;

import org.json.JSONArray;
import org.json.JSONObject;

public class JsonAssert {
    public static void main(String[] args) {
        JSONArray array1 = new JSONArray();

        array1.put(createJson("1", "name1"));
        array1.put(createJson("2", "name2"));
        array1.put(createJson("3", "name3"));


        JSONArray array2 = new JSONArray();

        array2.put(createJson("2", "name2"));
        array2.put(createJson("1", "name1"));
        array2.put(createJson("3", "name3"));
        org.skyscreamer.jsonassert.JSONAssert.assertEquals(array1, array2, false);
    }

    private static JSONObject createJson(String id, String name) {
        JSONObject obj = new JSONObject();
        obj.put("id", id);
        obj.put("name", name);
        return obj;
    }
}
