package com.practicetestautomationone.pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private By userNameLocator = By.id("username");
    private By userPasswordLocator = By.id("password");
    private By submitButtonLocator = By.id("submit");
    private By errorMessageLocator = By.id("error");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

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
    public SucessfulLoginPage executeLogin(String username, String password){
        enterUserName(username);
        enterPasswordName(password);
        submitButton();
        return new SucessfulLoginPage(driver);

    }

    public String errorMessage() {
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessageLocator));
        return errorMessage.getText();

    }

}
