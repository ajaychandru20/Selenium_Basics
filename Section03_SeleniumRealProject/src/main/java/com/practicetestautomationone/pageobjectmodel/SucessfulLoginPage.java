package com.practicetestautomationone.pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SucessfulLoginPage extends BasePage {
    private By logOutLocator = By.linkText("Log out");

    public SucessfulLoginPage(WebDriver driver) {
        super(driver);
    }

    public boolean isLogoutButtonDisplay(){
        return isDisplayedBasePage(logOutLocator);
    }
    public void waitForLocator(){
        waitForElement(logOutLocator);
    }




}
