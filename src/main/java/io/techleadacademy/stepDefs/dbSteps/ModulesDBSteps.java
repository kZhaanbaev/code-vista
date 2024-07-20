package io.techleadacademy.stepDefs.dbSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.techleadacademy.core.DBConnection;
import io.techleadacademy.core.TestContext;
import io.techleadacademy.pojo.Module;
import io.techleadacademy.pojo.User;
import org.junit.Assert;

import java.util.List;

public class ModulesDBSteps {

    private TestContext testContext;

    public ModulesDBSteps(TestContext testContext) {
        this.testContext = testContext;
    }

    @When("I send a query to get module count {int}")
    public void iSendAQueryToGetModuleCount(Integer userCount) {
        List<Module> list = testContext.DB().DBUtils.getAllModules(userCount);
        testContext.sharedData.put("userCount", list.size());
    }

    @Then("Verify module count of the ResultSet is {int}")
    public void verifyModuleCountOfTheResultSetIs(Integer userCount) {
        Assert.assertEquals(userCount, testContext.sharedData.get("userCount"));
    }
}
