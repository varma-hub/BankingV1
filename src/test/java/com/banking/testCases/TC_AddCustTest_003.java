package com.banking.testCases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.banking.pageObjects.AddCustomerPage;
import com.banking.pageObjects.LoginPage;

public class TC_AddCustTest_003 extends BaseClass
{
	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("User Name Provided");
		lp.setPassword(password);
		logger.info("Password Provided");
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		AddCustomerPage addCust = new AddCustomerPage(driver);
		addCust.clickNewCustomerLink();
		
		logger.info("Providing the customer details....");
		
		addCust.setCustomerName("Varma");
		addCust.selectCustGender("male");
		addCust.setCustomerDOB("09", "21", "2000");
		Thread.sleep(3000);
		addCust.setCustAddress("INDIA");
		addCust.setCustState("Telangana");
		addCust.setCustCity("Hyd");
		addCust.setCustPinno("500077");
		addCust.setCustTeleNo("90909009");
		String email = randomString()+ "@gmail.com";
		addCust.setCustEmail(email);
		addCust.setCustPwd("abcdefg");	
		addCust.clickSubmit();
		Thread.sleep(3000);
		
		logger.info("Validation Started....");
		
		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("Test Case Passed");
		}
		else
		{
			logger.info("Test Case Failed");
			captureScreen(driver, "addNewCustomer");
			Assert.assertTrue(false);
		}
	}
	
	//user defined random string
	public String randomString()
	{
		String genString = RandomStringUtils.randomAlphabetic(5);
		return genString;
	}
	
}
