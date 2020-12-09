package com.lco.qa.pages;



import java.util.HashMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.lco.qa.base.TestBase;




import com.lco.qa.util.ProductUtil;
import com.lco.qa.util.Testutil;

public class BeneficiariesPage extends TestBase {

	
	AgentWebHomePage agentWebHomePage;
	AgentWebLoginPage agentWebPage;
	ProcessPage processPage;
	PaymentPage paymentPage;
	SignaturePage signaturePage;
	//AgentWebLoginTest agentWebHomeTest;
	
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
	public BeneficiariesPage() {
		PageFactory.initElements(driver, this);
		signaturePage = new SignaturePage();
		paymentPage = new PaymentPage();
		processPage = new ProcessPage();
		agentWebHomePage = new AgentWebHomePage();
		//agentWebHomeTest = new AgentWebHomeTest();
		

	}

	// Actions:

	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	public BeneficiariesPage SampleTest(String un, String pwd) {

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
		
		//agentWebHomeTest = new AgentWebHomeTest();
		
		//ProcessFields("self", itrCount, "DTC");
		//ProcessFields("agent", itrCount, "Agent", "Email E Signature", "eft");
		//ProcessFields("customer", itrCount, "Customer", "In Person E Signature", "cc");
		
		processPage.ProcessFields(2, "customer", itrCount, "Customer", "In Person E Signature", "cc");
		
		//payment("cc");
		
		
		//agentWebPage.agentWebLogin(prop.getProperty("username"), prop.getProperty("password"));
		//url = driver.getCurrentUrl(); 
		
		//signUp("agent","Email E Signature", "eft");
		
		//signTypeFlow(rowNum,"Email E Signature", "eft");
		//driver.close();
		//flowType("Email E Signature","eft");
		//agentWebHomeTest.validateQuotationsnEApplications();
		
		paymentPage.makePayment(rowNum, "eft");

		return new BeneficiariesPage();

	}
	
	public boolean addBeneficiaries(int rowNum, String clientType, String signType, String paymentType) {
		
		


		driver.findElement(By.xpath("//button[contains(text(), 'ADD PRIMARY BENEFICIARY')]")).click();
		ProductUtil.CheckElementDoNotExists(".fa.fa-circle-o-notch", true);

		driver.findElement(By.xpath("//label[contains(text(),'Full Name')]//following-sibling::*//input")).sendKeys("test");

		dropdown.click();
		Testutil.staticWait();

		driver.findElement(By.xpath("//div[contains(text(),'Relationship to Proposed Insured')]//following-sibling::*//span[@class='Select-multi-value-wrapper']//input")).sendKeys("Brother");
		selectItem.click();

		driver.findElement(By.xpath("//label[contains(text(),'Share percentage')]//following-sibling::*//input")).sendKeys("100");

		DOB.sendKeys("03/12/1979");
		dateSelect.click();

		driver.findElement(By.xpath("//button[contains(text(),'Next')]")).click();
		ProductUtil.CheckElementDoNotExists(".fa.fa-circle-o-notch", true);
		
		
		
		
		return clientTypeFlow(rowNum, clientType, signType, paymentType);
		
		
		
		
		

		//return true;

	}
	
	public boolean clientTypeFlow(int rowNum, String clientType, String signType, String paymentType){
		
		boolean returnFlag = false;
		processPage = new ProcessPage(); 
		agentWebHomePage = new AgentWebHomePage();
		signaturePage = new SignaturePage();
		paymentPage = new PaymentPage();

		switch (clientType) {

		case "customer":
			System.out.println("clicked esign and submit");
			driver.findElement(By.cssSelector("div > button")).click();
			ProductUtil.CheckElementDoNotExists(".fa.fa-circle-o-notch", true);
			
			signaturePage.signDoc(rowNum, "Customer Application PDF");
			
			Testutil.updateResult(Testutil.resultSheet, "Customer Application PDF", rowNum, "Pass");
			
			String msg="Thank you! Your application has been submitted, we will be in touch with you shortly.";
			
			if(ProductUtil.msgExist(rowNum, By.xpath("//*[contains(text(), '"+ msg +"')]"), msg)) {
				returnFlag = false;
				break;
			}
			
			Testutil.staticLongWait();
			
			paymentPage.paymentTypeFlow(rowNum, paymentType);
			
			Testutil.staticLongWait();
			
			signaturePage.signDoc(rowNum, "Customer Payment form signature");
			Testutil.updateResult(Testutil.resultSheet, "Customer Payment form signature", rowNum, "Pass");
			
			Testutil.staticLongWait();
			
			returnFlag= signaturePage.signTypeFlow(rowNum, signType, paymentType);
			
			
			break;
		
		case "agent":
			
			processPage.ProcessFields(rowNum, "agent", 1, "agent", signType, paymentType);
			
			signatureType.sendKeys(signType);
			selectItem.click();			
			
			
			agentWebHomePage.agentPanel();
			
			signaturePage.signDoc(rowNum, "Agent Application PDF");
			
			Testutil.updateResult(Testutil.resultSheet, "Agent Application PDF", rowNum, "Pass");
			
			Testutil.staticLongWait();			
			
			agentWebHomePage.flowType(signType, paymentType, "");
			driver.quit();
			signaturePage.signTypeFlow(rowNum, signType, paymentType);
			
			
			
			
			
			returnFlag = true;
			break;
			
		default:
			break;
			
		}
		
		return returnFlag;
		
		

		
	}
	
	
}



