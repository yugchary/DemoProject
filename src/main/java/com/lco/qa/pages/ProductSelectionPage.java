package com.lco.qa.pages;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.lco.qa.base.TestBase;
import com.lco.qa.util.Testutil;

public class ProductSelectionPage extends TestBase {

	// Page Factory - OR
	@FindBy(xpath = "")
	WebElement xyz;

	@FindBy(xpath = "//button[@class='c-button-default circular hidden-xs active btn btn-default']")
	WebElement nextBtn;

	@FindBy(xpath = "//button[@class='c-button-default circular hidden-xs btn btn-default']")
	WebElement nextFinalBtn;
	// c-button-default circular hidden-xs btn btn-default

	// Initialize the Page objects
	public ProductSelectionPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions:
	public String validateProductSelectionPageTitle() {
		return driver.getTitle();
	}

	public ProductSelectionPage GetPersonInfo(String FirstName, String DateOfBirth, String Gender, String State, String tobaccoUse, String healthRate, String stateCode) {

		List<WebElement> list = driver
				.findElements(By.cssSelector(".visible-xs .person-content.row .person-label-content"));

		System.out.println(list.size());

		Iterator<WebElement> t = list.iterator();

		int i = 0;
		while (t.hasNext()) {
			i++;

			String returnText = t.next().getAttribute("innerHTML").toString();
			// t.next().click();
			System.out.println("i value: " + i + returnText);
			
			
	        String dayString; 
	  
	        // switch statement with int data type 
	        switch (i) { 
		        case 1: 
		            if (returnText.contains(stateCode))
		            	System.out.println("State Code is saved successfully" + stateCode);
		            else
		        		System.out.println("State is NOT saved successfully" + stateCode);
		            break; 
		        case 2: 
		        	if (returnText.contains(Gender))
		            	System.out.println("Gender is saved successfully" + Gender);
		        	else
		        		System.out.println("Gender is NOT saved successfully" + Gender);
		            break;
		        case 3: 
		        	DateOfBirth = DateOfBirth.replace(".", "/");
		        	if (returnText.contains(DateOfBirth))
		            	System.out.println("DateOfBirth is saved successfully" + DateOfBirth);	
		        	else
		        		System.out.println("DateOfBirth is NOT saved successfully" + DateOfBirth);
		            break; 
		        case 4: 
		        	if (returnText.contains(healthRate))
		            	System.out.println("healthRate is saved successfully" + healthRate);
		        	else
		        		System.out.println("healthRate is NOT saved successfully" + healthRate);
		            break;
		        case 5: 
		        	if (returnText.contains(tobaccoUse))
		            	System.out.println("Tobacco Use is saved successfully" + tobaccoUse);
		        	else
		        		System.out.println("Tobacco Use is NOT saved successfully" + tobaccoUse);
		            break;  
		        default: 
		            dayString = "Invalid day"; 
		            break; 
	        	} 
	        //System.out.println(dayString); 
	    	

		}return new ProductSelectionPage();

	}

	public ProductSelectionPage ProductSelection() {
		
		
		//driver.findElement(By.cssSelector(".c-center.mt50.row .quote-this-product-container")).e
		
		try{
			
			List<WebElement> list = driver.findElements(By.cssSelector(".c-center.mt50.row .quote-this-product-container"));

			System.out.println(list.size());

			Iterator<WebElement> t = list.iterator();

			int i = 0;
			
			if (list.size()>0) {
				while (t.hasNext()) {
					i++;
					t.next().click();

				}
				nextBtn.click();
			}else {
				String returnText = driver.findElement(By.cssSelector(".c-center .inner-no-product-container")).getAttribute("innerHTML").toString();
				if (returnText.contains("No products available"))
	            	System.out.println("No products available - message is displayed");
	        	else
	        		System.out.println("No products available - message is NOT displayed");
			}
			
			
			
			return new ProductSelectionPage();
			
			
			
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
			System.out.println("other exception, Quote failed");
			return null; 
			
		}

		

	}

	public void WaitForAzaxComponentToLoad(By by) {

		List<WebElement> listItem = driver.findElements(by);

		System.out.println("size of the webelements:" + listItem.size());

		Iterator<WebElement> itr = listItem.iterator();

		int i = 0;

		while (itr.hasNext()) {

			String returnText = itr.next().getText();
			System.out.println(i + "value" + returnText);
			while (returnText.isEmpty() && (i <= listItem.size())) {
				i++;
				System.out.println(i + "value" + returnText);

				try {
					Thread.sleep(Testutil.waitTime);
					System.out.println(i + "sleeping");
					listItem = driver.findElements(by);
					itr = listItem.iterator();
					returnText = itr.next().getText();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}
	}

	public ProductSelectionPage FinalizeProductSelection() {

		try{
			WaitForAzaxComponentToLoad(By.cssSelector(".plan-sider-info-text.row .plan-cost-amount"));
		
			List<WebElement> list = driver
					.findElements(By.cssSelector(".c-center.col-sm-12 .select-this-product-container.row"));
		
			System.out.println(list.size());
		
			Iterator<WebElement> t = list.iterator();
		
			int i1 = 0;
			while (t.hasNext()) {
				i1++;
				t.next().click();
				System.out.println("clicked: " + i1);
			}
		
			WaitForAzaxComponentToLoad(By.cssSelector(".plan-total-text"));
		
			nextFinalBtn.click();
			return new ProductSelectionPage();
			
			
			
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
			System.out.println("other exception, Quote failed");
			
			return null; 
			
		}

	}

}
