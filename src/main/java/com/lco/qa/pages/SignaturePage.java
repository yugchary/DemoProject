package com.lco.qa.pages;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.lco.qa.base.TestBase;
//import com.lco.qa.testcases.AgentWebHomeTest;
import com.lco.qa.util.ProductUtil;
import com.lco.qa.util.Testutil;
import com.lco.qa.util.Xlsutil;

public class SignaturePage extends TestBase {

	
	AgentWebHomePage agentWebHomePage;
	AgentWebLoginPage agentWebPage;
	ProcessPage processPage;
	PaymentPage paymentPage;
	SignaturePage signaturePage;
	
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
	public SignaturePage() {
		PageFactory.initElements(driver, this);

	}

	// Actions:

	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	public SignaturePage SampleTest(String un, String pwd) {

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
		//AgentWebHomeTest agentWebHomeTest;
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

		return new SignaturePage();

	}

		
	public void drawCanvas(){
		
		// CheckElementExists(".signature-tab-content .tab-image-arrow", true);

				System.out.println("clicked draw");
				driver.findElement(By.xpath("//button[contains(text(), 'Draw')]")).click();

				// driver.findElement(By.xpath("//button[contains(text(), 'Adopt and
				// Sign')]")).click();

				// click esign //button[contains(text(), 'ESIGN AND SUBMIT')]

				WebElement wbCanvas = driver.findElement(By.cssSelector(".signature-draw .canvas-wrapper"));

				System.out.println("x:" + wbCanvas.getLocation());

				System.out.println("Going to draw");

				/*Actions actionBuilder = new Actions(driver);
				Action drawOnCanvas = actionBuilder.moveToElement(wbCanvas, 97, 331).clickAndHold(wbCanvas).moveByOffset(10, 20)
						// .click(wbCanvas)
						.moveByOffset(200, 320).release()
						// .doubleClick(wbCanvas)
						.build();
				drawOnCanvas.perform();*/
				
				Actions actionBuilder = new Actions(driver);
				Action drawOnCanvas = actionBuilder.moveToElement(wbCanvas, 20, 20)
						.clickAndHold(wbCanvas)
						.moveByOffset(80, 80)
						//.click(wbCanvas)
						// .click(wbCanvas)
						.moveByOffset(50, 20)
						.release(wbCanvas)
						//.doubleClick(wbCanvas)
						.build();
				drawOnCanvas.perform();

				System.out.println("clicked Adopt and Sign");

				driver.findElement(By.xpath("//button[contains(text(), 'Adopt and Sign')]")).click();
	}

	
    public boolean signDoc(int rowNum, String docType){
    	
    	String currentURL ="";
		currentURL = driver.getCurrentUrl();
    	
    	try{
			
    		boolean returnFlag = false;
        	
        	Testutil.staticLongWait(By.xpath("//button[@track='continue-button']"));  		
        	
        	
        	System.out.println("clicked continue");
    		driver.findElement(By.xpath("//button[@track='continue-button']")).click();

    		System.out.println("clicked finish/start");
    		driver.findElement(By.xpath("//button[@track='top-finish-button']")).click();
    		
    		//Testutil.staticLongWait();

    		// driver.findElement(By.xpath("//label[contains(text(), 'I agree to use
    		// electronic records and signatures.')]")).click();

    		
    		//List<WebElement> arrows = driver.findElements(By.cssSelector(".signature-tab-content .tab-image-arrow"));
    		System.out.println("clickArrow 1st time");
    				
    		clickArrow();
    		System.out.println("clickArrow 2nd time");
    		clickArrow();
    			

    		
    		
    		//Testutil.staticLongWait();

    		System.out.println("clicked finish");

    		driver.findElement(By.xpath("//button[@track='top-finish-button']")).click();
    		
    		Testutil.staticLongWait();
    		
    		returnFlag = true;
    		//Testutil.updateResult(Testutil.resultSheet, "URL", rowNum, currentURL);
    		
    		return returnFlag;
			
			
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
			System.out.println("other exception, pdf sign failed" + docType);
			Testutil.updateResult(Testutil.resultSheet, docType, rowNum, "Fail");
			Testutil.updateResult(Testutil.resultSheet, "URL", rowNum, currentURL);
			return false; 
			
		}
    	
    	
    	
		
		
    }

