package com.exceptionhandleing.tests.loin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ErrorHandlingTest {
    private WebDriver driver;
    private Logger logger;

    @Test
    public void testNoSuchElementException(){
        driver = new ChromeDriver();
        logger = Logger.getLogger(ErrorHandlingTest.class.getName());
        logger.setLevel(Level.INFO);
        logger.info("Browser Starts to run");
        driver.get("https://practicetestautomation.com/practice-test-exceptions/");
        WebElement clickAddButton = driver.findElement(By.id("add_btn"));
        clickAddButton.click();

        try {
            Thread.sleep(7000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        logger.info("Add Element clicked");
        WebElement secondInputField = driver.findElement(By.id("row2"));
//        secondInputField.sendKeys("2nd Row founded");
        Assert.assertTrue(secondInputField.isDisplayed());
        driver.quit();
    }

}
