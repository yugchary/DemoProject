package com.lco.qa.testcases;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;



//import com.crm.qa.pages.HomePage;

import com.lco.qa.base.TestBase;
import com.lco.qa.pages.AgentWebLoginPage;
import com.lco.qa.pages.TemplatePage;
import com.lco.qa.util.Testutil;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class AgentWebLoginTest extends TestBase {

	AgentWebLoginPage agentWebPage;
	ExtentTest extentTest;

	

	public AgentWebLoginTest() {
		super();
	}
	
	

	@BeforeMethod
	public void setup() {
		url = prop.getProperty("agent_url");
		initialization();
		agentWebPage = new AgentWebLoginPage();
	}

	@Test(enabled = false)
	public void loginPageTitleTest() {
		log.info("****************************** Starting loginPageTitleTest test cases execution *****************************************");
		extentTest = extent.startTest("loginPageTitleTest");
		String title = agentWebPage.validateLoginPageTitle();
		Assert.assertEquals(title, "LifeCo Insurance Company");
		log.info("****************************** Ending loginPageTitleTest test cases execution *****************************************");
	}

	@Test
	public void loginTest() {
		//agentWebPage = agentWebPage.agentWebLogin(prop.getProperty("username"), prop.getProperty("password"));
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
