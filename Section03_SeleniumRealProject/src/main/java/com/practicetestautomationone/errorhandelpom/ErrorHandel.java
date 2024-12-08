package com.practicetestautomationone.errorhandelpom;

import com.practicetestautomationone.pageobjectmodel.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ErrorHandel extends BasePage {

    private By clickAddButtonLocator = By.id("add_btn");
    private By secondRowFieldLocator = By.id("row2");
    private By firstRowInputFieldLocator = By.xpath("//div[@id='row1']/input");
    private By secondRowInputFieldLocator = By.xpath("//div[@id='row2']/input");
    private By clickRow2SaveButtonLocator = By.xpath("//div[@id='row2']/button[@name='Save']");
    private By editButtonElementLocator = By.id("edit_btn");
    private By saveButtonElementLocator = By.id("save_btn");
    private By confomationMessageLocator = By.id("confirmation");
    private By instructionsLocator = By.id("instructions");



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
    public boolean isRowTwoDisplayedAfterAdd(){
        return waitForIsDisplayed(secondRowFieldLocator);
    }

    public void enterDataInSecondRow(String data){
     WebElement inputFieldForRow2 =  waitForElement(secondRowInputFieldLocator);
     inputFieldForRow2.sendKeys(data);
    }
    public void clickRow2SaveButton(){
        WebElement inputFieldForRow2 =  waitForElement(clickRow2SaveButtonLocator);
        inputFieldForRow2.click();
    }

    public String conformationMessage(){
        WebElement conformationMsg = waitForElement(confomationMessageLocator);
        return conformationMsg.getText();
    }
    public void clickEditButton(){
        WebElement editButtonElement = waitForElement(editButtonElementLocator);
        editButtonElement.click();
    }
    public void clearInputFieldAndSendData(String data){
        WebElement clearInputFieldAndSendData = waitForElement(firstRowInputFieldLocator);
        clearInputFieldAndSendData.clear();
        clearInputFieldAndSendData.sendKeys(data);
    }
    public void clickSaveButton(){
        WebElement saveButton =  waitForElement(saveButtonElementLocator);
        saveButton.click();
    }
    public boolean isInstructionsElementHiddenAfterWait() {
        return waitForIsHidden(instructionsLocator);
    }




}
