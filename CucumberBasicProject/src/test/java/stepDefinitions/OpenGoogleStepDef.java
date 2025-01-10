package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OpenGoogleStepDef {

    WebDriver driver;
    WebElement searchBox;

    @Given("Open Chrome then search google")
    public void open_chrome_then_search_google() {
        driver = new ChromeDriver();
        driver.get("https://www.google.com/");
    }

    @When("user click the search field")
    public void user_click_the_search_field() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("APjFqb")));
        searchBox.click();
    }

    @Then("enter this name {string} and press enter")
    public void enter_this_name_and_press_enter(String query) {
        searchBox.sendKeys(query + Keys.ENTER);
    }
    @Then("close the browser")
    public void close_the_browser(){
        if (driver !=null){
            driver.quit();
        }
    }

}
