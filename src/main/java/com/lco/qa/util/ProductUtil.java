package com.lco.qa.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.lco.qa.base.TestBase;

public class ProductUtil extends TestBase{
	
	public static void CheckElementDoNotExists(String css, boolean flag) {

		//boolean present = true;

		while (flag) {

			try {
				driver.findElement(By.cssSelector(css));
				try {
					System.out.println("waiting for " + Testutil.waitTime + " milliseconds");
					Thread.sleep(Testutil.waitTime);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				flag = true;
			} catch (NoSuchElementException e) {
				flag = false;
			}

		}

	}
	
	
	public static HashMap<String, String> GetInputData(String SheetName, int rowsCount, int colsCount) {

		HashMap<String, String> inputData = new HashMap<String, String>();
		
		Object[][] x = null;
		try {
			x = Testutil.getTableArray(Testutil.TESTDATA_SHEET_PATH, SheetName, rowsCount, colsCount, 2, 1);
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
		 
		return inputData;
	}
	
	
	public static void selectDropdown(String elementName, String item){
		
		driver.findElement(By.xpath("//div[starts-with(text(),'"+ elementName +"')]//following-sibling::*//span[@class='Select-multi-value-wrapper']//input")).sendKeys(item);
		driver.findElement(By.cssSelector(".Select-option")).click();

		
	}
	
	public static void clickButton(String elementName){
		
		driver.findElement(By.xpath("//button[contains(text(), '"+ elementName + "')]")).click();

		
	}
	
	public static void clickButton(By bycss){
		
		driver.findElement(bycss).click();

		
	}
	
	public static void clickButton(ByXPath xPath){
		
		driver.findElement(xPath).click();

		
	}
	
	public static void inputText(String elementName, String value){
		
		driver.findElement(By.xpath("//label[starts-with(text(),'"+ elementName +"')]//following-sibling::*//input")).sendKeys(value);;

		
	}
	
	public static void inputCCDetails(String elementName, String value){
		
		driver.findElement(By.xpath("//label[starts-with(text(),'"+ elementName +"')]//parent::*//following-sibling::*//input")).sendKeys(value);;

		
	}
	
	public static boolean msgExist(int rowNum, By by, String msg){
		boolean returnFlag = false;
		String currentURL ="";
		currentURL = driver.getCurrentUrl(); 
		
		
		
		try{
			TestBase.wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			Assert.assertNotNull(driver.findElement(by));
			String yourButtonName=driver.findElement(by).getAttribute("innerText");
			if(yourButtonName.equalsIgnoreCase(msg)) { 
				System.out.println("msg exists");
				returnFlag = true;
			}else{
				System.out.println("msg NOT exists");
				returnFlag = false;
			}
			
			
		    //Assert.assertTrue(yourButtonName.equalsIgnoreCase(msg));
			Testutil.updateResult(Testutil.resultSheet, "URL", rowNum, currentURL);	
			return returnFlag;
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
			System.out.println("other exception, msgExist failed");
			//Testutil.updateResult(Testutil.resultSheet, "Quote", rowNum, "Fail");
			Testutil.updateResult(Testutil.resultSheet, "URL", rowNum, currentURL);
			return false; 
			
		}
		
	}

	public static boolean payment(String payType){
		
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
		
		return returnFlag;
		
	}

	public static boolean signDoc(){
    	
    	boolean arrowFlag = true;
    	boolean returnFlag = false;
    	
    	Testutil.staticLongWait(By.xpath("//button[@track='continue-button']"));  		
    	
    	
    	System.out.println("clicked continue");
		driver.findElement(By.xpath("//button[@track='continue-button']")).click();

		System.out.println("clicked finish/start");
		driver.findElement(By.xpath("//button[@track='top-finish-button']")).click();
		
		//Testutil.staticLongWait();

		// driver.findElement(By.xpath("//label[contains(text(), 'I agree to use
		// electronic records and signatures.')]")).click();

		
		List<WebElement> arrows = driver.findElements(By.cssSelector(".signature-tab-content .tab-image-arrow"));
		
		
		Testutil.staticLongWait(By.cssSelector(".signature-tab-content .tab-image-arrow")); 

		System.out.println("arrows webelements found: " + arrows.size());

		Iterator<WebElement> webele = arrows.iterator();

		// webele.next();

		WebElement arrowEle = null;

		while(webele.hasNext()) {
			arrowEle = webele.next();

			while (arrowFlag) {
				
				try{
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
				}catch (StaleElementReferenceException e) {
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
		
			

		/*
		 * if (driver.findElement(By.
		 * cssSelector(".signature-tab-content .tab-image-arrow")).isDisplayed()
		 * ){ driver.findElement(By.
		 * cssSelector(".signature-tab-content .tab-image-arrow")).click();
		 * System.out.println("clicked sign arrow"); }
		 */	

		
		
		/*
		arrowFlag = true;

		

		while (webele.hasNext()) {
			arrowEle = webele.next();
			while (arrowFlag) {
				System.out.println("trying to click sign arrow");
				if (arrowEle.isDisplayed()) {
					arrowEle.click();
					System.out.println("clicked sign arrow");
					arrowFlag = false;
				} else {
					try {
						Thread.sleep(Testutil.waitTime);

					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					arrowFlag = true;
				}
			}

		}*/
		
		Testutil.staticLongWait();

		System.out.println("clicked finish");

		driver.findElement(By.xpath("//button[@track='top-finish-button']")).click();
		
		Testutil.staticLongWait();
		
		returnFlag = true;
		
		return returnFlag;
		
		
    }

	

}
