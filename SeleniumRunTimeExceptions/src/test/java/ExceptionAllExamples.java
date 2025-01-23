
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class ExceptionAllExamples {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://www.google.com/");

            // WebDriverException: General WebDriver failure
            try {
                driver.get(null);
            } catch (WebDriverException e) {
                System.out.println("WebDriverException: Invalid URL.");
            }

            // NoSuchElementException: Element not found
            try {
                driver.findElement(By.id("nonexistent-element"));
            } catch (NoSuchElementException e) {
                System.out.println("NoSuchElementException: Element not found.");
            }

            // StaleElementReferenceException: Stale reference to an element
            try {
                WebElement staleElement = driver.findElement(By.id("stale-element"));
                driver.navigate().refresh(); // Causes the reference to become stale
                staleElement.click();
            } catch (StaleElementReferenceException e) {
                System.out.println("StaleElementReferenceException: Element is no longer attached to the DOM.");
            }

            // UnhandledAlertException: Unexpected alert
            try {
                driver.switchTo().alert().dismiss();
            } catch (UnhandledAlertException e) {
                System.out.println("UnhandledAlertException: Unexpected alert not handled.");
            }

            // InvalidElementStateException: Invalid action on an element
            try {
                WebElement disabledElement = driver.findElement(By.id("disabled-button"));
                disabledElement.sendKeys("Text");
            } catch (InvalidElementStateException e) {
                System.out.println("InvalidElementStateException: Element is not in a state to interact.");
            }

            // ElementNotVisibleException: Element is not visible
            try {
                WebElement hiddenElement = driver.findElement(By.id("hidden-element"));
                hiddenElement.click();
            } catch (ElementNotInteractableException e) { // Replaced in newer Selenium versions
                System.out.println("ElementNotInteractableException: Element is not visible or interactable.");
            }

            // NoSuchFrameException: Frame not found
            try {
                driver.switchTo().frame("nonexistent-frame");
            } catch (NoSuchFrameException e) {
                System.out.println("NoSuchFrameException: Frame not found.");
            }

            // NoSuchSessionException: Session does not exist
            try {
                driver.quit();
                driver.get("https://example.com");
            } catch (NoSuchSessionException e) {
                System.out.println("NoSuchSessionException: WebDriver session is already closed.");
            }

            // UnreachableBrowserException: Browser not reachable
            try {
                WebDriver unreachableDriver = new ChromeDriver();
                unreachableDriver.quit();
                unreachableDriver.get("https://example.com");
            } catch (WebDriverException e) {
                System.out.println("UnreachableBrowserException: Browser is unreachable.");
            }

            // NoSuchWindowException: Window not found
            try {
                driver.switchTo().window("nonexistent-window");
            } catch (NoSuchWindowException e) {
                System.out.println("NoSuchWindowException: Window not found.");
            }

            // TimeoutException: Command timeout
            try {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
                wait.until(ExpectedConditions.presenceOfElementLocated(By.id("slow-element")));
            } catch (TimeoutException e) {
                System.out.println("TimeoutException: Operation timed out.");
            }

            // SessionNotCreatedException: Session creation failure
            try {
                ChromeOptions invalidOptions = new ChromeOptions();
                invalidOptions.addArguments("--invalid-option");
                WebDriver invalidDriver = new ChromeDriver(invalidOptions);
            } catch (SessionNotCreatedException e) {
                System.out.println("SessionNotCreatedException: Failed to create a new WebDriver session.");
            }

            // JavascriptException: JavaScript execution failure
            try {
                ((JavascriptExecutor) driver).executeScript("invalidJavascriptFunction()");
            } catch (JavascriptException e) {
                System.out.println("JavascriptException: Error executing JavaScript.");
            }

        } finally {
            // Cleanup
            driver.quit();
        }
    }
}

