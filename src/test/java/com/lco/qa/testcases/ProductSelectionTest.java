package com.lco.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



//import com.crm.qa.pages.HomePage;

import com.lco.qa.base.TestBase;
import com.lco.qa.pages.OnePersonGatherInfoPage;
import com.lco.qa.pages.ProductSelectionPage;

import com.lco.qa.util.Testutil;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ProductSelectionTest extends TestBase {

	ProductSelectionPage productSelectionPage;
	OnePersonGatherInfoPage onePersonGatherInfoPage;
	ExtentTest extentTest;

	//ExtentReports extent = new ExtentReports(System.getProperty("user.dir")+"/test-output/ExtentReport.html", true);

	public ProductSelectionTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		url = prop.getProperty("url");
		initialization();
		productSelectionPage = new ProductSelectionPage();
		onePersonGatherInfoPage = new OnePersonGatherInfoPage();
		
	}
	
	@DataProvider
	Object[][] getData() throws Exception {
		return Testutil.getTableArray(Testutil.TESTDATA_SHEET_PATH,"Quote1", 2, 7, 2, 1);
	}

	@Test(enabled = false)
	public void ProductSelectionPageTitleTest() {	
		log.info("****************************** Starting ProductSelectionPageTitleTest test cases execution *****************************************");
		extentTest = extent.startTest("ProductSelectionPageTitleTest");		
		String title = productSelectionPage.validateProductSelectionPageTitle();
		Assert.assertEquals(title, "LifeCo Insurance Company");
		log.info("****************************** Ending ProductSelectionPageTitleTest test cases execution *****************************************");
	}

	@Test(dataProvider = "getData", enabled = false)
	public void validateOnePersonQuoteInfoTest(String FirstName, String DateOfBirth, String Gender, String State, String tobaccoUse, String healthRate, String stateCode) {
		
	
		log.info("****************************** Starting validateOnePersonQuoteInfo test cases execution *****************************************");
		extentTest = extent.startTest("validateOnePersonQuoteInfo");
		DateOfBirth = DateOfBirth.replace(".", "/");
		productSelectionPage = onePersonGatherInfoPage.Quote(2, FirstName, DateOfBirth, Gender, State, tobaccoUse, healthRate);
		productSelectionPage = productSelectionPage.GetPersonInfo(FirstName, DateOfBirth, Gender, State, tobaccoUse, healthRate, stateCode);
		log.info("****************************** Ending validateOnePersonQuoteInfo test cases execution *****************************************");
	}
	
	@Test(dataProvider = "getData", enabled = true)
	public void selectProduct(String FirstName, String DateOfBirth, String Gender, String State, String tobaccoUse, String healthRate, String stateCode) {
		log.info("****************************** Starting selectProduct test cases execution *****************************************");
		extentTest = extent.startTest("selectProduct");
		DateOfBirth = DateOfBirth.replace(".", "/");
		productSelectionPage = onePersonGatherInfoPage.Quote(2, FirstName, DateOfBirth, Gender, State, tobaccoUse, healthRate);
		
		productSelectionPage = productSelectionPage.ProductSelection();
		log.info("****************************** Ending selectProduct test cases execution *****************************************");
	}
	
	@Test(enabled = false)
	public void FinalizeProduct() {		
		
		log.info("****************************** Starting FinalizeProduct test cases execution *****************************************");
		extentTest = extent.startTest("FinalizeProduct");
		productSelectionPage.ProductSelection();
		productSelectionPage.FinalizeProductSelection();
		log.info("****************************** Ending FinalizeProduct test cases execution *****************************************");
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
		driver.quit();
	}

}
