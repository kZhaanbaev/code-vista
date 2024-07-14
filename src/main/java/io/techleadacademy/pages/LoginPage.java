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

    @FindBy(id = "username")
    public WebElement usernameField;

    @FindBy(id = "password")
    public WebElement passwordField;

    @FindBy(id = "Login")
    public WebElement loginBtn;


    public void loginAsAdmin() {
        usernameField.sendKeys(ConfigReader.readProperty("username"));
        passwordField.sendKeys(ConfigReader.readProperty("password"));
        loginBtn.click();
    }

}
