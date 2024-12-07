package com.practicetestautomationone.pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    private By userNameLocator = By.id("username");
    private By userPasswordLocator = By.id("password");
    private By submitButtonLocator = By.id("submit");
    private By errorMessageLocator = By.id("error");


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void visit() {
        super.visit("https://practicetestautomation.com/practice-test-login/");
    }

    public void enterUserName(String username) {
        driver.findElement(userNameLocator).sendKeys(username);

    }

    public void enterPasswordName(String password) {
        driver.findElement(userPasswordLocator).sendKeys(password);

    }

    public void submitButton() {
        driver.findElement(submitButtonLocator).click();
    }

    public SucessfulLoginPage executeLogin(String username, String password) {
        enterUserName(username);
        enterPasswordName(password);
        submitButton();
        return new SucessfulLoginPage(driver);

    }

    public String errorMessage() {
        WebElement errorMessage = waitForElement(errorMessageLocator);
        return errorMessage.getText();
    }

}
