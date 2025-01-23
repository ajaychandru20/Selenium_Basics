package com.practicetestautomationone.tests;

import com.practicetestautomationone.tests.exceptionhandling.ErrorHandlingTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseTest {

    protected WebDriver driver;
    protected Logger logger;
    protected WebDriverWait wait;


    @BeforeTest
    public void startBrowser() {
        driver = new ChromeDriver();
        logger = Logger.getLogger(ErrorHandlingTest.class.getName());
        logger.setLevel(Level.INFO);
    }

    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }
}
