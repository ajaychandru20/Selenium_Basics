import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class LocatorsExamples {
    // Find WebElement for the "Selenium WebDriver with Java for beginners program" link using link text and partial link text
    // Find WebElements for the input field using tag, class name, XPath, and CSS
    // Create a list of WebElements for all buttons using tag
    // Identify both buttons, using ID, name, CSS, XPath for each

    public static void main(String[] args){

        WebDriver driver = new ChromeDriver();
        driver.get("https://practicetestautomation.com/practice-test-exceptions/");

//           String result =  partialLinkTexts(driver);
//        String result = fullLinkTexts(driver);
//        String result = tagNames(driver);
//        String result = className(driver);
                String result = listWebElements(driver);
           try{
               System.out.println(result);
           }catch (Exception e){
               System.out.println("An error occurred: " + e.getMessage());
           }finally {
               driver.quit();
           }

    }

    public static String partialLinkTexts(WebDriver driver){
        WebElement partialLinkText = driver.findElement(By.partialLinkText("Selenium WebDriver"));
        boolean status = partialLinkText.isDisplayed();
        return "Is that the partial linked test working or not?: " + status;

    }
    public static String fullLinkTexts(WebDriver driver){
        WebElement fullLinkText = driver.findElement(By.linkText("Selenium WebDriver with Java for beginners program."));
        boolean status = fullLinkText.isDisplayed();
        return "Is that the Full linked test working or not?: " + status;
    }
    public static String tagNames(WebDriver driver){
        WebElement tagNames = driver.findElement(By.tagName("input"));
        boolean status = tagNames.isDisplayed();
        return "Is that the tagName test working or not?: " + status;
    }
    public static String className(WebDriver driver){
        WebElement className = driver.findElement(By.className("input-field"));
        boolean status = className.isDisplayed();
        return "Is that the tagName test working or not?: " + status;
    }
    public static String listWebElements(WebDriver driver){
        List<WebElement> listOfInputs = driver.findElements(By.tagName("button"));
        boolean booleanLisOfInputs = false;
        for (WebElement element:listOfInputs){
            if (element.getText().contains("Add")){
                booleanLisOfInputs =true;
                break;
            }
        }
        return  "is the array contains the value?:  " + booleanLisOfInputs;
    }


}
