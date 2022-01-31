package com.banking.utilities;

import java.io.File;
import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter
{
	public ExtentReports extent;
	public ExtentTest test;
	public ExtentSparkReporter spark;
	
	public void onStart(ITestContext textContext)
	{
		String timeStamp = new SimpleDateFormat("DD.MM.YYYY.hh.mm.ss").format(new Date());
		String repName = "Test-Report-"+timeStamp+".html";
		extent = new ExtentReports();
		spark = new ExtentSparkReporter(System.getProperty("user.dir") + "/Reports/" + repName);
		
		try {
			spark.loadXMLConfig(System.getProperty("user.dir") + "/extent-config.xml");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		extent.attachReporter(spark);
		
		extent.setSystemInfo("Host Name", "Loacl Host");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("User", "Varma");
	
		spark.config().setDocumentTitle("Internet Banking Project");
		spark.config().setReportName("Functional Test Report");
		spark.config().setTheme(Theme.DARK);
		}
	
	public void onTestSuccess(ITestResult tr)
	{
		test = extent.createTest(tr.getName()); 
		test.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
	}
	
	public void onTestFailure(ITestResult tr)
	{
		
		test = extent.createTest(tr.getName());
		test.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		
		String screenshotPath = System.getProperty("user.dir") +"/Screenshots/" + tr.getName() + ".png";

		File f = new File(screenshotPath);
		
		if(f.exists())
		{
		
			test.fail("Screenshot is bellow :" + test.addScreenCaptureFromPath(screenshotPath));
			
		} 
		
		/* WebDriver driver = null;
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String screenshotPath = System.getProperty("user.dir") +"/Screenshots/" + tr.getName() + ".png";
		File tgt = new File(screenshotPath);
		try {
			FileUtils.copyFile(src, tgt);
		} catch (IOException e) {
			e.printStackTrace();
		} */
	}
	
	public void onFinish(ITestContext testContext)
	{
		extent.flush();
	}
	
}
