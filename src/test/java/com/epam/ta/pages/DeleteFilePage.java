package com.epam.ta.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteFilePage {

    WebDriver driver;

    @FindBy(xpath = "//tbody//a[@title='testFile']")
    private WebElement file_locator;

    @FindBy(xpath = "//div[@class='file-actions']//button[@aria-label='Delete this file']")
    private WebElement deleteButton_locator;

    @FindBy(xpath = "//button[@data-edit-text='Commit changes']")
    private WebElement commitChanges_locator;

    @FindBy(xpath = "//a[@title='Delete testFile']")
    private WebElement messageDel_locator;

    public DeleteFilePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void deleteFile(){
        file_locator.click();
        deleteButton_locator.click();
        commitChanges_locator.click();
    }

    public String getMessDel(){
       return messageDel_locator.getText();
    }

}




