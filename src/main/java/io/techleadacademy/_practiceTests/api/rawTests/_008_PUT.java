package io.techleadacademy._practiceTests.api.rawTests;

import io.restassured.http.ContentType;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class _008_PUT {

    @Test
    public void test01(){
        String token = "d8d4c1540d64c51e123c7383dc59d405daea142f14a8cf29fb5a349a3970b104";
        String user = "{\n" +
                "    \"user_id\": 7167450,\n" +
                "    \"title\": \"Arca corrupti veniam dolores debilito.\",\n" +
                "    \"due_on\": \"2024-08-08T00:00:00.000+05:30\",\n" +
                "    \"status\": \"completed\"\n" +
                "}";

        given()
                .header("Authorization", "Bearer " + token)
                .contentType(ContentType.JSON)
                .body(user)
                .when()
                .put("https://gorest.co.in/public/v2/todos/57923")
                .then()
                .statusCode(200)
                .log()
                .body();
    }


}
