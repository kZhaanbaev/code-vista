package io.techleadacademy.stepDefs.apiSteps.rawTests;

import io.restassured.http.ContentType;
import org.junit.Test;

import java.util.HashMap;
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
}
