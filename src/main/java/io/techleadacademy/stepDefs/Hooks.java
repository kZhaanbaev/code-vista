package io.techleadacademy.stepDefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.techleadacademy.core.TestContext;
import io.techleadacademy.utils.ConfigReader;

public class Hooks {
    private final TestContext testContext;

    public Hooks(TestContext testContext){
        this.testContext = testContext;
    }

    @Before
    public void setUp(){
        testContext.UI().getDriver().get(ConfigReader.readProperty("url"));
    }

    @After
    public void tearDown(Scenario scenario){
        if (scenario.isFailed()){
            testContext.UI().getBrowserUtils().logFailScreenshot(scenario);
        }
        if (testContext.UI().getDriver() != null)
            testContext.UI().getDriver().quit();
    }
}
