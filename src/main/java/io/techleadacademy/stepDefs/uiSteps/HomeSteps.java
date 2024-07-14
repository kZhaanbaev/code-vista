package io.techleadacademy.stepDefs.uiSteps;

import io.cucumber.java.en.Then;
import io.techleadacademy.core.TestContext;
import org.junit.Assert;

import java.util.List;

public class HomeSteps {
    private final TestContext testContext;

    public HomeSteps(TestContext testContext) {
        this.testContext = testContext;
    }

    @Then("Verify URL is ending with {string}")
    public void verify_url_is_ending_with(String url) {
        Assert.assertTrue(testContext.UI().getDriver().getCurrentUrl().endsWith(url));
    }

    @Then("Verify {string} navigation button is visible")
    public void verifyNavigationButtonIsVisible(String button) {
        switch (button.toLowerCase()) {
            case "accounts":
                Assert.assertTrue(testContext.UI().getHomePage().accountsNavBtn.isDisplayed());
                break;
            case "contacts":
                Assert.assertTrue(testContext.UI().getHomePage().contactsNavBtn.isDisplayed());
                break;
            case "cases":
                Assert.assertTrue(testContext.UI().getHomePage().casesNavBtn.isDisplayed());
                break;
            default:
                Assert.fail(button + " navigation button was not found");
        }
    }


//    @Then("Validate following nav buttons take you to correct page containing name of the button in URL:")
//    public void validateFollowingNavButtonsTakeYouToCorrectPageContainingNameOfTheButtonInURL(List<String> list) {
//        for(String each: list){
//            switch (each.toLowerCase()){
//                case "accounts":
//                    testContext.UI().getHomePage().accountsNavBtn.click();
//                    testContext.UI().getBrowserUtils().Waits.waitForURLToContainText("Account");
//                    Assert.assertTrue(testContext.UI().getDriver().getCurrentUrl().contains("Account"));
//                    break;
//                case "contacts":
//                    testContext.UI().getHomePage().contactsNavBtn.click();
//                    testContext.UI().getBrowserUtils().Waits.waitForURLToContainText("Contact");
//                    Assert.assertTrue(testContext.UI().getDriver().getCurrentUrl().contains("Contact"));
//                    break;
//                case "cases":
//                    testContext.UI().getHomePage().casesNavBtn.click();
//                    testContext.UI().getBrowserUtils().Waits.waitForURLToContainText("Case");
//                    Assert.assertTrue(testContext.UI().getDriver().getCurrentUrl().contains("Case"));
//                    break;
//                case "reports":
//                    testContext.getHomePage().reportsNavBtn.click();
//                    testContext.getBrowserUtils().Waits.waitForURLToContainText("Report");
//                    Assert.assertTrue(testContext.getDriver().getCurrentUrl().contains("Report"));
//                    break;
//                case "dashboards":
//                    testContext.getHomePage().dashboardsNavBtn.click();
//                    testContext.getBrowserUtils().Waits.waitForURLToContainText("Dashboard");
//                    Assert.assertTrue(testContext.getDriver().getCurrentUrl().contains("Dashboard"));
//                    break;
//                default: Assert.fail("URL was not correct");
//            }
//        }
//    }
//
//    @Then("Validate {string} nav button takes you to correct page containing name of the button in URL:")
//    public void validate_accounts_nav_button_takes_you_to_correct_page_containing_name_of_the_button_in_url(String navButton) {
//        switch (navButton.toLowerCase()){
//            case "accounts":
//                testContext.getHomePage().accountsNavBtn.click();
//                testContext.getBrowserUtils().Waits.waitForURLToContainText("Account");
//                Assert.assertTrue(testContext.getDriver().getCurrentUrl().contains("Account"));
//                break;
//            case "contacts":
//                testContext.getHomePage().contactsNavBtn.click();
//                testContext.getBrowserUtils().Waits.waitForURLToContainText("Contact");
//                Assert.assertTrue(testContext.getDriver().getCurrentUrl().contains("Contact"));
//                break;
//            case "cases":
//                testContext.getHomePage().casesNavBtn.click();
//                testContext.getBrowserUtils().Waits.waitForURLToContainText("Case");
//                Assert.assertTrue(testContext.getDriver().getCurrentUrl().contains("Case"));
//                break;
//            case "reports":
//                testContext.getHomePage().reportsNavBtn.click();
//                testContext.getBrowserUtils().Waits.waitForURLToContainText("Report");
//                Assert.assertTrue(testContext.getDriver().getCurrentUrl().contains("Report"));
//                break;
//            case "dashboards":
//                testContext.getHomePage().dashboardsNavBtn.click();
//                testContext.getBrowserUtils().Waits.waitForURLToContainText("Dashboard");
//                Assert.assertTrue(testContext.getDriver().getCurrentUrl().contains("Dashboard"));
//                break;
//            default: Assert.fail("URL was not correct");
//        }
//        testContext.getBrowserUtils().Waits.waitForPageToLoad();
//    }
}
