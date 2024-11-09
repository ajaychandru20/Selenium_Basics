package com.practicetestautomationone.tests.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class CrossBrowserTests {

    @Test
    public void testOpenChromeBrowser(){

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.quit();

    }

    @Test
    public void testOpenEdgeBrowser(){
        System.setProperty("webdriver.edge.driver","src/main/resources/msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.google.com/");
        driver.quit();
    }


}
