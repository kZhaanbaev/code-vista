package io.techleadacademy.utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.techleadacademy.core.TestContext;
import io.techleadacademy.pojo.Submission;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApiUtils {
    private TestContext testContext;

    public ApiUtils(TestContext testContext){
        this.testContext = testContext;
    }

    public void setUpConnection() {
        testContext.API().requestSpecification = RestAssured.given();
        testContext.API().requestSpecification.baseUri(ConfigReader.readProperty("base-url"));
        testContext.API().requestSpecification.auth().oauth2(getBearerToken());
    }

    public String getBearerToken() {
        Map<String, String> data = new HashMap<>();
        data.put("email", ConfigReader.readProperty("username-admin"));
        data.put("password", ConfigReader.readProperty("password-admin"));

        return RestAssured.given()
                .body(data)
                .contentType(ContentType.JSON)
                .when()
                .post(ConfigReader.readProperty("auth-url"))
                .jsonPath()
                .getString("token");
    }

    public List<Submission> getSubmissionsByUser(int userId) {
        testContext.API().requestSpecification.basePath("/api/submission/by-user/" + userId);
        testContext.API().response = testContext.API().requestSpecification
                .get();

        JsonPath jsonPath = testContext.API().response.jsonPath();
        return jsonPath.getList("", Submission.class);
    }

    public int getSubmissionId(int userId, String taskName) {
        testContext.API().requestSpecification.basePath("/api/submission/by-user/" + userId);
        testContext.API().response = testContext.API().requestSpecification
                .get();

        JsonPath jsonPath = testContext.API().response.jsonPath();

        List<Map<String, Object>> submissions = jsonPath.getList("$");
        Integer submissionId = null;
        for (Map<String, Object> submission : submissions) {
            if (submission.get("taskName").equals(taskName)) {
                submissionId = (Integer) submission.get("submissionId");
                break;
            }
        }
        return submissionId;
    }

    public Submission getSubmissionByUserAndTask(int userId, String taskName) {
        testContext.API().requestSpecification.basePath("/api/submission/by-user-and-task");
        testContext.API().response = testContext.API().requestSpecification
                .queryParam("userId", userId)
                .queryParam("taskName", taskName)
                .when()
                .get();

        JsonPath jsonPath = testContext.API().response.jsonPath();
        return jsonPath.getObject("", Submission.class);
    }

    public List<Submission> getSubmissionByModuleAndTask(int userId, String moduleName) {
        testContext.API().requestSpecification.basePath("/api/submission/by-module");
        testContext.API().response = testContext.API().requestSpecification
                .queryParam("userId", userId)
                .queryParam("moduleName", moduleName)
                .when()
                .get();

        JsonPath jsonPath = testContext.API().response.jsonPath();
        return jsonPath.getList("", Submission.class);
    }

    public void createNewSubmissionByUser(Submission submission){
        testContext.API().requestSpecification.basePath("/api/submission");

        testContext.API().response = testContext.API().requestSpecification
                .contentType(ContentType.JSON)
                .body(submission)
                .when()
                .post();
    }

    public void deleteSubmission(int submissionId) {
        testContext.API().requestSpecification.basePath("/api/submission/" + submissionId);

        testContext.API().response = testContext.API().requestSpecification
                .when()
                .delete();
    }

}
