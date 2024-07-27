package io.techleadacademy.stepDefs.apiSteps.rawTests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.techleadacademy.pojo.Module;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.*;

public class _004GET {
    private String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJ0bGEubGl2ZXByb2plY3QudGVhbTJAZ21haWwuY29tIiwiaWF0IjoxNzIyMDg2NTc1LCJleHAiOjE3MjIxNzI5NzUsImZpcnN0TmFtZSI6IkpvaG4iLCJsYXN0TmFtZSI6IlNtaXRoIn0.Kio0oI3es0Ir3LeeA4utbl7CiW3ox86-so_ffdRbpqU";

    @Test
    public void test01() {
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
    public void test03() {
        Response response = RestAssured.get("https://gorest.co.in/public/v2/users");
        response.getBody().prettyPrint();
    }

    @Test
    public void test04() {
        when()
                .get("https://gorest.co.in/public/v2/posts")
                .then()
                .log().body();
    }

    //Verifying if properties have specific values included
    @Test
    public void test05() {
        when()
                .get("https://gorest.co.in/public/v2/users")
                .then()
                .statusCode(200)
                .body("gender", hasItems("male", "female"))
                .log().body();
    }

    //Verifying header content
    @Test
    public void test06() {
        when()
                .get("https://gorest.co.in/public/v2/users")
                .then()
                .statusCode(200)
                .header("Content-Type", "application/json; charset=utf-8")
                .log().headers();
    }

    @Test
    public void test07() {
        given()
                .when()
                .get("https://gorest.co.in/public/v2/users")
                .then()
                .statusCode(200)
                .header("server", "cloudflare");
    }

    //Getting specific info of headers
    @Test
    public void test08() {
        Headers headers = given()
                .when()
                .get("https://gorest.co.in/public/v2/users")
                .getHeaders();

        System.out.println(headers.get("Content-Type"));
        System.out.println(headers.get("Cache-Control"));
    }

    //Using bearer token as part of authorization
    @Test
    public void test09() {
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

    @Test
    public void test10() {
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJ0bGEubGl2ZXByb2plY3QudGVhbTJAZ21haWwuY29tIiwiaWF0IjoxNzIxOTQ1NzQwLCJleHAiOjE3MjIwMzIxNDAsImZpcnN0TmFtZSI6IkpvaG4iLCJsYXN0TmFtZSI6IlNtaXRoIn0.slay_gVoJH6ht1HVKFVxMkpxD09SbiyckFqGbiZAdaM";

        given()
                .header("Authorization", "Bearer " + token)
                .when()
                .get("http://api.code-vista.net/api/modules")
                .then()
                .statusCode(200)
                .log()
                .body();
    }

    @Test
    public void test11() {
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJ0bGEubGl2ZXByb2plY3QudGVhbTJAZ21haWwuY29tIiwiaWF0IjoxNzIxOTQ1NzQwLCJleHAiOjE3MjIwMzIxNDAsImZpcnN0TmFtZSI6IkpvaG4iLCJsYXN0TmFtZSI6IlNtaXRoIn0.slay_gVoJH6ht1HVKFVxMkpxD09SbiyckFqGbiZAdaM";

        given()
                .header("Authorization", "Bearer " + token)
                .when()
                .get("http://api.code-vista.net/api/task?moduleName=Java challenges")
                .then()
                .statusCode(200)
                .log()
                .body();
    }

    //Path Parameter
    @Test
    public void test12() {
        given()
                .pathParams("user", "7142340")
                .when()
                .get("https://gorest.co.in/public/v2/users/{user}")
                .then()
                .statusCode(200)
                .log()
                .body();
    }

    @Test
    public void test13() {
        given()
                .pathParams("post", "144367")
                .when()
                .get("https://gorest.co.in/public/v2/posts/{post}")
                .then()
                .statusCode(200)
                .log()
                .body();
    }

    //QUERY Parameter
    @Test
    public void test14() {
        given()
                .queryParam("status", "inactive")
                .queryParam("gender", "male")
                .when()
                .get("https://gorest.co.in/public/v2/users")
                .then()
                .statusCode(200)
                .log()
                .body();
    }

    @Test
    public void test15(){
//        given()
//                .header("Authorization", "Bearer " + token)
//                .when()
//                .get("http://api.code-vista.net/api/modules")
//                .then()
//                .statusCode(200)
//                .log()
//                .body();
        baseURI = "http://api.code-vista.net/api";
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.header("Authorization", "Bearer " + token);

        Response response = requestSpecification.request(Method.GET, "/modules");

        String bodyStr = response.asPrettyString();
        System.out.println(bodyStr);
    }

    @Test
    public void test16(){
        baseURI = "http://api.code-vista.net/api";
        basePath = "/users";
        authentication = oauth2(token);

        given()
                .get()
                .then()
                .statusCode(200)
                .log()
                .body();
    }


}
