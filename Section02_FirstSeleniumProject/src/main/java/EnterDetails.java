import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EnterDetails {

      public static void main(String[] arg){

          WebDriver driver = new ChromeDriver();
          driver.get("https://practicetestautomation.com/practice-test-login/");

          WebElement username = driver.findElement(By.id("username"));
          username.sendKeys("student");
          WebElement password = driver.findElement(By.id("password"));
          password.sendKeys("Password123");

          WebElement submit = driver.findElement(By.id("submit"));
          submit.click();

          driver.quit();



      }


}
