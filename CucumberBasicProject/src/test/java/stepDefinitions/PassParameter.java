package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PassParameter {

    WebDriver driver;

    WebDriverWait wait;


    @Given("login into the HMRC portal")
    public void login_into_the_hmrc_portal() {

        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @Then("enter the username {string} and password {string}")
    public void enter_the_username_and_password(String string, String string2) {

        WebElement usernameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
        usernameInput.sendKeys(string);

        WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
        passwordInput.sendKeys(string2);
    }
    @Then("click the Login button")
    public void click_the_login_button() {
        try {
            // Wait for the login button to be visible and click it
            WebElement loginButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()=' Login ']")));
            loginButton.click();

            // Wait for the dashboard element in the navbar to appear
            WebElement dashboardInNavbar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Dashboard")));

            // Check if the dashboard is displayed
            if (dashboardInNavbar.isDisplayed()) {
                System.out.println("Page successfully logged in. Visibility of dashboard is: " + dashboardInNavbar.isDisplayed());
            } else {
                System.out.println("Dashboard is not visible");
            }
        } catch (Exception e) {
            System.err.println("An unexpected exception occurred: " + e.getMessage());
        } finally {
            // Ensure driver quits in any scenario
            if (driver != null) {
                driver.quit();
            }
        }
    }



}
