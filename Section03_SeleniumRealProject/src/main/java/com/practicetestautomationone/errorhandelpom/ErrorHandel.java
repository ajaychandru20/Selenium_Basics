package com.practicetestautomationone.errorhandelpom;

import com.practicetestautomationone.pageobjectmodel.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ErrorHandel extends BasePage {

    private By clickAddButtonLocator = By.id("add_btn");
    private By secondInputFieldLocator = By.id("row2");

    public ErrorHandel(WebDriver driver){
        super(driver);
    }
    public void visit() {
        super.visit("https://practicetestautomation.com/practice-test-exceptions/");
    }

    public void clickAddButton(){
        WebElement clickAddButton = driver.findElement(clickAddButtonLocator);
        clickAddButton.click();
    }

    public boolean isRowTwoDisplayed(){
        return waitForIsDisplayed(secondInputFieldLocator);
    }



}
