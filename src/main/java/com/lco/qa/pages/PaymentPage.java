package com.lco.qa.pages;



import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.lco.qa.base.TestBase;
//import com.lco.qa.testcases.AgentWebHomeTest;
import com.lco.qa.util.ProductUtil;
import com.lco.qa.util.Testutil;

public class PaymentPage extends TestBase {

	
	AgentWebHomePage agentWebHomePage;
	AgentWebLoginPage agentWebPage;
	ProcessPage processPage;
	PaymentPage paymentPage;
	SignaturePage signaturePage;
	///AgentWebHomeTest agentWebHomeTest;
	// Page Factory - OR
	@FindBy(xpath = "")
	WebElement xyz;

	@FindBy(css = ".test")
	WebElement test;

	@FindBy(css = ".Select-placeholder")
	WebElement dropdown;

	// @FindBy(xpath = "//div[@id='react-select-.*--option-0']")
	// WebElement selectItem;

	@FindBy(css = ".Select-option")
	// @FindBy(xpath="//div[@class='Select-option is-focused']")
	// #react-select-2--option-0
	WebElement selectItem;

	@FindBy(css = ".autosuggest-input-choice")
	WebElement autoSugg;

	@FindBy(css = ".pseudofocused")
	WebElement selectAutoSugg;

	@FindBy(xpath = "//input[@placeholder='MM/DD/YYYY']")
	WebElement DOB;

	@FindBy(xpath = "//div[@class='react-datepicker__week']//div[@aria-label='day-12']")
	WebElement dateSelect;

	@FindBy(xpath = "//div[contains(text(),'State')]//following-sibling::*//span[@class='Select-multi-value-wrapper']//input")
	WebElement stateValue;

	@FindBy(xpath = "//div[contains(text(),'Customer Signature Type')]//following-sibling::*//span[@class='Select-multi-value-wrapper']//input")
	WebElement signatureType;
	
	@FindBy(xpath = "//div[starts-with(text(),'Will')]//following-sibling::*//span[@class='Select-multi-value-wrapper']//input")
	WebElement paymentType;
	
	@FindBy(css = ".Select-option.is-focused")
	WebElement selectItem1;

	@FindBy(xpath = "//div[@class='c-submit-person-info-btn c-center']//button[1]")
	// @FindBy(xpath="//div[@class='c-submit-person-info-bftn
	// c-center']//button[@class='c-button-default.visible.btn-default']")
	// button[@class='c-button-default circular hidden-xs active btn
	// btn-default']
	WebElement nextBtn;

	@FindBy(css = ".single-select-btn-container .c-button-default")
	WebElement yesButton;

	// @FindBy(xpath = "//button[@class='c-button-default circular
	// single-select-btn btn btn-default' and button[contains(text(),'No']")
	@FindBy(xpath = "//button[contains(text(),'No')]")

	WebElement noButton;

	HashMap<String, String> inputData = new HashMap<String, String>();

	// Initialize the Page objects
	public PaymentPage() {
		PageFactory.initElements(driver, this);
		signaturePage = new SignaturePage();		
		processPage = new ProcessPage();
		//agentWebHomeTest = new AgentWebHomeTest();

	}

