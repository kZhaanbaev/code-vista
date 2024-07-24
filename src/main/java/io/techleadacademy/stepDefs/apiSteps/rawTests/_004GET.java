package io.techleadacademy.stepDefs.apiSteps.rawTests;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.junit.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.*;

public class _004GET {
    @Test
    public void test01(){
        when()
                .get("https://gorest.co.in/public/v2/users")
                .then()
                .statusCode(200);
    }

    @Test
    public void test02() {
        when().get("https://gorest.co.in/public/v2/users")
                .then()
                .statusCode(200)
                .log()
                .body();
    }

    @Test
    public void test03(){
        Response response = RestAssured.get("https://gorest.co.in/public/v2/users");
        response.getBody().prettyPrint();
    }

    @Test
    public void test04(){
        when()
                .get("https://gorest.co.in/public/v2/posts")
                .then()
                .log().body();
    }

    //Verifying if properties have specific values included
    @Test
    public void test05(){
        when()
                .get("https://gorest.co.in/public/v2/users")
                .then()
                .statusCode(200)
                .body("gender", hasItems("male", "female"))
                .log().body();
    }

    //Verifying header content
    @Test
    public void test06(){
        when()
                .get("https://gorest.co.in/public/v2/users")
                .then()
                .statusCode(200)
                .header("Content-Type", "application/json; charset=utf-8")
                .log().headers();
    }

    @Test
    public void test07(){
        given()
                .when()
                .get("https://gorest.co.in/public/v2/users")
                .then()
                .statusCode(200)
                .header("server", "cloudflare");
    }

    //Getting specific info of headers
    @Test
    public void test08(){
        Headers headers = given()
                .when()
                .get("https://gorest.co.in/public/v2/users")
                .getHeaders();

        System.out.println(headers.get("Content-Type"));
        System.out.println(headers.get("Cache-Control"));
    }

    //Using bearer token as part of authorization
    @Test
    public void test09(){
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJrdWJhX3poYWFuYmFldkB0ZWNobGVhZGFjYWRlbXkuaW8iLCJpYXQiOjE3MjE3NjgzNTUsImV4cCI6MTcyMTg1NDc1NSwiZmlyc3ROYW1lIjoiS3ViYSIsImxhc3ROYW1lIjoiWmhhYW5iYWV2In0.EQZ6UawkYubmX9PsQ9gFiNfWodD561CYpXVGy4oWmUQ";

        given()
                .header("Authorization", "Bearer " + token)
                .when()
                .get("http://api.code-vista.net/api/users")
                .then()
                .statusCode(200)
                .log()
                .body();
    }

}
