import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumDemoTest {
    public static void main(String[] arg){
        String url = "https://www.google.com/";
        String visitedPage = chromeRunner(url);
        System.out.println(visitedPage);

    }
    private static String chromeRunner(String url){
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        String title = driver.getTitle();
        driver.quit();
        return title;

    }
}
