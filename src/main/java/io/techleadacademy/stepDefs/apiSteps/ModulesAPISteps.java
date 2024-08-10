package io.techleadacademy.stepDefs.apiSteps;

import io.cucumber.java.en.When;
import io.techleadacademy.core.TestContext;
import org.junit.Assert;

public class ModulesAPISteps {
    private TestContext testContext;

    public ModulesAPISteps(TestContext testContext) {
        this.testContext = testContext;
    }

    @When("I send a GET request to {string} resource with name {string}")
    public void iSendAGETRequestToResourceWithName(String resource, String name) {
        switch (resource){
            case "/api/modules":
                testContext.API().ApiUtils.getModuleByName(name);
                break;
            default:
                Assert.fail("Invalid resource or name");
        }
    }
}