	// Actions:

	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	public PaymentPage SampleTest(String un, String pwd) {

		String url = "https://vantislifeinsurancestg.sureify.com/questions?user=bmtwR3Y3VnZadE5NLy83SkkxbG1vQT09&text_accepted=No&vdtca&transaction_id=13a55130-324e-11e9-aff3-8fff83072c1a_1550364652995&ipAddress=192.168.1.110&timezoneOffset=-330&timezoneFormatted=GMT%200530%20(India%20Standard%20Time)&currentTime=1550364678937&q_id=d3B1RlpsUUpMNkdYY2Y0MStFQ1Nydz09&transaction_id=13a55130-324e-11e9-aff3-8fff83072c1a_1550364652995&auth_code=Lq5nLFCGGzXq6dOb1ZkTO7vx1Wc4lM";

		url = "https://vantislifeinsurancestg.sureify.com/questions?user=bDRkUUIzcmVZLzBUN2ltUDQ5MFBNUT09&text_accepted=No&vdtca&transaction_id=afddca30-6cb1-11e9-a36a-eb24c8a5a1e0_1556784602707&ipAddress=192.168.128.52&timezoneOffset=-330&timezoneFormatted=GMT%200530%20(India%20Standard%20Time)&currentTime=1556784627115&q_id=MGNrVVh3azB3Z0d6dllBTXJDRXJoUT09&transaction_id=afddca30-6cb1-11e9-a36a-eb24c8a5a1e0_1556784602707&auth_code=JSKTMTD0OT9SH0yYCY6tq7214ockmC";

		//url = "https://demo.docusign.net/Signing/?insession=1&ti=d901d7b23d724d5eb5d5234f98e42af5";
		
		int rowNum=2;
		
		
		
		driver.navigate().to(url);
		

		// FindElements();

		// for(int i=0;i<5; i++)
		
		//Testutil.selectFromDropdown("Alaska");
		
		//Testutil.selectFromDropdown(1);
		
				
		String count = prop.getProperty("iterator");
		
		int itrCount = Integer.parseInt(count);
		agentWebHomePage = new AgentWebHomePage();
		agentWebPage = new AgentWebLoginPage();
		
		
		
		//processPage.ProcessFields("self", itrCount, "DTC");
		//processPage.ProcessFields("agent", itrCount, "Agent", "Email E Signature", "eft");
		//processPage.ProcessFields("customer", itrCount, "Customer", "In Person E Signature", "cc");
		
		processPage.ProcessFields(2, "customer", itrCount, "Customer", "In Person E Signature", "cc");
		
		//payment("cc");
		
		
		//agentWebPage.agentWebLogin(prop.getProperty("username"), prop.getProperty("password"));
		//url = driver.getCurrentUrl(); 
		
		//signUp("agent","Email E Signature", "eft");
		
		//signaturePage.signTypeFlow(rowNum,"Email E Signature", "eft");
		//driver.close();
		//flowType("Email E Signature","eft");
		//agentWebHomeTest.validateQuotationsnEApplications();
		
		makePayment(rowNum, "eft");

		return new PaymentPage();

	}

	
	
	
	public boolean paymentTypeFlow(int rowNum, String payType){
		
		boolean returnFlag = false;
		
		String currentURL ="";
		currentURL = driver.getCurrentUrl();
		
		try{
		
			Testutil.staticWait();
			System.out.println("clicked START COVERAGE");
				
			ProductUtil.clickButton("START COVERAGE");
			ProductUtil.CheckElementDoNotExists(".fa.fa-circle-o-notch", true);
			
			switch (payType) {
	
			case "cc":			
				
				ProductUtil.selectDropdown("Will you pay", "credit card");
				
				
				ProductUtil.clickButton("Next");
				ProductUtil.CheckElementDoNotExists(".fa.fa-circle-o-notch", true);
				
				
				ProductUtil.selectDropdown("Withdrawl Date", "5th of the month");
				
				
				ProductUtil.inputText("Credit Card", "yug");
				
				ProductUtil.clickButton("Next");
				ProductUtil.CheckElementDoNotExists(".fa.fa-circle-o-notch", true);
				
				ProductUtil.inputCCDetails("Credit Card", "2223000048400011");
				ProductUtil.inputCCDetails("Expiration Date(MMYY)", "0121");
				ProductUtil.inputCCDetails("CVV2", "123");
				
				ProductUtil.clickButton(By.xpath("//input[@name='process']"));		
				
				
				
				returnFlag = true;
				break;
			
			case "eft":
				
				
				
				ProductUtil.selectDropdown("Will you pay", "electronic fund transfer");
				
				ProductUtil.clickButton("Next");
				ProductUtil.CheckElementDoNotExists(".fa.fa-circle-o-notch", true);
				
				
				ProductUtil.inputCCDetails("Account Holder Name:", "Yug");
				ProductUtil.inputCCDetails("Bank Name:", "HDFC");
				ProductUtil.clickButton("Savings");
				ProductUtil.inputCCDetails("Transit Routing Number", "111");
				ProductUtil.inputCCDetails("Bank Account Number", "1234");
				ProductUtil.selectDropdown("Withdrawl Date", "5th of the month");
				
				ProductUtil.clickButton("Next");
				ProductUtil.CheckElementDoNotExists(".fa.fa-circle-o-notch", true);
				
				
				
			default:
				break;
				
			}
			//Testutil.updateResult(Testutil.resultSheet, "URL", rowNum, currentURL);	
			return returnFlag;
			
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
			System.out.println("other exception, Payment Gateway failed");
			Testutil.updateResult(Testutil.resultSheet, "Payment Gateway", rowNum, "Fail");
			Testutil.updateResult(Testutil.resultSheet, "URL", rowNum, currentURL);
			return false; 
			
		}
		
	}

    
    public boolean makePayment(int rowNum, String paymentType) {
    	
    	String currentURL ="";		
		
    	//agentWebHomeTest = new AgentWebHomeTest();
    	signaturePage = new SignaturePage();	
    	boolean returnFlag = false;
		
		try{
    	
	    	
			agentWebHomePage.validateQuotationsnEApplications();
	
			driver.findElement(By.xpath("//a[contains(text(),'Make payment')]")).click();
			Testutil.staticLongWait();
	
			paymentTypeFlow(rowNum, paymentType);
			Testutil.staticLongWait();
			driver.quit();
			signaturePage.EmailSign(rowNum, "SIGN PAYMENT FORM", "Thank you! Your application has been submitted, we will be in touch with you shortly.", "Customer Payment form signature");
			agentWebHomePage.validateQuotationsnEApplications();
			/*ProductUtil.clickButton("Continue to Customer Signature");
			Testutil.staticLongWait();
			signaturePage.signDoc();
			Testutil.staticLongWait();*/
	
			driver.findElement(By.xpath("//a[contains(text(),'Sign TIA')]")).click();
			Testutil.staticLongWait();
			signaturePage.signDoc(rowNum, "Agent Payment form signature");
			Testutil.staticLongWait();
	
			returnFlag = true;
			//Testutil.updateResult(Testutil.resultSheet, "URL", rowNum, currentURL);	
			return returnFlag;
		
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
			currentURL = driver.getCurrentUrl(); 
			System.out.println("other exception, Payment Questions failed");
			Testutil.updateResult(Testutil.resultSheet, "Payment Questions", rowNum, "Fail");
			Testutil.updateResult(Testutil.resultSheet, "URL", rowNum, currentURL);
			return false; 
			
		}
	}
            
    
}



