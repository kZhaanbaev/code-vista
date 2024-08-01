package io.techleadacademy.stepDefs.apiSteps.rawTests;

import io.restassured.http.ContentType;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static io.restassured.RestAssured.*;

public class _007_POST {

    @Test
    public void test01(){
        //Prep a data to send to create a new user
        //1.
        String user = "{\n" +
                "    \"name\": \"Sam Smith Jr\",\n" +
                "    \"email\": \"s.smith.jr@test.com\",\n" +
                "    \"gender\": \"male\",\n" +
                "    \"status\": \"inactive\"\n" +
                "}";

        //2.
        Map<String, String> userMap = new HashMap<>();
        userMap.put("name", "Sam Smith Jr");
        userMap.put("email", "s.smith.jr@test.com");
        userMap.put("gender", "male");
        userMap.put("status", "inactive");

        //3. POJO
    }

    @Test
    public void test02(){
        String token = "d8d4c1540d64c51e123c7383dc59d405daea142f14a8cf29fb5a349a3970b104";
        String user = "{\n" +
                "    \"name\": \"Sam Smith Jr3\",\n" +
                "    \"email\": \"s.smith.jr3@test.com\",\n" +
                "    \"gender\": \"male\",\n" +
                "    \"status\": \"inactive\"\n" +
                "}";

        int id = given()
                .header("Authorization", "Bearer " + token)
                .contentType(ContentType.JSON)
                .body(user)
                .when()
                .post("https://gorest.co.in/public/v2/users")
                .jsonPath()
                .getInt("id");

                 given()
                .header("Authorization", "Bearer " + token)
                .get("https://gorest.co.in/public/v2/users/" + id)
                .then()
                .statusCode(200)
                .log()
                .body();

    }

    //Task
    @Test
    public void test03(){
        String token = "d8d4c1540d64c51e123c7383dc59d405daea142f14a8cf29fb5a349a3970b104";
        Map<String, Object> data = new HashMap<>();
        data.put("user_id", 7204156);
        data.put("title", "Test post");
        data.put("body", "Post body");

        int id = given()
                .header("Authorization", "Bearer " + token)
                .contentType(ContentType.JSON)
                .body(data)

                .when()
                .post("https://gorest.co.in/public/v2/posts")
                .jsonPath()
                .getInt("id");

        given()
                .header("Authorization", "Bearer " + token)
                .get("https://gorest.co.in/public/v2/posts/" + id)
                .then()
                .statusCode(200)
                .log()
                .body();

    }

    //Task
    @Test
    public void test04(){
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJ0bGEubGl2ZXByb2plY3QudGVhbTJAZ21haWwuY29tIiwiaWF0IjoxNzIyMTc3MTE1LCJleHAiOjE3MjIyNjM1MTUsImZpcnN0TmFtZSI6IkpvaG4iLCJsYXN0TmFtZSI6IlNtaXRoIn0.L1SpCOmrKrfMVitRGmTPeNNO3T20NvkdMe0334fMPUM";
        String data = "{\n" +
                "  \"userId\": 96,\n" +
                "  \"taskId\": 2003,\n" +
                "  \"taskName\": \"Task91\",\n" +
                "  \"instruction\": \"Test instruction\",\n" +
                "  \"code\": \"some code\",\n" +
                "  \"status\": \"new\",\n" +
                "  \"moduleName\": \"Exceptions\"\n" +
                "}";

        given()
                .header("Authorization", "Bearer " + token)
                .contentType(ContentType.JSON)
                .body(data)
                .when()
                .post("http://api.code-vista.net/api/submission")
                .then()
                .statusCode(201)
                .log()
                .body();

//        given()
//                .header("Authorization", "Bearer " + token)
//                .queryParam("userId", 96)
//                .queryParam("taskName", "Task91")
//                .get("http://api.code-vista.net/api/submission/by-user-and-task")
//                .then()
//                .statusCode(200)
//                .log()
//                .body();

        List<String> taskNames = given()
                .header("Authorization", "Bearer " + token)
                .get("http://api.code-vista.net/api/submission/by-user/96")
                .jsonPath()
                .getList("taskName");

        System.out.println(taskNames);
        Assert.assertTrue(taskNames.contains("Task90"));
    }


}
