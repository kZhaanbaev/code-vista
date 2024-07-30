package io.techleadacademy.stepDefs.apiSteps.rawTests;

import org.json.JSONObject;

public class _001_JsonObjectPractice {
    public static void main(String[] args) {
        String s = "{\n" +
                "    \"id\": 7076507,\n" +
                "    \"name\": \"Jason Smith\",\n" +
                "    \"email\": \"j.smith@test.test\",\n" +
                "    \"gender\": \"male\",\n" +
                "    \"status\": \"inactive\"\n" +
                "}";

        JSONObject jsonObject = new JSONObject(s);
        System.out.println(jsonObject.getInt("id"));
        System.out.println(jsonObject.getString("email"));
        System.out.println();

        for(String key: jsonObject.keySet()){
            System.out.println(key + ": " + jsonObject.get(key));
        }
    }
}
