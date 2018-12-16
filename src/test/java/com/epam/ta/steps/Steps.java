package com.epam.ta.steps;

import com.epam.ta.driver.DriverSingleton;
import com.epam.ta.pages.*;
import com.epam.ta.utils.Utils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class Steps
{
	private WebDriver driver;

	private final Logger logger = LogManager.getRootLogger();

	public void openBrowser()
	{
		driver = DriverSingleton.getDriver();
	}

	public void closeBrowser()
	{
		DriverSingleton.closeDriver();
	}

	public void loginGithub(String username, String password)
	{
		LoginPage loginPage = new LoginPage(driver);
		loginPage.openPage();
		loginPage.login(username, password);
	}

	public String getLoggedInUserName()
	{
		LoginPage loginPage = new LoginPage(driver);
		return loginPage.getLoggedInUserName().trim().toLowerCase();
	}

	public void createNewRepository(String repositoryName, String repositoryDescription)
	{
		MainPage mainPage = new MainPage(driver);
		mainPage.clickOnCreateNewRepositoryButton();
		CreateNewRepositoryPage createNewRepositoryPage = new CreateNewRepositoryPage(driver);
		createNewRepositoryPage.createNewRepository(repositoryName, repositoryDescription);
	}

	public boolean currentRepositoryIsEmpty()
	{
		CreateNewRepositoryPage createNewRepositoryPage = new CreateNewRepositoryPage(driver);
		return createNewRepositoryPage.isCurrentRepositoryEmpty();
	}

	public String getCurrentRepositoryName(){
		CreateNewRepositoryPage createNewRepositoryPage = new CreateNewRepositoryPage(driver);
		return createNewRepositoryPage.getCurrentRepositoryName();
	}

	public String generateRandomRepositoryNameWithCharLength(int howManyChars){
		String repositoryNamePrefix = "testRepo_";
		return repositoryNamePrefix.concat(Utils.getRandomString(howManyChars));
	}

	public void createNewFile(String fileName){
		CreateNewRepositoryPage repPage = new CreateNewRepositoryPage(driver);
		repPage.clickOnCreateNewFileButton();
		NewFilePage newFilePage = new NewFilePage(driver);
		newFilePage.createNewFile(fileName);
	}

	public String getCurrentFileName(){
		NewFilePage page = new NewFilePage(driver);
		return page.getCurrentFileName();
	}

	public void deleteFile(){
		DeleteFilePage page = new DeleteFilePage(driver);
		page.deleteFile();
	}

	public String getMessDel(){
		DeleteFilePage page = new DeleteFilePage(driver);
		return page.getMessDel();
	}

	public void deleteRepo(){
		DeleteRepoPage page = new DeleteRepoPage(driver);
		page.deleteRepo(this.getCurrentRepositoryName());
	}

	public boolean checkDeleteRepo(String USERNAME,String repoName){
		DeleteRepoPage page = new DeleteRepoPage(driver);
		return page.checkDeleteRepo(USERNAME ,repoName);
	}

}
