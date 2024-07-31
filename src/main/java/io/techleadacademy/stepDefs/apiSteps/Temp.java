package io.techleadacademy.stepDefs.apiSteps;


import io.restassured.RestAssured;
import io.techleadacademy.core.TestContext;
import org.junit.Test;

public class Temp {

    @Test
    public void test01(){
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJ0bGEubGl2ZXByb2plY3QudGVhbTJAZ21haWwuY29tIiwiaWF0IjoxNzIyMzg4ODg0LCJleHAiOjE3MjI0NzUyODQsImZpcnN0TmFtZSI6IkpvaG4iLCJsYXN0TmFtZSI6IlNtaXRoIn0.SS3928H_aVTshQGflCfN9qQ7e25Qut318aR1R9KYBqc";
        TestContext testContext = new TestContext();
        testContext.API().requestSpecification = RestAssured.given();
        testContext.API().requestSpecification.auth().oauth2(token);
        testContext.API().requestSpecification.baseUri("http://api.code-vista.net");
        testContext.API().requestSpecification.basePath("/api/users");

        testContext.API().response = testContext.API().requestSpecification
                        .post("");
        testContext.API().response.prettyPrint();
    }
}
