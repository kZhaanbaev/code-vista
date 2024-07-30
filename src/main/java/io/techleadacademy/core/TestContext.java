package io.techleadacademy.core;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.techleadacademy.pages.*;
import io.techleadacademy.utils.ApiUtils;
import io.techleadacademy.utils.BrowserUtils;
import io.techleadacademy.utils.DBUtils;
import org.openqa.selenium.WebDriver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

public class TestContext {
    private final UI UI;
    private final DB DB;
    private final API API;
    public Map<String, Object> sharedData;
    public Exception e;

    public TestContext() {
        UI = new UI();
        DB = new DB(this);
        API = new API(this);
        sharedData = new HashMap<>();
        e = new Exception();
    }
    public UI UI() {
        return this.UI;
    }
    public DB DB(){
        return this.DB;
    }
    public API API() {
        return this.API;
    }

    public class UI {
        private final WebDriver driver;
        private final BrowserUtils browserUtils;
        private final LoginPage loginPage;
        private final HomePage homePage;

        public UI(){
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

    public class DB {
        public Connection connection = null;
        public PreparedStatement preparedStatement = null;
        public ResultSet resultSet = null;
        public DBUtils DBUtils;

        public DB(TestContext testContext) {
            DBUtils = new DBUtils(testContext);
        }
    }

    public class API {
        public RequestSpecification requestSpecification;
        public Response response;
        public ApiUtils ApiUtils;

        public API(TestContext testContext) {
            ApiUtils = new ApiUtils(testContext);
        }
    }
}
