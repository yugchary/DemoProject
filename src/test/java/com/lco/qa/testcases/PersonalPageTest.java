package com.lco.qa.testcases;

import java.io.IOException;
import java.util.HashMap;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;



//import com.crm.qa.pages.HomePage;

import com.lco.qa.base.TestBase;
import com.lco.qa.pages.PersonalPage;
import com.lco.qa.pages.ProcessPage;
import com.lco.qa.pages.TemplatePage;
import com.lco.qa.util.Testutil;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class PersonalPageTest extends TestBase {

	//PersonalPage personalPage;
	ProcessPage processPage;
	ExtentTest extentTest;
	

	

	public PersonalPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		url = prop.getProperty("url");
		initialization();
		//personalPage = new PersonalPage();
		processPage = new ProcessPage();
	}

	@Test(enabled = false)
	public void personalPageTitleTest() {
		log.info("****************************** Starting personalPageTitleTest test cases execution *****************************************");
		extentTest = extent.startTest("loginPageTitleTest");
		String title = processPage.validateLoginPageTitle();
		Assert.assertEquals(title, "LifeCo Insurance Company");
		log.info("****************************** Ending personalPageTitleTest test cases execution *****************************************");
	}

	@Test
	public void loginTest() {
		extentTest = extent.startTest("loginPageTitleTest");
		processPage = processPage.SampleTest(prop.getProperty("username"), prop.getProperty("password"));
	}

	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException{
		
		if(result.getStatus()==ITestResult.FAILURE){
			extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS "+result.getName()); //to add name in extent report
			extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS "+result.getThrowable()); //to add error/exception in extent report
			
			String screenshotPath = Testutil.getScreenshot(driver, result.getName());
			extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath)); //to add screenshot in extent report
			//extentTest.log(LogStatus.FAIL, extentTest.addScreencast(screenshotPath)); //to add screencast/video in extent report
		}
		else if(result.getStatus()==ITestResult.SKIP){
			extentTest.log(LogStatus.SKIP, "Test Case SKIPPED IS " + result.getName());
		}
		else if(result.getStatus()==ITestResult.SUCCESS){
			extentTest.log(LogStatus.PASS, "Test Case PASSED IS " + result.getName());

		}
		
		
		extent.endTest(extentTest); //ending test and ends the current test and prepare to create html report
		//driver.quit();
	}

}
