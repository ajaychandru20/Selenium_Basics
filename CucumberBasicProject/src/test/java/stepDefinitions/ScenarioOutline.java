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

public class ScenarioOutline {

    WebDriver driver;
    WebDriverWait wait;

    @Given("login into the Orange portal so")
    public void login_into_the_orange_portal_so() {
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }
    @Then("Enter the {string} and {string} with so")
    public void enter_the_user_name_and_password_with_so(String UserName, String Password) {


        // Interact with the login page
        WebElement usernameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
        usernameInput.sendKeys(UserName);

        WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
        passwordInput.sendKeys(Password);


    }
    @Then("click the Login button and validate Dashboard then close so")
    public void click_the_login_button_and_validate_dashboard_then_close_so() {

        try {
            // Wait for the login button and click it
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
            if (driver != null) {
                driver.quit();
            }
        }

    }


}
