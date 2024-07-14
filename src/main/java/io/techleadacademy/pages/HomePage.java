package io.techleadacademy.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    public HomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@title='Accounts']/parent::one-app-nav-bar-item-root")
    public WebElement accountsNavBtn;
    @FindBy(xpath = "//a[@title='All Opportunities | Opportunities']/parent::one-app-nav-bar-item-root")
    public WebElement allOpportunitiesBtn;

    @FindBy(xpath = "//a[@title='Contacts']/parent::one-app-nav-bar-item-root")
    public WebElement contactsNavBtn;

    @FindBy(xpath = "//a[@title='Cases']/parent::one-app-nav-bar-item-root")
    public WebElement casesNavBtn;

    @FindBy(xpath = "//a[@title='Reports']/parent::one-app-nav-bar-item-root")
    public WebElement reportsNavBtn;

    @FindBy(xpath = "//a[@title='Dashboards']/parent::one-app-nav-bar-item-root")
    public WebElement dashboardsNavBtn;

}
