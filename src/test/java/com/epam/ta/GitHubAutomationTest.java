package com.epam.ta;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.epam.ta.steps.Steps;

public class GitHubAutomationTest
{
	private Steps steps;
	private final String USERNAME = "testautomationuser";
	private final String PASSWORD = "Time4Death!";
	private final int REPOSITORY_NAME_POSTFIX_LENGTH = 6;
	private final String newFileName = "testFile";

	@BeforeMethod(description = "Init browser")
	public void setUp()
	{
		steps = new Steps();
		steps.openBrowser();
	}

	@Test(priority = 2)
	public void oneCanCreateProject()
	{
		steps.loginGithub(USERNAME, PASSWORD);
		String repositoryName = steps.generateRandomRepositoryNameWithCharLength(REPOSITORY_NAME_POSTFIX_LENGTH);
		steps.createNewRepository(repositoryName, "auto-generated test repo");
		Assert.assertEquals(steps.getCurrentRepositoryName(), repositoryName);
	}

	@Test(description = "Login to Github", priority = 1)
	public void oneCanLoginGithub()
	{
		steps.loginGithub(USERNAME, PASSWORD);
		Assert.assertEquals(USERNAME, steps.getLoggedInUserName());
	}

	@Test(description = "Add file to repository", priority = 3)
	public void addFileToRepo(){
		steps.loginGithub(USERNAME, PASSWORD);
		String repositoryName = steps.generateRandomRepositoryNameWithCharLength(REPOSITORY_NAME_POSTFIX_LENGTH);
		steps.createNewRepository(repositoryName, "auto-generated test repo");
		Assert.assertEquals(steps.getCurrentRepositoryName(), repositoryName);
		steps.createNewFile(newFileName);
		Assert.assertEquals(steps.getCurrentFileName(), newFileName);
	}

	@Test(description = "Delete file from repository", priority = 4)
	public void deleteFile(){
		steps.loginGithub(USERNAME, PASSWORD);
		String repositoryName = steps.generateRandomRepositoryNameWithCharLength(REPOSITORY_NAME_POSTFIX_LENGTH);
		steps.createNewRepository(repositoryName, "auto-generated test repo");
		Assert.assertEquals(steps.getCurrentRepositoryName(), repositoryName);
		steps.createNewFile(newFileName);
		Assert.assertEquals(steps.getCurrentFileName(), newFileName);
		steps.deleteFile();
		Assert.assertEquals(steps.getMessDel(), "Delete testFile");
	}

	@Test(description = "Delete repository", priority = 5)
	public void deleteRepo()
	{
		steps.loginGithub(USERNAME, PASSWORD);
		String repositoryName = steps.generateRandomRepositoryNameWithCharLength(REPOSITORY_NAME_POSTFIX_LENGTH);
		steps.createNewRepository(repositoryName, "auto-generated test repo");
		Assert.assertEquals(steps.getCurrentRepositoryName(), repositoryName);
		steps.deleteRepo();
		Assert.assertTrue(steps.checkDeleteRepo(USERNAME, repositoryName));
	}

	@AfterMethod(description = "Stop Browser")
	public void stopBrowser()
	{
		steps.closeBrowser();
	}
}
