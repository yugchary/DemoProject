package com.lco.qa.testcases;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



//import com.crm.qa.pages.HomePage;

import com.lco.qa.base.TestBase;
import com.lco.qa.pages.ActionPage;
import com.lco.qa.pages.AgentWebHomePage;
import com.lco.qa.pages.AgentWebLoginPage;
import com.lco.qa.pages.BeneficiariesPage;
import com.lco.qa.pages.OnePersonGatherInfoPage;
import com.lco.qa.pages.PaymentPage;
import com.lco.qa.pages.PersonalPage;
import com.lco.qa.pages.ProcessPage;
import com.lco.qa.pages.ProductSelectionPage;
import com.lco.qa.pages.SignaturePage;
import com.lco.qa.pages.TemplatePage;
import com.lco.qa.util.Testutil;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class AgentWebHomeTest extends TestBase {

	AgentWebHomePage agentWebHomePage;
	AgentWebLoginPage agentWebPage;
	ProductSelectionPage productSelectionPage;
	OnePersonGatherInfoPage onePersonGatherInfoPage;
	
	ActionPage actionPage;
	ExtentTest extentTest;	
	///PersonalPage personalPage; 
	ProcessPage processPage;
	SignaturePage signaturePage;
	BeneficiariesPage beneficiariesPage;
	PaymentPage paymentPage;
	int rowNum =2;
	
	

	public AgentWebHomeTest() {
		super();
	}
	
	

	@BeforeMethod
	public void setup() {
		url = prop.getProperty("agent_url");
		initialization();
		agentWebHomePage = new AgentWebHomePage();
		agentWebPage = new AgentWebLoginPage();
		productSelectionPage = new ProductSelectionPage();
		onePersonGatherInfoPage = new OnePersonGatherInfoPage();
		//personalPage = new PersonalPage();
		
		processPage = new ProcessPage();
		beneficiariesPage = new BeneficiariesPage();
		signaturePage = new SignaturePage();
		paymentPage = new PaymentPage();
		
		actionPage = new ActionPage();
		
		
	}
	
	@DataProvider
	Object[][] getData() throws Exception {
		return Testutil.getTableArray(Testutil.TESTDATA_SHEET_PATH,"Quote", 3, 12, 3, 1);
	}

	@Test(enabled = false)
	public void loginPageTitleTest() {
		log.info("****************************** Starting loginPageTitleTest test cases execution *****************************************");
		extentTest = extent.startTest("loginPageTitleTest");
		String title = agentWebHomePage.validateLoginPageTitle();
		Assert.assertEquals(title, "LifeCo Insurance Company");
		log.info("****************************** Ending loginPageTitleTest test cases execution *****************************************");
	}
	
	

	public void validateQuotationsnEApplications() {
		log.info("****************************** Starting loginPageTitleTest test cases execution *****************************************");
		extentTest = extent.startTest("loginPageTitleTest");

		setup();
		agentWebPage.agentWebLogin(prop.getProperty("username"), prop.getProperty("password"));
		agentWebHomePage.QuotationsnEApplications();
		String title = agentWebHomePage.validateLoginPageTitle();
		Assert.assertEquals(title, "Vantis Life Insurance Company");
		log.info("****************************** Ending loginPageTitleTest test cases execution *****************************************");
	}

	@Test(dataProvider = "getData", enabled = true)
	public void agentQuote(String Num, String FirstName, String DateOfBirth, String Gender, String State, String tobaccoUse, String healthRate, String distribution, String product, String requestType, String signType, String paymentMethod) {
		log.info("****************************** Starting agentQuote test cases execution *****************************************");
		extentTest = extent.startTest("agentQuote");
		agentWebPage.agentWebLogin(prop.getProperty("username"), prop.getProperty("password"));
		agentWebHomePage.newAgentQuote();
		//agentWebHomePage.close();
		
		DateOfBirth = DateOfBirth.replace(".", "/");
		productSelectionPage = onePersonGatherInfoPage.Quote(rowNum, FirstName, DateOfBirth, Gender, State, tobaccoUse, healthRate);
		
		Assert.assertNotNull(productSelectionPage);
		
		
		
		
		productSelectionPage.ProductSelection();
		
		Assert.assertNotNull(productSelectionPage);
		
		System.out.println("product selected");
		
		productSelectionPage.FinalizeProductSelection();	
		System.out.println("selected quote");
		
		Assert.assertNotNull(productSelectionPage);
		
		actionPage.selectAction(requestType, Testutil.email_ID);
		
		Assert.assertNotNull(actionPage);
		
		Testutil.updateResult(Testutil.resultSheet, "Quote", rowNum, "Pass");
		
		String count = prop.getProperty("iterator");		
		int itrCount = Integer.parseInt(count);
		String currentURL ="";
		currentURL = driver.getCurrentUrl(); 
		boolean testFlag = true;
		
		
		try{
			processPage.ProcessFields(rowNum, distribution.toLowerCase(), itrCount, distribution, signType, paymentMethod);
		
			Testutil.updateResult(Testutil.resultSheet, "URL", rowNum, currentURL);	
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
			System.out.println("other exception, ProcessFields failed");
			
			Testutil.updateResult(Testutil.resultSheet, "URL", rowNum, currentURL);
			testFlag = false;
			
			
		}
		Testutil.staticLongWait();
		
		if(testFlag){
		paymentPage.makePayment(rowNum, paymentMethod);
		Testutil.updateResult(Testutil.resultSheet, "Payment Gateway", rowNum, "Pass");
		
		}
	
		
		
		log.info("****************************** Ending agentQuote test cases execution *****************************************");
		rowNum++;
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