    public boolean signTypeFlow(int rowNum, String signType, String paymentType){
    	
    	boolean returnFlag = false;

		switch (signType) {

		case "In Person E Signature":				
			
			
			String msg="Thank you! Your application has been submitted, we will be in touch with you shortly.";
			
			if(ProductUtil.msgExist(rowNum, By.xpath("//*[contains(text(), '"+ msg +"')]"), msg)) {
				returnFlag = false;
				break;
			}
			
			ProductUtil.clickButton("Continue to Customer Signature");
			Testutil.staticLongWait();
			signDoc(rowNum, "Application PDF");
			Testutil.staticLongWait();
			//ProductUtil.clickButton("Make payment");
			driver.findElement(By.xpath("//a[contains(text(),'Make payment')]")).click();
			Testutil.staticLongWait();
			
			paymentPage.paymentTypeFlow(rowNum, paymentType);
			Testutil.staticLongWait();
			ProductUtil.clickButton("Continue to Customer Signature");
			Testutil.staticLongWait();
			signDoc(rowNum, "Application PDF");
			Testutil.staticLongWait();
			
			driver.findElement(By.xpath("//a[contains(text(),'Sign TIA')]")).click();
			Testutil.staticLongWait();
			signDoc(rowNum, "Application PDF");
			Testutil.staticLongWait();
			returnFlag = true;
			break;
		
		case "Email E Signature":
			
			returnFlag = EmailSign(rowNum, "REVIEW AND SIGN", "The application now passed to Agent to proceed further. You will receive an email shortly.", "CustomerApplication PDF");
		  	
			Testutil.updateResult(Testutil.resultSheet, "CustomerApplication PDF", rowNum, "Pass");
		  	
			/*System.out.println("clicking refresh ... ");
		  	
		  	agentWebHomePage.refresh("");
		  	
		  	System.out.println("before completeFlow ... ");
		  	
		  	agentWebHomePage.completeFlow(paymentType);*/
		  	
		  	//returnFlag = true;
			break;
		  	
		  	
			
			
			
		default:
			break;
			
		}
		return returnFlag;
    	
    }

            
    public boolean signTIA(int rowNum, String paymentType) {
    	
    	//AgentWebHomeTest agentWebHomeTest;
    	//agentWebHomeTest = new AgentWebHomeTest();
    	boolean returnFlag = false;

		driver.quit();
		driver.findElement(By.xpath("//a[contains(text(),'Sign TIA')]")).click();
		Testutil.staticLongWait();
		signDoc(rowNum, "Application PDF");
		Testutil.staticLongWait();

		returnFlag = true;
		
		return returnFlag;
	}
        
    
    public boolean EmailSign(int rowNum, String signType, String msg, String resultMsg) {
    	
    	boolean returnFlag = false;
    	
    	String currentURL ="";
		currentURL = driver.getCurrentUrl(); 
		
		
		
		try{
    	
	    	Testutil.loginGmail();
	    	Testutil.staticWait();
			Testutil.openVeryFirstEmail();
			
			
			
			System.out.println("clicking on the inbox img ... ");
			
			Testutil.WaitnClick(By.xpath("//img[@class='ajT']"));
			
			//driver.findElement(By.xpath("//img[@class='ajT']")).click();
			
			System.out.println("clicking on the Review and sign ... ");
			
			//driver.findElement(By.xpath("//a[contains(text(),'REVIEW AND SIGN')]")).click();
			
			Testutil.findElements(By.xpath("//a[contains(text(),'"+ signType +"')]"));
			Testutil.staticLongWait();
			String winHandleBefore = driver.getWindowHandle();
			
			for(String winHandle : driver.getWindowHandles()){
			    driver.switchTo().window(winHandle);
			}
			
			System.out.println("switching the handle");
			
			signDoc(rowNum, resultMsg);
			
			Testutil.staticLongWait();
			
			//msg = "Thank you! Your application has been submitted, we will be in touch with you shortly.";
			
			//msg = "The application now passed to Agent to proceed further. You will receive an email shortly."; 
			
			//msg = "Thanks for contacting us. We will reach you in sometime.";
			
			
			System.out.println("searching for the msg to be displayed");
			
			ProductUtil.msgExist(rowNum, By.xpath("//*[contains(text(), '"+ msg +"')]"), msg);
			//ProductUtil.msgExist(By.xpath("//*[contains(text(), 'Thank you! Your application has been submitted, we will be in touch with you shortly.')]"), msg);
			
			//ProductUtil.msgExist(By.xpath("//*[contains(text(), 'Thanks for contacting us. We will reach you in sometime.')]"), msg);
			
			System.out.println("closing sign window ... ");
			driver.close();
	
		  	// Switch back to original browser (first window)
		  	driver.switchTo().window(winHandleBefore);
		  	
		  	System.out.println("closing email window ... ");
		  		
		  	driver.close();
		  	
		  	returnFlag = true;
			
			
			//Testutil.updateResult(Testutil.resultSheet, "URL", rowNum, currentURL);	
			return returnFlag;
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
			System.out.println("other exception, "+resultMsg+" failed");
			Testutil.updateResult(Testutil.resultSheet, resultMsg, rowNum, "Fail");
			Testutil.updateResult(Testutil.resultSheet, "URL", rowNum, currentURL);
			return false; 
			
		}
	  	
    	
    }

    public void clickArrow(){
    	
    	
    	boolean arrowFlag = true;
    	List<WebElement> arrows = driver.findElements(By.xpath("//button[@class='tab-button']//div//div//following-sibling::*//following-sibling::*//following-sibling::*"));
		
		
		
		
		Testutil.staticLongWait(By.cssSelector(".signature-tab-content .tab-image-arrow")); 

		System.out.println("arrows webelements found: " + arrows.size());

		Iterator<WebElement> webele = arrows.iterator();

		// webele.next();

		WebElement arrowEle = null;
		
		int i=0;

		while(webele.hasNext()) {
			arrowEle = webele.next();
	
			while (arrowFlag && webele.hasNext()) {
				
				try{
					System.out.println("trying to click sign arrow");
					if (arrowEle.isDisplayed()) {
						arrowEle.click();
						System.out.println("clicked sign arrow");
						arrowFlag = false;
						
						
						Testutil.staticWait();
						i++;
						
					} else {
						System.out.println("sign arrow not displayed");
						Testutil.staticWait();
						arrowFlag = true;
						arrowEle = webele.next();
					}
				}catch (StaleElementReferenceException e) {
					System.out.println(e.getStackTrace());
					System.out.println("element not found");
					arrowFlag = true;
				} catch (Exception e) {
					System.out.println(e.getStackTrace());
					System.out.println("other exception in clickArrow");
					arrowFlag = true;
				}
				
			}
			arrowFlag = true;
		}

    	
    }

}



