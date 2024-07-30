package io.techleadacademy.stepDefs.apiSteps.rawTests;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.*;


public class _006_GetData {
    String endpointUser = "https://jsonplaceholder.typicode.com/users/1";
    String endpointUsers = "https://jsonplaceholder.typicode.com/users";

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

    @Test
    public void test04(){
        //Task
        String str = given()
                .get("https://gorest.co.in/public/v1/users/7167427")
                .then()
                .statusCode(200)
                .extract()
                .path("data.email");

        System.out.println("===================>>" + str);
    }

    @Test
    public void test05(){
        //Get list of items of all objects(user)
        List<String> namesList = given()
                .get(endpointUsers)
                .then()
                .statusCode(200)
                .extract()
                .path("name");

//        for(String each: namesList){
//            System.out.println(each);
//        }

//        namesList.forEach(each -> System.out.println(each));

        namesList.forEach(System.out::println);
    }

    //JsonPath
    @Test
    public void test06(){
        //Get id of the user and store in an int
        int id = given()
                .get(endpointUser)
                .jsonPath()
                .getInt("id");

        System.out.println("===================>>" + id);
    }

    @Test
    public void test07(){
        Response response = given()
                .get(endpointUser);

        JsonPath jsonPath = response.jsonPath();

        System.out.println("===================>>" + jsonPath.get("name"));
        System.out.println("===================>>" + jsonPath.get("company.name"));
    }

    @Test
    public void test08(){
        //Get id of the user and store in an int
        String str = given()
                .get("https://jsonplaceholder.typicode.com/users")
                .jsonPath()
                .getString("company.name[2]");

        System.out.println("===================>>" + str);
    }

    @Test
    public void test09(){
        //Get id of the user and store in an int
        List<String> str = given()
                .get("https://jsonplaceholder.typicode.com/users")
                .jsonPath()
                .getList("name");

        str.forEach(System.out::println);
    }


}
