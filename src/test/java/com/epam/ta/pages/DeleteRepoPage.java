package com.epam.ta.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteRepoPage {

    private WebDriver driver;

    @FindBy(linkText = "Settings")
    private WebElement settings_locator;

    @FindBy(xpath = "//div[@class='Box Box--danger']//li[4]//summary")
    private WebElement delete_locator;

    @FindBy(xpath = "//div[@class='Box Box--danger']//li[4]//form/p/input")
    private WebElement consDel_locator;

    @FindBy(xpath = "//div[@class='Box Box--danger']//li[4]//form/button")
    private WebElement buttonDel_locator;

    public DeleteRepoPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void deleteRepo(String repoName){
        settings_locator.click();
        delete_locator.click();
        consDel_locator.sendKeys(repoName);
        buttonDel_locator.click();
    }

    public boolean checkDeleteRepo(String USERNAME,String repoName){
        try {
            WebElement repo = driver.findElement(By.linkText(USERNAME + "/" +
                    repoName));
            return false;
        } catch (NoSuchElementException e){
            return true;
        }

    }
}
