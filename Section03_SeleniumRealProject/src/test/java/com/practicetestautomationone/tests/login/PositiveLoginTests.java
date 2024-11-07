package com.practicetestautomationone.tests.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveLoginTests {

    @Test
    public void testLoginFunctionPositive() {

//    Open page
        WebDriver driver = new ChromeDriver();
        driver.get("https://practicetestautomation.com/practice-test-login/");
//    Type username student into Username field
        WebElement usernameInput = driver.findElement(By.id("username"));
        usernameInput.sendKeys("student");

//    Type password Password123 into Password field
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("Password123");
//    Push Submit button
        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

//    Verify new page URL contains practicetestautomation.com/logged-in-successfully/
        String expectedURL = "https://practicetestautomation.com/logged-in-successfully/";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL);

//    Verify new page contains expected text ('Congratulations' or 'successfully logged in')
        String expectedFinalMsg = "successfully logged in";
        String actualFinalMsg = driver.getPageSource();
        Assert.assertTrue(actualFinalMsg.contains(expectedFinalMsg));

//    Verify button Log out is displayed on the new page

        WebElement LogoutButton = driver.findElement(By.linkText("Log out"));
        Assert.assertTrue(LogoutButton.isDisplayed());

    }

    @Test
    public void testLoginWithInvalidUsername() {
        // Open page
        WebDriver driver = new ChromeDriver();
        driver.get("https://practicetestautomation.com/practice-test-login/");

        // Type username "incorrectUser" into Username field
        WebElement usernameInput = driver.findElement(By.id("username"));
        usernameInput.sendKeys("incorrectUser");

        // Type password "Password123" into Password field
        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys("Password123");

        // Push Submit button
        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        // Verify error message is displayed
        WebElement errorMessage = driver.findElement(By.id("error"));
        Assert.assertTrue(errorMessage.isDisplayed());

        // Verify error message text is "Your username is invalid!"
        String expectedErrorMessage = "Your username is invalid!";
        String actualErrorMessage = errorMessage.getText();
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage);

        driver.quit();
    }

    @Test
    public void testLoginWithInvalidPassword() {
        // Open page
        WebDriver driver = new ChromeDriver();
        driver.get("https://practicetestautomation.com/practice-test-login/");

        // Type username "student" into Username field
        WebElement usernameInput = driver.findElement(By.id("username"));
        usernameInput.sendKeys("student");

        // Type password "incorrectPassword" into Password field
        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys("incorrectPassword");

        // Push Submit button
        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        // Verify error message is displayed
        WebElement errorMessage = driver.findElement(By.id("error"));
        Assert.assertTrue(errorMessage.isDisplayed());

        // Verify error message text is "Your password is invalid!"
        String expectedErrorMessage = "Your password is invalid!";
        String actualErrorMessage = errorMessage.getText();
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage);

        driver.quit();
    }

}
