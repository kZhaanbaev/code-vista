package io.techleadacademy.stepDefs.dbSteps;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.techleadacademy.core.DBConnection;
import io.techleadacademy.core.TestContext;
import io.techleadacademy.pojo.User;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

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


    @When("I create a new user with following details:")
    public void iCreateANewUserWithFollowingDetails(Map<String, Object> map) {
//        ObjectMapper mapper = new ObjectMapper();
//        User user = mapper.convertValue(map, User.class);
        User user = new User(
                Integer.parseInt(map.get("user_id").toString()),
                map.get("first_name").toString(),
                map.get("last_name").toString(),
                map.get("email").toString(),
                map.get("password").toString(),
                map.get("role").toString()
        );
        testContext.DB().DBUtils.createNewUser(user);
    }

    @And("I fetch data with {string} column name and value {string} from {string} table")
    public void iFetchDataWithColumnNameAndValueFromTable(String column, String value, String table) {
        testContext.sharedData.put("row", testContext.DB().DBUtils.getRowData(column, value, table).size());
    }

    @Then("Verify user count is {int}")
    public void verifyUserCountIs(int count) {
        Assert.assertTrue(Integer.parseInt(testContext.sharedData.get("row").toString()) >= count);
    }
}
