package com.practicetestautomationone.tests.login;

import com.practicetestautomationone.pageobjectmodel.LoginPage;
import com.practicetestautomationone.pageobjectmodel.SucessfulLoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginTests {

    private  WebDriver driver;
    private Logger logger;

    @BeforeTest(alwaysRun = true)
    @Parameters("browser")
    public void openBrowserTest(@Optional("firefox") String browsers){
        logger = Logger.getLogger(LoginTests.class.getName());
        logger.setLevel(Level.INFO);
        logger.info("Running the browser: " + browsers);
//    Open page
        switch (browsers.toLowerCase()){
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            default:
                logger.warning("Default browser runs in the Chrome Driver");
                driver = new ChromeDriver();
                break;
        }
    }

    @AfterTest(alwaysRun = true)
    public void  closeBrowsers(){
        driver.quit();
    }

    @Test(groups = {"regression","positive", "smoke"})
    public void testLoginFunctionPositive() {

        logger.info("Type username and password");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.visit();
        SucessfulLoginPage sucessfulLoginPage = loginPage.executeLogin("student", "Password123");
        sucessfulLoginPage.waitForLocator();
        logger.info("Verify the login checks");
        Assert.assertEquals(sucessfulLoginPage.getCurrentURL(), "https://practicetestautomation.com/logged-in-successfully/");
        Assert.assertTrue(sucessfulLoginPage.getSourcePage().contains("successfully logged in"));
        Assert.assertTrue(sucessfulLoginPage.isLogoutButtonDisplay());

    }

    @Test(groups = {"regression","negative"})
    public void testLoginWithInvalidUsername() {
        // Open page
        logger = Logger.getLogger(LoginTests.class.getName());
        logger.setLevel(Level.INFO);
        WebDriver driver = new ChromeDriver();
        driver.get("https://practicetestautomation.com/practice-test-login/");

        // Type username "incorrectUser" into Username field
        WebElement usernameInput = driver.findElement(By.id("username"));
        logger.info("Incorrect User Type");
        usernameInput.sendKeys("incorrectUser");

        // Type password "Password123" into Password field
        WebElement passwordInput = driver.findElement(By.id("password"));
        logger.info("Incorrect Password Type");
        passwordInput.sendKeys("Password123");

        // Push Submit button
        WebElement submitButton = driver.findElement(By.id("submit"));
//        WebElement submitButton = driver.findElement(By.id("submiteds"));
        logger.info("Click Submit");
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

    @Test(groups = {"regression","negative"})
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

        try{
            Thread.sleep(1500);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        Assert.assertTrue(errorMessage.isDisplayed());

        // Verify error message text is "Your password is invalid!"
        String expectedErrorMessage = "Your password is invalid!";
        String actualErrorMessage = errorMessage.getText();
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage);

        driver.quit();
    }

    @Parameters({"username","password","errorMessageInput"})
    @Test(groups = {"paramatertest"})
    public void testWithParameterLogins(String username, String password, String errorMessageInput){

        WebDriver driver = new ChromeDriver();
        driver.get("https://practicetestautomation.com/practice-test-login/");

        // Type username "student" into Username field
        WebElement usernameInput = driver.findElement(By.id("username"));
        usernameInput.sendKeys(username);

        // Type password "incorrectPassword" into Password field
        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys(password);

        // Push Submit button
        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        // Verify error message is displayed
        WebElement errorMessage = driver.findElement(By.id("error"));

        try{
            Thread.sleep(1500);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        Assert.assertTrue(errorMessage.isDisplayed());

        // Verify error message text is "Your password is invalid!"
        String actualErrorMessage = errorMessage.getText();
        Assert.assertEquals(errorMessageInput, actualErrorMessage);

        driver.quit();
    }

}
