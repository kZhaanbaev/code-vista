package io.techleadacademy.stepDefs.uiSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.techleadacademy.core.TestContext;
import org.junit.Assert;

public class LoginSteps {
    private final TestContext testContext;

    public LoginSteps(TestContext testContext){
        this.testContext = testContext;
    }

    @Then("Verify title of the page should contain Home")
    public void verifyTitleOfThePageShouldContainHome() {
        testContext.UI().getBrowserUtils().Waits.waitForTitleToContain("CodeVista");
        Assert.assertTrue(testContext.UI().getDriver().getTitle().contains("CodeVista"));
    }

    @Given("I login to code-vista app")
    public void iLoginToCodeVistaApp() {
        testContext.UI().getLoginPage().loginAsAdmin();
    }
}
