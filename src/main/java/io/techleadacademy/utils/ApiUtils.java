package io.techleadacademy.utils;

import io.techleadacademy.core.TestContext;

public class ApiUtils {
    private TestContext testContext;

    public ApiUtils(TestContext testContext){
        this.testContext = testContext;
    }

    //sending request example using testContext
    public void sample1(){
        testContext.API().requestSpecification
                .given()
                .when()
                .get("")
                .then()
                .statusCode(200);
    }

    //storing any returned information
    public void sample2(){
        testContext.API().response = testContext.API().requestSpecification
                .given()
                .when()
                .get("");
    }
}
