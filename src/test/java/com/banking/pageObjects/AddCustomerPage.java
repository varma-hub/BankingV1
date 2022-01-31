package com.banking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
	
	WebDriver ldriver;
	
	public AddCustomerPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(how = How.XPATH, using="/html/body/div[3]/div/ul/li[2]/a")
	@CacheLookup
	WebElement lnkAddNewCustomer;
	
	@FindBy(how = How.NAME, using="name")
	@CacheLookup
	WebElement txtCutomerName;
	
	@FindBy(how = How.NAME, using="rad1")
	@CacheLookup
	WebElement rdGender;
	
	@FindBy(how = How.ID_OR_NAME, using="dob")
	@CacheLookup
	WebElement txtdob;
	
	@FindBy(how = How.NAME, using="addr")
	@CacheLookup
	WebElement txtaddress;
	
	@FindBy(how = How.NAME, using="city")
	@CacheLookup
	WebElement txtcity;
	
	@FindBy(how = How.NAME, using="state")
	@CacheLookup
	WebElement txtstate;
	
	@FindBy(how = How.NAME, using="pinno")
	@CacheLookup
	WebElement txtpinno;
	
	@FindBy(how = How.NAME, using="telephoneno")
	@CacheLookup
	WebElement txttelephoneno;
	
	@FindBy(how = How.NAME, using="emailid")
	@CacheLookup
	WebElement txtemailid;
	
	@FindBy(how = How.NAME, using="password")
	@CacheLookup
	WebElement txtpassword;
	
	@FindBy(how = How.NAME, using="sub")
	@CacheLookup
	WebElement btnsubmit;
	
	
	public void clickNewCustomerLink()
	{
		lnkAddNewCustomer.click();
	}
	
	public void setCustomerName(String cname) 
	{
		txtCutomerName.sendKeys(cname);;
	}
	
	public void selectCustGender(String cgender) 
	{
		rdGender.click();
	}
	
	public void setCustomerDOB(String mm, String dd, String yyyy) 
	{
		txtdob.sendKeys(mm);
		txtdob.sendKeys(dd);
		txtdob.sendKeys(yyyy);
	}
	
	public void setCustAddress(String caddress) 
	{
		txtaddress.sendKeys(caddress);
	}
	
	public void setCustCity(String ccity) 
	{
		txtcity.sendKeys(ccity);
	}
	
	public void setCustState(String cstate) 
	{
		txtstate.sendKeys(cstate);
	}
	
	public void setCustPinno(String cpinno) 
	{
		txtpinno.sendKeys(String.valueOf(cpinno));
	}
	
	public void setCustTeleNo(String cteleno) 
	{
		txttelephoneno.sendKeys(cteleno);
	}
	
	public void setCustEmail(String cemail) 
	{
		txtemailid.sendKeys(cemail);
	}
	
	public void setCustPwd(String cpwd) 
	{
		txtpassword.sendKeys(cpwd);
	}
	
	public void clickSubmit() 
	{
		btnsubmit.click();
	}
	
}
