package com.lco.qa.pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.lco.qa.base.TestBase;
import com.lco.qa.util.ProductUtil;
import com.lco.qa.util.Testutil;

public class AgentWebHomePage extends TestBase {

	
	AgentWebHomePage agentWebHomePage;
	AgentWebLoginPage agentWebPage;
	// Page Factory - OR
	@FindBy(xpath = "")
	WebElement xyz;

	@FindBy(css = ".test")
	WebElement selectItem;

	@FindBy(name = "UID")
	WebElement loginID;

	@FindBy(name = "PWD")
	WebElement password;

	@FindBy(xpath = "//div[contains(text(),'Start a new Quote')]")
	WebElement startNewQuote;

	@FindBy(xpath = "//a[contains(text(),'New Quote')]")
	WebElement newQuote;

	@FindBy(xpath = "//img[@alt='Quotations/E-Applications']")
	WebElement quotesnApps;
	
	@FindBy(xpath = "//table//tbody//td//following-sibling::*//a")
	WebElement applicantID;
	
	// Initialize the Page objects
	public AgentWebHomePage() {
		PageFactory.initElements(driver, this);

	}

	// Actions:

	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	public AgentWebHomePage newAgentQuote() {

		// driver.findElement(By.xpath(""));
		// driver.findElement(By.cssSelector("")).click();

		startNewQuote.click();
		newQuote.click();

		return new AgentWebHomePage();

	}

	public AgentWebHomePage QuotationsnEApplications() {
		

		quotesnApps.click();
		
		Testutil.staticLongWait();
		
		applicantID.click();
		
		

		return new AgentWebHomePage();

	}
	
	
	public AgentWebHomePage agentPanel() {

		//driver.findElement(By.xpath("//button[@class='c-button-default circular  action btn btn-default']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Next')]")).click();
		ProductUtil.CheckElementDoNotExists(".fa.fa-circle-o-notch", true);

		System.out.println("clicked esign and submit");
		driver.findElement(By.cssSelector("div > button")).click();
		ProductUtil.CheckElementDoNotExists(".fa.fa-circle-o-notch", true);

		return new AgentWebHomePage();

	}

	public AgentWebHomePage refresh(String url) {
		
		
		AgentWebLoginPage agentWebPage;

		///AgentWebHomePage.driver.navigate().refresh();
		
		//TestBase.driver.navigate().refresh();
		
		//driver.navigate().to(url);
		//driver.navigate().refresh();
		
		/*agentWebPage = new AgentWebLoginPage();
		
		TestBase.url = prop.getProperty("agent_url");
		initialization();
		agentWebPage.agentWebLogin(prop.getProperty("username"), prop.getProperty("password"));
		
		driver.findElement(By.xpath("//img[@alt='Quotations/E-Applications']")).click();*/
		
		Testutil.loginAgentPanel();
		
		return new AgentWebHomePage();
		
	}
	
	public AgentWebHomePage close() {
		driver.quit();
		return new AgentWebHomePage();
	}
	

	public AgentWebHomePage completeFlow(String paymentType) {

		driver.findElement(By.xpath("//a[contains(text(),'Make payment')]")).click();
		Testutil.staticLongWait();

		ProductUtil.payment(paymentType);
		Testutil.staticLongWait();
		ProductUtil.clickButton("Continue to Customer Signature");
		Testutil.staticLongWait();
		ProductUtil.signDoc();
		Testutil.staticLongWait();

		driver.findElement(By.xpath("//a[contains(text(),'Sign TIA')]")).click();
		Testutil.staticLongWait();
		ProductUtil.signDoc();
		Testutil.staticLongWait();

		return new AgentWebHomePage();
	}

	public AgentWebHomePage signDoc() {

		boolean arrowFlag = true;
		boolean returnFlag = false;

		Testutil.staticLongWait(By.xpath("//button[@track='continue-button']"));

		System.out.println("clicked continue");
		driver.findElement(By.xpath("//button[@track='continue-button']")).click();

		System.out.println("clicked finish/start");
		driver.findElement(By.xpath("//button[@track='top-finish-button']")).click();

		// Testutil.staticLongWait();

		// driver.findElement(By.xpath("//label[contains(text(), 'I agree to use
		// electronic records and signatures.')]")).click();

		List<WebElement> arrows = driver.findElements(By.cssSelector(".signature-tab-content .tab-image-arrow"));

		Testutil.staticLongWait(By.cssSelector(".signature-tab-content .tab-image-arrow"));

		System.out.println("arrows webelements found: " + arrows.size());

		Iterator<WebElement> webele = arrows.iterator();

		// webele.next();

		WebElement arrowEle = null;

		while (webele.hasNext()) {
			arrowEle = webele.next();

			while (arrowFlag) {

				try {
					System.out.println("trying to click sign arrow");
					if (arrowEle.isDisplayed()) {
						arrowEle.click();
						System.out.println("clicked sign arrow");
						arrowFlag = false;

						Testutil.staticWait();

					} else {
						System.out.println("sign arrow not displayed");
						Testutil.staticLongWait();
						arrowFlag = true;
					}
				} catch (StaleElementReferenceException e) {
					System.out.println(e.getStackTrace());
					System.out.println("element not found");
					arrowFlag = true;
				} catch (Exception e) {
					System.out.println(e.getStackTrace());
					System.out.println("other exception");
					arrowFlag = true;
				}

			}
			arrowFlag = true;

		}

		Testutil.staticLongWait();

		System.out.println("clicked finish");

		driver.findElement(By.xpath("//button[@track='top-finish-button']")).click();

		Testutil.staticLongWait();

		returnFlag = true;

		return new AgentWebHomePage();

	}

