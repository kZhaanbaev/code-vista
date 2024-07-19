package io.techleadacademy.stepDefs.dbSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.techleadacademy.core.DBConnection;
import io.techleadacademy.core.TestContext;
import io.techleadacademy.pojo.User;
import org.junit.Assert;

import java.util.List;

public class ModulesDBSteps {
    private TestContext testContext;

    public ModulesDBSteps(TestContext testContext) {
        this.testContext = testContext;
    }

    @When("I send a query to get modules table with a limit {int}")
    public void iSendAQueryToGetModulesTableWithALimit(int moduleCount) {
        testContext.sharedData.put("moduleCount", testContext.DB().DBUtils.getAllModules(5).size());
    }

    @Then("Verify I get {int} modules only from db")
    public void verifyIGetModulesOnlyFromDb(int moduleCount) {
        Assert.assertEquals(moduleCount, testContext.sharedData.get("moduleCount"));
    }
}
