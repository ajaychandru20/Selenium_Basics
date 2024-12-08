package com.practicetestautomationone.tests.exceptionhandling;

import com.practicetestautomationone.errorhandelpom.ErrorHandel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ErrorHandlingTest {
    private WebDriver driver;
    private Logger logger;
    private WebDriverWait wait;


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

    @Test
    public void testNoSuchElementException() {
        logger.info("Browser Starts to run");
        ErrorHandel errorHandel = new ErrorHandel(driver);
        errorHandel.visit();
        errorHandel.clickAddButton();
        logger.info("Add Element clicked");
        Assert.assertTrue(errorHandel.isRowTwoDisplayedAfterAdd(), "Row 2 input field is not displayed");
    }

    @Test
    public void testElementNotInteractableException() {


        ErrorHandel errorHandel = new ErrorHandel(driver);
        errorHandel.visit();
        errorHandel.clickAddButton();
        logger.info("Add Element clicked");
        Assert.assertTrue(errorHandel.isRowTwoDisplayedAfterAdd());
        errorHandel.enterDataInSecondRow("2nd Row found, typed Test");
        errorHandel.clickRow2SaveButton();
        Assert.assertEquals(errorHandel.conformationMessage(), "Row 2 was saved");

    }

    @Test
    public void testInvalidElementStateException() {

        ErrorHandel errorHandel = new ErrorHandel(driver);
        errorHandel.visit();
        logger.info("Select the Edit button");
        errorHandel.clickEditButton();
        logger.info("Clearing the 1st Row input");
        errorHandel.clearInputFieldAndSendData("Ajay");
        errorHandel.clickSaveButton();
        logger.info("Assertion after Record added");
        Assert.assertEquals(errorHandel.conformationMessage(), "Row 1 was saved");
    }

    @Test
    public void StaleElementReferenceException() {

        ErrorHandel errorHandel = new ErrorHandel(driver);
        errorHandel.visit();
        logger.info("Select the Add button");
        errorHandel.clickAddButton();
        Assert.assertTrue(errorHandel.isInstructionsElementHiddenAfterWait(), "Instructions text is still displayed");
    }

}

