package io.techleadacademy.stepDefs.apiSteps.rawTests;

import org.junit.Test;
import static io.restassured.RestAssured.*;


public class _006_GetData {
    String endpointUser = "https://jsonplaceholder.typicode.com/users/1";

    @Test
    public void test01(){
        //Get name of the user and store in a String
        String name = given()
                .get(endpointUser)
                .then()
                .statusCode(200)
//                .log()
//                .body()
                .extract()
                .path("name");

        System.out.println("===================>>" + name);
    }

    @Test
    public void test02(){
        //Get id of the user and store in an int
        int id = given()
                .get(endpointUser)
                .then()
                .statusCode(200)
                .extract()
                .path("id");

        System.out.println("===================>>" + id);
    }

    @Test
    public void test03(){
        //Get street address inside of address field of the user and store in a String
        String str = given()
                .get(endpointUser)
                .then()
                .statusCode(200)
                .extract()
                .path("address.street");

        System.out.println("===================>>" + str);
    }
}
