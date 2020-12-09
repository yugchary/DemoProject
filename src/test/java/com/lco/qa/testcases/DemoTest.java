package com.lco.qa.testcases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Properties;

import org.apache.commons.collections4.iterators.EntrySetMapIterator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

//import com.crm.qa.pages.HomePage;

import com.lco.qa.base.TestBase;
import com.lco.qa.pages.AgentWebHomePage;
import com.lco.qa.pages.AgentWebLoginPage;
import com.lco.qa.pages.DemoPage;
import com.lco.qa.pages.PersonalPage;
import com.lco.qa.util.ProductUtil;
import com.lco.qa.util.Testutil;
import com.lco.qa.util.Xlsutil;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class DemoTest extends TestBase {

	DemoPage demoPage;
	ExtentTest extentTest;
	PersonalPage personalPage;
	AgentWebLoginPage agentWebPage;
	AgentWebHomePage agentWebHomePage;
	

	HashMap<String, String> inputData = new HashMap<String, String>();

	public DemoTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		//url = prop.getProperty("url");
		//initialization();
		//demoPage = new DemoPage();
	}

	@DataProvider
	Object[][] getData() throws Exception {
		return Testutil.getTableArray(Testutil.TESTDATA_SHEET_PATH, "Questions", 2, 7, 2, 1);
	}

	@Test(enabled = true)
	public void loginPageTitleTest() {

		log.info(
				"****************************** Starting loginPageTitleTest test cases execution *****************************************");
		extentTest = extent.startTest("loginPageTitleTest");
		
		
		// set up new properties object
        // from file "myProperties.txt"
        FileInputStream propFile=null;
		try {
			propFile = new FileInputStream( "/home/yugander/Downloads/Downloads/Automation/myProperties.txt");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        Properties p =
            new Properties(System.getProperties());
        try {
			p.load(propFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        // set the system properties
        System.setProperties(p);
        // display new properties
        System.getProperties().list(System.out);
		
		
		 // Printing Name of the system property 
        System.out.println("user.dir: "+System.getProperty("user.dir")); 
  
        // Fetches the property set with 'home' key 
        System.out.println("hostname: "+System.getProperty("hostname")); 
        // Resulting in Null as no property is present 
  
        // Printing 'name of Operating System' 
        System.out.println("os.name: "+System.getProperty("os.name")); 
        
        // Printing 'os.arch' property 
        System.out.println("os.arch: "+System.getProperty("os.arch" )); 
  
        // Printing 'JAVA Runtime version' 
        System.out.println("version: "+System.getProperty("java.runtime.version" )); 
  
        // Printing 'name' property 
        System.out.println("seleniumHubHost: "+System.getProperty("seleniumHubHost" )); 
        // Resulting in Null as no property is present 
    
		
		
		
		       
		
		
		
		driver.findElement(By.id("email")).sendKeys("girish@sureify.com");
		driver.findElement(By.id("password")).sendKeys("Sureify@123");
		driver.findElement(By.id("btn_login")).click();
		//String title = demoPage.validateLoginPageTitle();
		//Assert.assertEquals(title, "OrangeHRM");
		log.info(
				"****************************** Ending loginPageTitleTest test cases execution *****************************************");
	}

	@Test(enabled = false)
	public void Test1() {
		
		
		
		extentTest = extent.startTest("Test1");
		
		String number = "10.0";
		int result = Integer.parseInt(number);			
		System.out.println(result);

		String input = "123456789"; // input string
		String lastFourDigits = ""; // substring containing last 4 characters

		int len = input.length();
		if (input.length() > 4) {
			lastFourDigits = input.substring(len - 1);

		} else {
			lastFourDigits = input;
		}

		input = input.substring(0, input.length() - 1);

		System.out.println(input);

	}

	@Test(dataProvider = "getData", enabled = false)
	public void Test2(String Question, String FieldType, String FieldValue) {

		extentTest = extent.startTest("Test2");
		inputData.put(Question, FieldType + "_" + FieldValue);

	}

	public void Test4() {

		Object[][] x = null;
		try {
			x = Testutil.getTableArray(Testutil.TESTDATA_SHEET_PATH, "Questions", 2, 7, 2, 1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String line = null;

		// Object data;

		for (Object[] innerArray : x) {
			StringBuilder sb = new StringBuilder();
			for (Object data : innerArray)
				sb.append(data).append("_");

			// System.out.println(sb);

			line = sb.toString();
			String[] arrOfStr = line.split("_", 2);

			for (String a : arrOfStr) {
				int len = arrOfStr[1].length();
				String str = arrOfStr[1].substring(0, len - 1);
				// returnText = arrOfStr[1].substring(len -1);
				inputData.put(arrOfStr[0], str);

			}

			// System.out.println("read line");
		}
	}

	@Test(enabled = false)
	public DemoPage Test3() {

		extentTest = extent.startTest("Test3");
		int rowNum=2;
		
		String currentURL ="";
		currentURL = driver.getCurrentUrl(); 
		
		
		
		try{
			
			
			
			Testutil.updateResult(Testutil.resultSheet, "URL", rowNum, currentURL);	
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
			System.out.println("other exception, Quote failed");
			Testutil.updateResult(Testutil.resultSheet, "Quote", rowNum, "Fail");
			Testutil.updateResult(Testutil.resultSheet, "URL", rowNum, currentURL);
			return null; 
			
		}
		
		String str1 = null;
		String str2 = "hello";              

		// Success.
		Assert.assertNotNull(str2);

		// Fail.
		Assert.assertNotNull(str1);
		
	
		Testutil.loginGmail();
		Testutil.openVeryFirstEmail();
		
		Testutil.findElements(By.xpath("//a[contains(text(),'REVIEW AND SIGN')]"));
		//driver.findElement(By.xpath("//a[contains(text(),'REVIEW AND SIGN')]")).click();
		String winHandleBefore = driver.getWindowHandle();
		
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}
		
		System.out.println("switching the handle");
		
		WebDriverWait wait = new WebDriverWait(driver, 10*Testutil.waitTime);
		
		String label = "Thank you! Your application has been submitted, we will be in touch with you shortly";
		
		By by = new By.ByXPath("//*[contains(text(), 'Thank you! Your application has been submitted, we will be in touch with you shortly.')]");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		
		
		Assert.assertNotNull(driver.findElement(by));
	    String yourButtonName=driver.findElement(by).getAttribute("innerText");
	    Assert.assertTrue(yourButtonName.equalsIgnoreCase("Thank you! Your application has been submitted, we will be in touch with you shortly."));
	    
	    
	    driver.close();

	  		// Switch back to original browser (first window)
	  	driver.switchTo().window(winHandleBefore);
	  		
	  	driver.close();
	  	
	  	agentWebHomePage.newAgentQuote();
	  	
	  	//driver.switchTo().window(winHandleBefore1);
	  	
	  	
	  	
	  	
	  	url = prop.getProperty("agent_url");
		initialization();
		agentWebPage = new AgentWebLoginPage();
		agentWebHomePage = new AgentWebHomePage();
	  	
		
	  	agentWebHomePage = agentWebPage.agentWebLogin(prop.getProperty("username"), prop.getProperty("password"));
		
		String winHandleBefore1 = driver.getWindowHandle();
	  	
	  	
		
		
		personalPage = new PersonalPage();
		
		personalPage.signDoc(2, "Application PDF");

		// Perform the actions on new window

		// Close the new window, if that window no more required
		//driver.close();

		// Switch back to original browser (first window)
		//driver.switchTo().window(winHandleBefore);
		
		driver.close();
		
		int x = 1;
		int y =1;
		
		if(x!=y) System.out.println("not equal");
		else
			System.out.println("equal");
		
		
		//List<WebElement> childs = rootWebElement.findElements(By.xpath(".//*"));
		
		
		By elementsCount = By.cssSelector(".questions-container.c-center.row> div");
		
		List<WebElement> listWebElementLabel = driver.findElements(elementsCount);
		
		HashMap<String, Integer> ele = new HashMap<String, Integer>();

		System.out.println("found webelements: " + listWebElementLabel.size());
		
		Iterator<WebElement> l;
		
		l = listWebElementLabel.iterator();
		
		//
		
		int i =0;
		String fieldType = null, className = null;
		By byElements = null;

		while(l.hasNext()){
			
		}
		
		String number = "10.0";
		int len = number.length();
		
		if (number.contains("."))
			number = number.substring(0,len-2);
		
		//int result = Integer.parseInt(number);			
		System.out.println(number);

		Test4();
		
		//String value = Testutil.getFromHashMap(inputData, "Please enter the medical condition(s) that prevents you from working?");
		
		String value = Testutil.getFromHashMap(inputData, "State");
		
		
		boolean flag1 = Testutil.isNullOrEmpty(value);
		boolean flag = false;
		
		if(!flag1) 
			flag = Testutil.getOccuringChar(value, '_');

		
		//boolean flag = Testutil.getOccuringChar(value, '_');
		//value.is
		
		//value == "" || value.contentEquals("_") || isNullOrEmpty(value
		
		if ( value == "") {
			
			System.out.println(value);
		}else{}
		
		String inputValues[] = value.split("_");
				//System.out.println(Testutil.getFromHashMap(inputData, "First Name"));
		
		System.out.println(inputValues[0] +"and"+ inputValues[1]);
		/*for (Entry data : inputData.entrySet()) {

			String line = data.getKey() + " " + data.getValue();
			System.out.println(line);

		}*/
		
		return demoPage;
	}
	
	public static boolean isNullOrEmpty(String str) {
        if(str != null && !str.isEmpty())
            return false;
        return true;
    }

	@Test(enabled = false)
	public void Test() throws ParseException {
		// demoPage = demoPage.SampleTest(prop.getProperty("username"),
		// prop.getProperty("password"));

		extentTest = extent.startTest("Test");

		int arr[] = { 1, 2, 3, 4, 5 };
		int r = 3;
		int n = arr.length;

		for (int i = 1; i <= n; i++)
			printCombination(arr, n, i);

		HashMap<Integer, String> ec = ProductList();

		for (int i = 0; i < ec.size(); i++) // returns null
			System.out.println(ec.get(i));

	}

	static HashMap<Integer, String> ProductList() {

		HashMap<Integer, String> ec = new HashMap<Integer, String>();

		ec.put(1, "OK");
		ec.put(2, "authentication error");
		ec.put(3, "service no found");
		ec.put(4, "Not found");

		return ec;
	}

	/*
	 * arr[] ---> Input Array data[] ---> Temporary array to store current
	 * combination start & end ---> Staring and Ending indexes in arr[] index
	 * ---> Current index in data[] r ---> Size of a combination to be printed
	 */
	static void combinationUtil(int arr[], int data[], int start, int end, int index, int r) {
		// Current combination is ready to be printed, print it
		if (index == r) {
			for (int j = 0; j < r; j++)
				System.out.print(data[j] + " ");
			System.out.println("");
			return;
		}

		// replace index with all possible elements. The condition
		// "end-i+1 >= r-index" makes sure that including one element
		// at index will make a combination with remaining elements
		// at remaining positions
		for (int i = start; i <= end && end - i + 1 >= r - index; i++) {
			data[index] = arr[i];
			combinationUtil(arr, data, i + 1, end, index + 1, r);
		}
	}

	// The main function that prints all combinations of size r
	// in arr[] of size n. This function mainly uses combinationUtil()
	static void printCombination(int arr[], int n, int r) {
		// A temporary array to store all combination one by one
		int data[] = new int[r];

		// Print all combination using temprary array 'data[]'
		combinationUtil(arr, data, 0, n - 1, 0, r);
	}

	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {

		if (result.getStatus() == ITestResult.FAILURE) {
			extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS " + result.getName()); // to
																						// add
																						// name
																						// in
																						// extent
																						// report
			extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS " + result.getThrowable()); // to
																							// add
																							// error/exception
																							// in
																							// extent
																							// report

			String screenshotPath = Testutil.getScreenshot(driver, result.getName());
			extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath)); // to
																							// add
																							// screenshot
																							// in
																							// extent
																							// report
			// extentTest.log(LogStatus.FAIL,
			// extentTest.addScreencast(screenshotPath)); //to add
			// screencast/video in extent report
		} else if (result.getStatus() == ITestResult.SKIP) {
			extentTest.log(LogStatus.SKIP, "Test Case SKIPPED IS " + result.getName());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			extentTest.log(LogStatus.PASS, "Test Case PASSED IS " + result.getName());

		}

		extent.endTest(extentTest); // ending test and ends the current test and
									// prepare to create html report
		//driver.quit();
	}

}
