package io.techleadacademy.pages;

import io.techleadacademy.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "form3Example3")
    public WebElement usernameField;

    @FindBy(id = "form3Example4")
    public WebElement passwordField;

    @FindBy(xpath = "//button[contains(text(),'Login')]")
    public WebElement loginBtn;

    public void login(String userType) {
        String username = null;
        String password = null;

        switch (userType.toLowerCase()){
            case "admin":
                username = ConfigReader.readProperty("username-admin");
                password = ConfigReader.readProperty("password-admin");
                break;
            case "student":
                username = ConfigReader.readProperty("username-student");
                password = ConfigReader.readProperty("password-student");
                break;
        }

        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginBtn.click();
    }

}
