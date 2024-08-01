package io.techleadacademy.stepDefs.apiSteps;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.techleadacademy.core.TestContext;
import io.techleadacademy.pojo.Submission;
import org.junit.Assert;

import java.util.Map;

public class SubmissionAPISteps {
    private TestContext testContext;

    public SubmissionAPISteps(TestContext testContext) {
        this.testContext = testContext;
    }

    @Given("I establish a connection to the api service")
    public void iEstablishAConnectionToTheApiService() {
        testContext.API().ApiUtils.setUpConnection();
    }

    @When("I send a GET request to {string} resource with id {int}")
    public void iSendAGETRequestToResourceWithId(String resource, int id) {
        switch (resource){
            case "/api/submissions/by-user":
                testContext.API().ApiUtils.getSubmissionsByUser(id);
                break;
            default:
                Assert.fail("Invalid resource or id");
        }
    }

    @Then("Status code should bee {int}")
    public void statusCodeShouldBee(int statusCode) {
        Assert.assertEquals(statusCode, testContext.API().response.statusCode());
    }

    @When("I send a POST request to {string} resource with following payload:")
    public void i_send_a_post_request_to_resource_with_following_payload(String resource, Map<String, Object> map) {
        ObjectMapper mapper = new ObjectMapper();

        switch (resource) {
            case "/api/submission":
                testContext.API().ApiUtils.createNewSubmissionByUser(mapper.convertValue(map, Submission.class));
                break;
            default:
                Assert.fail("invalid resource or payload");
        }
    }

    @When("I send GET request to {string} resource with userId {int} and taskName {string}")
    public void iSendGETRequestToResourceWithUserIdAndTaskName(String resource, int userId, String taskName) {
        switch (resource){
            case "/api/submission":
                testContext.sharedData.put("submissionId", testContext.API().ApiUtils.getSubmissionId(userId, taskName));
                break;
            default:
                Assert.fail("Invalid resource, userId or taskName");
        }
    }

    @When("I send DELETE request to {string} resource with id {int}")
    public void iSendDELETERequestToResourceWithId(String resource, int id) {
        switch (resource){
            case "/api/submission":
                testContext.API().ApiUtils.deleteSubmission(id);
                break;
            default:
                Assert.fail("Invalid resource or id");
        }
    }

    @When("I send DELETE request to {string} to delete newly created item")
    public void iSendDELETERequestToToDeleteNewlyCreatedItem(String resource) {
        switch (resource){
            case "/api/submission":
                testContext.API().ApiUtils.deleteSubmission(Integer.parseInt(testContext.sharedData.get("submissionId").toString()));
                break;
            default:
                Assert.fail("Invalid resource or id");
        }
    }
}
