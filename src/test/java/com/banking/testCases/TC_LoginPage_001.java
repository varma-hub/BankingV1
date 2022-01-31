package com.banking.testCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.banking.pageObjects.LoginPage;

public class TC_LoginPage_001 extends BaseClass{

	@Test
	public void loginTest() throws IOException {
		
		logger.info("URL Opend");
		
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Entered User Name");
		
		lp.setPassword(password);
		logger.info("Enter Password");
		
		lp.clickSubmit();
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("Login Test Passed");
		}
		else
		{
			captureScreen(driver, "loginTest");
			Assert.assertTrue(false);
			logger.info("Login Test Faild");
			}
			
		}
		
	}

