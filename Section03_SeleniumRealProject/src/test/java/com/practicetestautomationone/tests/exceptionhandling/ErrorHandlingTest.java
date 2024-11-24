package com.practicetestautomationone.tests.exceptionhandling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ErrorHandlingTest {
    private WebDriver driver;
    private Logger logger;
    private WebDriverWait wait;

    @BeforeTest
    public void startBrowser(){
        driver = new ChromeDriver();
        logger = Logger.getLogger(ErrorHandlingTest.class.getName());
        logger.setLevel(Level.INFO);
        logger.info("Browser Starts to run");
        driver.get("https://practicetestautomation.com/practice-test-exceptions/");
        wait = new WebDriverWait(driver,Duration.ofSeconds(2));


    }
    @AfterTest
    public void closeBrowser(){
//        driver.quit();
    }
    @Test
    public void testNoSuchElementException(){
        WebElement clickAddButton = driver.findElement(By.id("add_btn"));
        clickAddButton.click();

//        try {
//            Thread.sleep(7000);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }

        logger.info("Add Element clicked");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(3000));
//        WebElement secondInputField = driver.findElement(By.id("row2"));
        WebElement secondInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("row2")));
        Assert.assertTrue(secondInputField.isDisplayed());
    }

    @Test
    public void testElementNotInteractableException(){

        WebElement clickAddButton = driver.findElement(By.id("add_btn"));
        clickAddButton.click();
        logger.info("Add Element clicked");

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(7));
        WebElement secondRow = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='row2']/input")));
        secondRow.sendKeys("2nd Row found, typed Test");

        WebElement saveButton = driver.findElement(By.xpath("//div[@id='row2']/button[@name='Save']"));
        saveButton.click();

        WebElement conformationDialougeBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("confirmation")));
        String conformationText = conformationDialougeBox.getText();
        Assert.assertEquals(conformationText, "Row 2 was saved");

    }
    @Test
    public void testInvalidElementStateException(){

        logger.info("Select the Edit button");

        WebElement editButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("edit_btn")));
        editButton.click();

        logger.info("Clearing the 1st Row input");

        WebElement secondRow = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='row1']/input")));
        secondRow.clear();
        secondRow.sendKeys("Text");
        WebElement saveButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("save_btn")));
        saveButton.click();

        logger.info("Assertion after Record added");

        WebElement conformationDialougeBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("confirmation")));
        String conformationText = conformationDialougeBox.getText();
        Assert.assertEquals(conformationText, "Row 1 was saved");

    }

    @Test
    public void StaleElementReferenceException(){
//        WebElement instructionElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("instructions")));

        WebElement clickAddButton = driver.findElement(By.id("add_btn"));
        clickAddButton.click();

//        Assert.assertFalse(instructionElement.isDisplayed(), "Instruction is still display");

        Assert.assertTrue(wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("instructions"))));
    }

}

