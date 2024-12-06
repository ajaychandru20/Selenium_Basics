package com.practicetestautomationone.pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SucessfulLoginPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private By logOutLocator = By.linkText("Log out");

    public SucessfulLoginPage(WebDriver driver){

        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public String getCurrentURL(){
        return driver.getCurrentUrl();
    }
    public String getSourcePage(){
        return driver.getPageSource();
    }
    public boolean isLogoutButtonDisplay(){
        try {
            return driver.findElement(logOutLocator).isDisplayed();
        }catch (NoSuchElementException e){
            return false;
        }
    }

}
