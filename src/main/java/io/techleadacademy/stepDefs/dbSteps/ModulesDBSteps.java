package io.techleadacademy.stepDefs.dbSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.techleadacademy.core.TestContext;
import io.techleadacademy.pojo.Module;
import org.junit.Assert;

import java.util.Arrays;
import java.util.Map;

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

    @When("I add a new module with the following details:")
    public void iAddANewModuleWithTheFollowingDetails(Map<String, Object> map) {

        Module module = new Module(
                Integer.parseInt(map.get("module_id").toString()),
                map.get("module_name").toString(),
                Double.parseDouble(map.get("module_order").toString()),
                map.get("video_link").toString()
        );
        testContext.DB().DBUtils.createNewModule(module);
    }

    @And("I send query to get data with {string} column name and value {string} from {string} table")
    public void iSendQueryToGetDataWithColumnNameAndValueFromTable(String column, String value, String table) {
        testContext.sharedData.put("row", testContext.DB().DBUtils.getRowData(column, value, table).size());
    }

    @Then("Verify module count is {int}")
    public void verifyModuleCountIs(int count) {
        Assert.assertTrue(Integer.parseInt(testContext.sharedData.get("row").toString()) >= count);
    }

    @And("I attempt to add another module with the same module_id:")
    public void iAttemptToAddAnotherModuleWithTheSameModule_id(Map<String, Object> map) {
        try{
        Module module = new Module(
                Integer.parseInt(map.get("module_id").toString()),
                map.get("module_name").toString(),
                Double.parseDouble(map.get("module_order").toString()),
                map.get("video_link").toString()
        );
        testContext.DB().DBUtils.createNewModule(module);
    }catch (Exception exception){
        testContext.e = exception;
        }
        }


    @Then("Verify an exception is thrown")
    public void verifyAnExceptionIsThrown() {
        Assert.assertTrue("Expected a duplicate key exception, but got: " + testContext.e.getMessage(),
                testContext.e.getMessage().contains("duplicate key value violates unique constraint"));
    }


    @When("I update the {string} column which has {int} id with {string} value")
    public void iUpdateTheColumnWhichHasIdWithValue(String column, int module_id, String value) {
        testContext.DB().DBUtils.updateModuleDataById(column, value, module_id);
    }
}
