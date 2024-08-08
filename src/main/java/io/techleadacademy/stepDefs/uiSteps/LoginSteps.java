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
        testContext.UI().getBrowserUtils().logFailScreenshot(testContext.scenario);
    }

    @Given("I login to code-vista app as {string}")
    public void iLoginToCodeVistaAppAs(String user) {
        testContext.UI().getLoginPage().login(user);
    }
}