	public AgentWebHomePage flowType(String signType, String paymentType, String url) {

		boolean returnFlag = false;

		switch (signType) {

		case "In Person E Signature":

			ProductUtil.clickButton("Continue to Customer Signature");
			Testutil.staticLongWait();
			signDoc();
			Testutil.staticLongWait();
			// ProductUtil.clickButton("Make payment");
			driver.findElement(By.xpath("//a[contains(text(),'Make payment')]")).click();
			Testutil.staticLongWait();

			payment(paymentType);
			Testutil.staticLongWait();
			ProductUtil.clickButton("Continue to Customer Signature");
			Testutil.staticLongWait();
			signDoc();
			Testutil.staticLongWait();

			driver.findElement(By.xpath("//a[contains(text(),'Sign TIA')]")).click();
			Testutil.staticLongWait();
			signDoc();
			Testutil.staticLongWait();
			returnFlag = true;
			break;

		case "Email E Signature":

			Testutil.loginGmail();
			Testutil.openVeryFirstEmail();
			Testutil.staticLongWait();

			System.out.println("clicking on the inbox img ... ");

			driver.findElement(By.xpath("//img[@class='ajT']")).click();

			System.out.println("clicking on the Review and sign ... ");

			// driver.findElement(By.xpath("//a[contains(text(),'REVIEW AND
			// SIGN')]")).click();

			Testutil.findElements(By.xpath("//a[contains(text(),'REVIEW AND SIGN')]"));
			
			Testutil.staticLongWait();
			String winHandleBefore = driver.getWindowHandle();

			for (String winHandle : driver.getWindowHandles()) {
				driver.switchTo().window(winHandle);
			}

			System.out.println("switching the handle");
			
			/*

			signDoc();

			Testutil.staticLongWait();

			String msg = "Thank you! Your application has been submitted, we will be in touch with you shortly.";

			msg = "The application now passed to Agent to proceed further. You will receive an email shortly.";

			// msg = "Thanks for contacting us. We will reach you in sometime.";

			System.out.println("searching for the msg to be displayed");

			ProductUtil.msgExist(
					By.xpath(
							"//*[contains(text(), 'The application now passed to Agent to proceed further. You will receive an email shortly.')]"),
					msg);*/
			
			
			// ProductUtil.msgExist(By.xpath("//*[contains(text(), 'Thank you!
			// Your application has been submitted, we will be in touch with you
			// shortly.')]"), msg);

			// ProductUtil.msgExist(By.xpath("//*[contains(text(), 'Thanks for
			// contacting us. We will reach you in sometime.')]"), msg);

			System.out.println("closing sign window ... ");
			driver.close();

			// Switch back to original browser (first window)
			driver.switchTo().window(winHandleBefore);

			System.out.println("closing email window ... ");

			driver.close();
			
			

			System.out.println("clicking refresh ... ");

			refresh(url);

			System.out.println("before completeFlow ... ");

			completeFlow(paymentType);

			returnFlag = true;
			break;

		default:
			break;

		}

		return new AgentWebHomePage();

	}

	public AgentWebHomePage payment(String payType) {

		boolean returnFlag = false;

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

		return new AgentWebHomePage();
	}

	public AgentWebHomePage setUp() {
		url = prop.getProperty("agent_url");
		initialization();
		/*
		 * agentWebHomePage = new AgentWebHomePage(); agentWebPage = new
		 * AgentWebLoginPage(); productSelectionPage = new ProductSelectionPage();
		 * onePersonGatherInfoPage = new OnePersonGatherInfoPage(); //personalPage = new
		 * PersonalPage();
		 * 
		 * processPage = new ProcessPage(); beneficiariesPage = new BeneficiariesPage();
		 * signaturePage = new SignaturePage(); paymentPage = new PaymentPage();
		 * 
		 * actionPage = new ActionPage();
		 */
		return new AgentWebHomePage();
	}
	
	public void validateQuotationsnEApplications() {
		log.info("****************************** Starting loginPageTitleTest test cases execution *****************************************");
		//extentTest = extent.startTest("loginPageTitleTest");
        
		agentWebPage = new AgentWebLoginPage();
		agentWebHomePage = new AgentWebHomePage();
				
		setUp();
		agentWebPage.agentWebLogin(prop.getProperty("username"), prop.getProperty("password"));
		agentWebHomePage.QuotationsnEApplications();
		String title = agentWebHomePage.validateLoginPageTitle();
		Assert.assertEquals(title, "Vantis Life Insurance Company");
		log.info("****************************** Ending loginPageTitleTest test cases execution *****************************************");
	}
	
}
