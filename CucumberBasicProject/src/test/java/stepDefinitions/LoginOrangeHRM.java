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

public class LoginOrangeHRM {

    WebDriver driver;

    WebDriverWait wait;

    @Given("Open Chrome then navigate to the Login page")
    public void open_chrome_then_navigate_to_the_login_page() {

        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));


    }
    @Then("Enter the username and password")
    public void enter_the_username_and_password() {
        WebElement usernameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
        usernameInput.sendKeys("Admin");

        WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
        passwordInput.sendKeys("admin123");
    }
    @Then("Click the login button")
    public void click_the_login_button() {
        WebElement loginButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()=' Login ']")));
        loginButton.click();
    }
    @Then("Validate the dashboard page, after login")
    public void validate_the_dashboard_page_after_login() {

        WebElement dashboardInNavbar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Dashboard")));

        if (dashboardInNavbar.isDisplayed()){
            System.out.println("Page successfully login, visibility of dashboard is : " + dashboardInNavbar.isDisplayed());
        }else {
            System.out.println("Dashboard is not visible");
        }
        driver.quit();

    }

}
