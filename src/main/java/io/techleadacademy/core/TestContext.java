package io.techleadacademy.core;

import io.techleadacademy.pages.*;
import io.techleadacademy.utils.BrowserUtils;
import org.openqa.selenium.WebDriver;

public class TestContext {
    private final UI UI;

    public TestContext(WebDriver driver) {
        UI = new UI(driver);
    }
    public UI UI() {
        return this.UI;
    }

    public class UI {
        private final WebDriver driver;
        private final BrowserUtils browserUtils;
        private final LoginPage loginPage;
        private final HomePage homePage;

        public UI(WebDriver driver){
            this.driver = new Driver().initializeDriver("chrome");
            this.browserUtils = new BrowserUtils(driver);
            this.loginPage = new LoginPage(driver);
            this.homePage = new HomePage(driver);
        }

        public WebDriver getDriver() {
            return this.driver;
        }

        public BrowserUtils getBrowserUtils() {
            return this.browserUtils;
        }

        public LoginPage getLoginPage() {
            return this.loginPage;
        }

        public HomePage getHomePage() {
            return this.homePage;
        }
    }
}
