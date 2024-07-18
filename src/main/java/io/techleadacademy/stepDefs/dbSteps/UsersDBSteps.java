package io.techleadacademy.stepDefs.dbSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.techleadacademy.core.DBConnection;
import io.techleadacademy.core.TestContext;
import io.techleadacademy.pojo.User;
import org.junit.Assert;

import java.util.List;

public class UsersDBSteps {
    private TestContext testContext;

    public UsersDBSteps(TestContext testContext) {
        this.testContext = testContext;
    }

    @Given("I connect to database")
    public void i_connect_to_database() {
        testContext.DB().connection = DBConnection.connectToDB();
    }
    @When("I send a query to get users with a limit {int}")
    public void i_send_a_query_to_get_users_with_a_limit(Integer userCount) {
        List<User> list = testContext.DB().DBUtils.getAllUsers(userCount);
        testContext.sharedData.put("userCount", list.size());
    }
    @Then("Verify I get {int} users only")
    public void verify_i_get_users_only(Integer userCount) {
        Assert.assertEquals(userCount, testContext.sharedData.get("userCount"));
    }
}
