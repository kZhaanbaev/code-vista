package io.techleadacademy.utils;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.techleadacademy.core.TestContext;
import java.util.Map;
import io.techleadacademy.pojo.Module;


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


    public void createNewModule(Map<String, Object> moduleData) {
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJtYXJpYW5uYS5hbnRvbmlhbkBnbWF" +
                "pbC5jb20iLCJpYXQiOjE3MjIzODkwNzQsImV4cCI6MTcyMjQ3NTQ3NCwiZmlyc3ROYW1lIjoiTWFyaWF" +
                "ubmEiLCJsYXN0TmFtZSI6IkFudG9uaWFuIn0.eYLKKf5vmpnUA7TBSsmx_lJ75DZaVi3Lr-d1PAYPEME";
        testContext.API().requestSpecification = RestAssured.given();
        testContext.API().requestSpecification.auth().oauth2(token);
        testContext.API().requestSpecification.queryParam("moduleName", moduleData.get("moduleName"))
                .queryParam("videoLink", moduleData.get("videoLink"))
                .queryParam("moduleOrder", moduleData.get("moduleOrder"));

        testContext.API().response = testContext.API().requestSpecification
                .request(Method.POST, "http://api.code-vista.net/api/modules");
    }

    public void createNewModule(Module module) {
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJtYXJpYW5uYS5hbnRvbmlhbkBnbWF" +
                "pbC5jb20iLCJpYXQiOjE3MjIzODkwNzQsImV4cCI6MTcyMjQ3NTQ3NCwiZmlyc3ROYW1lIjoiTWFyaWF" +
                "ubmEiLCJsYXN0TmFtZSI6IkFudG9uaWFuIn0.eYLKKf5vmpnUA7TBSsmx_lJ75DZaVi3Lr-d1PAYPEME";
        testContext.API().requestSpecification = RestAssured.given();
        testContext.API().requestSpecification.auth().oauth2(token);
        testContext.API().requestSpecification.queryParam("moduleName", module.getModuleName())
                .queryParam("videoLink", module.getVideoLink())
                .queryParam("moduleOrder", module.getModuleOrder());

        testContext.API().response = testContext.API().requestSpecification
                .request(Method.POST, "http://api.code-vista.net/api/modules");
    }

    public void deleteModule(int moduleId) {
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJtYXJpYW5uYS5hbnRvbmlhbkBnbWF" +
                "pbC5jb20iLCJpYXQiOjE3MjIzODkwNzQsImV4cCI6MTcyMjQ3NTQ3NCwiZmlyc3ROYW1lIjoiTWFyaWF" +
                "ubmEiLCJsYXN0TmFtZSI6IkFudG9uaWFuIn0.eYLKKf5vmpnUA7TBSsmx_lJ75DZaVi3Lr-d1PAYPEME";
        testContext.API().requestSpecification = RestAssured.given();
        testContext.API().requestSpecification.auth().oauth2(token);
        testContext.API().requestSpecification.queryParam("moduleId", moduleId);

        testContext.API().response = testContext.API().requestSpecification
                .request(Method.DELETE, "http://api.code-vista.net/api/modules");
    }


    public void createNewTask(Map<String, Object> taskData) {
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJtYXJpYW5uYS5hbnRvbmlhbkBnbWF" +
                "pbC5jb20iLCJpYXQiOjE3MjIzODkwNzQsImV4cCI6MTcyMjQ3NTQ3NCwiZmlyc3ROYW1lIjoiTWFyaWF" +
                "ubmEiLCJsYXN0TmFtZSI6IkFudG9uaWFuIn0.eYLKKf5vmpnUA7TBSsmx_lJ75DZaVi3Lr-d1PAYPEME";
        testContext.API().requestSpecification = RestAssured.given();
        testContext.API().requestSpecification.auth().oauth2(token);
        testContext.API().requestSpecification.body(taskData);

        testContext.API().response = testContext.API().requestSpecification
                .request(Method.POST, "http://api.code-vista.net/api/task");
    }
    public void deleteTask(int taskId) {
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJtYXJpYW5" +
                "uYS5hbnRvbmlhbkBnbWFpbC5jb20iLCJpYXQiOjE3MjI1Mjg0MDYsImV4cCI6MTcyMjY" +
                "xNDgwNiwiZmlyc3ROYW1lIjoiTWFyaWFubmEiLCJsYXN0TmFtZSI6IkFudG9uaWFuIn0.L87" +
                "tsMxhrkLzlup-g4hhZlXoYJ32FGBg-xD3snr42Qg";
        testContext.API().requestSpecification = RestAssured.given();
        testContext.API().requestSpecification.auth().oauth2(token);
        testContext.API().requestSpecification.queryParam("moduleId", taskId);

        testContext.API().response = testContext.API().requestSpecification
                .request(Method.DELETE, "http://api.code-vista.net/api/task");
    }
    public void updateModuleDetails(Map<String, Object> data, int moduleId) {
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJtYX" +
                "JpYW5uYS5hbnRvbmlhbkBnbWFpbC5jb20iLCJpYXQiOjE3MjI1Mjg0MDYsImV4" +
                "cCI6MTcyMjYxNDgwNiwiZmlyc3ROYW1lIjoiTWFyaWFubmEiLCJsYXN0TmFtZSI6Ik" +
                "FudG9uaWFuIn0.L87tsMxhrkLzlup-g4hhZlXoYJ32FGBg-xD3snr42Qg";
        testContext.API().requestSpecification = RestAssured.given();
        testContext.API().requestSpecification.auth().oauth2(token);
        testContext.API().requestSpecification.queryParam("moduleId", moduleId)
                .body(data);

        testContext.API().response = testContext.API().requestSpecification
                .request(Method.PUT, "http://api.code-vista.net/api/modules");
    }


}
