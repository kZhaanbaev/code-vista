package io.techleadacademy._practiceTests.api.rawTests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import io.techleadacademy.pojo.Module;
import io.techleadacademy.pojo.User;
import org.junit.Test;
import static io.restassured.RestAssured.*;


public class _005SerializationDeserialization {
    private String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJ0bGEubGl2ZXByb2plY3QudGVhbTJAZ21haWwuY29tIiwiaWF0IjoxNzIyMDg2NTc1LCJleHAiOjE3MjIxNzI5NzUsImZpcnN0TmFtZSI6IkpvaG4iLCJsYXN0TmFtZSI6IlNtaXRoIn0.Kio0oI3es0Ir3LeeA4utbl7CiW3ox86-so_ffdRbpqU";


    @Test
    public void test01(){
        User user = new User(
                1,
                "John",
                "Sweet",
                "j.sweet@test.com",
                "1234567",
                "student"
        );

        System.out.println(user);

        ObjectMapper mapper = new ObjectMapper();
        String jsonStr;
        try {
            jsonStr = mapper.writeValueAsString(user);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        System.out.println(jsonStr);
    }

    @Test
    public void test02(){
        Response response = given()
                .header("Authorization", "Bearer " + token)
                .when()
                .get("http://api.code-vista.net/api/modules/Exceptions");

        String jsonStr = response.body().asString();
        ObjectMapper mapper = new ObjectMapper();
        Module exceptionModule;

        try {
            exceptionModule = mapper.readValue(jsonStr, Module.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        System.out.println(jsonStr);
        System.out.println(exceptionModule);
    }
}
