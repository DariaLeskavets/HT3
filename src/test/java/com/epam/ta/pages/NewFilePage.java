package com.epam.ta.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewFilePage {

    WebDriver driver;

    @FindBy(name = "filename")
    private WebElement fileName_locator;

    @FindBy(xpath = "//button[@id='submit-file']")
    private WebElement commitFile_locator;

    @FindBy(xpath = "//tbody//a[@title='testFile']")
    private WebElement linkCurrentFile;

    public NewFilePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void createNewFile(String fileName){
        fileName_locator.sendKeys(fileName);
        commitFile_locator.click();

    }

    public String getCurrentFileName(){
        return linkCurrentFile.getText();
    }

}
