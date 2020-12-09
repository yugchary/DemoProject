package com.lco.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.lco.qa.util.Testutil;
import com.lco.qa.util.WebEventListener;
import com.lco.qa.util.Xlsutil;
import com.relevantcodes.extentreports.ExtentReports;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	public static Logger log = Logger.getLogger("TestAutomationLogger");
	public static ExtentReports extent = new ExtentReports(System.getProperty("user.dir")+"/test-output/LIC_TestExecutoinReport_Extent.html", true);
	public static Xlsutil xls = new Xlsutil(Testutil.TESTDATA_SHEET_PATH, "Quote1");
	public static String url = null;
	public static WebDriverWait wait;
	
	public TestBase(){
		
		prop = new Properties();
		try {
			//FileInputStream ip = new FileInputStream("C:\\Users\\akkyu01\\eclipse-workspace\\JavaTraining\\FreeCRMTests\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			//FileInputStream ip = new FileInputStream("C:\\Users\\akkyu01\\eclipse-workspace\\JavaTraining\\Sureify\\src\\main\\java\\com\\lco\\qa\\config\\config.properties");
			FileInputStream ip = new FileInputStream("/home/yugander/Downloads/git/ApplyandBuyAutomation/src/main/java/com/lco/qa/config/config.properties");
			//FileInputStream ip = new FileInputStream("/usr/share/tag/config/config.properties");
			
			//home/yugander/Downloads/git/ApplyandBuyAutomation/src/main/java/com/lco/qa/testdata/Input_Data.xlsx
			prop.load(ip);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void initialization() {
		
		String BrowserType = prop.getProperty("browserType");
		String BinariesLoc = prop.getProperty("binariesLocation");
		String remoteWD_url = prop.getProperty("remoteWD_url");	
		String host = System.getProperty("HUB_HOST");

		if (BrowserType.equalsIgnoreCase("CHROME")) {
			//System.setProperty("webdriver.chrome.driver","C:\\Yug\\From Old Laptop\\From LoanLap\\Yug\\Selenium\\chromedriver.exe");
			//System.setProperty("webdriver.chrome.driver",BinariesLoc+"chromedriver.exe");
			//System.setProperty("webdriver.chrome.driver",BinariesLoc+"chromedriver");
			driver = new ChromeDriver();
			DesiredCapabilities dc = DesiredCapabilities.chrome();
			
			/*
			 * ChromeOptions options = new ChromeOptions();  try { //driver = new ChromeOptions(options);
			 * //driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),
			 * options); //driver = new RemoteWebDriver(new
			 * URL("http://172.18.0.4:5555/wd/hub"), options); driver = new
			 * RemoteWebDriver(new URL(remoteWD_url), options);
			 * 
			 * 
			 * //driver = new RemoteWebDriver(new URL("http://" + host + ":4444/wd/hub"),
			 * options);
			 * 
			 * 
			 * } catch (MalformedURLException e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); }
			 */
	        
			
		} else if (BrowserType.equalsIgnoreCase("IE")) {

			//System.setProperty("webdriver.ie.driver","C:\\Yug\\From Old Laptop\\From LoanLap\\Yug\\Selenium\\IEDriverServer.exe");
			//System.setProperty("webdriver.ie.driver",BinariesLoc+"IEDriverServer.exe");	
			driver = new InternetExplorerDriver();
		} else if (BrowserType.equalsIgnoreCase("FF")) {

			//System.setProperty("webdriver.gecko.driver","C:\\Yug\\From Old Laptop\\From LoanLap\\Yug\\Selenium\\geckodriver.exe");
			//System.setProperty("webdriver.gecko.driver",BinariesLoc+"geckodriver.exe");
			//System.setProperty("webdriver.gecko.driver",BinariesLoc+"geckodriver");
			//driver = new FirefoxDriver();
			
			FirefoxOptions options = new FirefoxOptions();
			
			//options.setCapability("marionette", true);
			//driver = new FirefoxDriver(options);
			try {
				//driver = new RemoteWebDriver(new URL("http://172.18.0.4:5555/wd/hub"), options);
				//driver = new RemoteWebDriver(new URL("http://localhost:32770/wd/hub"), options);
				driver = new RemoteWebDriver(new URL(remoteWD_url), options);
				//driver = new RemoteWebDriver(new URL("http://" + host + ":4444/wd/hub"), options);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
		e_driver = new EventFiringWebDriver(driver);
		
		eventListener = new WebEventListener();
		
		e_driver.register(eventListener);
		driver = e_driver;
		
		driver.manage().deleteAllCookies();
		//driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Testutil.pageLoadTimeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Testutil.implicitlyWait, TimeUnit.SECONDS);
		
		//driver.get(prop.getProperty("url"));
		
		driver.get(url);
		
		wait = new WebDriverWait(driver, 60*(Testutil.waitTime/1000));
		
		
	}
	

}
