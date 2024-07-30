package io.techleadacademy.stepDefs.apiSteps.rawTests;

import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class _008_DELETE {

    @Test
    public void test01(){
        String token = "d8d4c1540d64c51e123c7383dc59d405daea142f14a8cf29fb5a349a3970b104";

        given()
                .header("Authorization", "Bearer " + token)
                .when()
                .delete("https://gorest.co.in/public/v2/todos/57923")
                .then()
                .statusCode(204);
    }


}
