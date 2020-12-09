package com.lco.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.lco.qa.base.TestBase;
import com.lco.qa.util.ProductUtil;

public class ActionPage extends TestBase{
	
	//Page Factory - OR
		@FindBy(xpath="")
		WebElement xyz;
		
		@FindBy(css=".test")
		WebElement selectItem;
		
		@FindBy(css=".next-action-img-container .hidden-xs")
		WebElement continueToApp;
		
		@FindBy(css=".hidden-xs.c-button-default")
		WebElement nextButton;
		
		@FindBy(name="email-1")
		WebElement emailAddress;
		
		@FindBy(xpath="//button[contains(text(), 'SUBMIT')]")
		WebElement submitButton;
		
		
		
		@FindBy(xpath="//div[@class='agent-next-step-container']//*//label")
		WebElement completetheApp;
		
			
		
	//Initialize the Page objects
	public ActionPage(){
		PageFactory.initElements(driver, this);
		
	}	
	
	//Actions:
	
	public String validateActionPageTitle() {
		return driver.getTitle();
	}
	
	public ActionPage selectAction(String actionType, String email) {
		
		
		
		try{
			//driver.findElement(By.xpath(""));
			//driver.findElement(By.cssSelector("")).click();
			
			switch (actionType) {
			case "Continue to application":

				/*if (FieldType(elementF, "text")) {
					elementF.sendKeys("999");
					System.out.println("typed number");
				}*/
				
				//driver.findElement(By.cssSelector(".next-action-img-container .hidden-xs")).click();
				continueToApp.click();
				break;
				
			case "Complete the application":

					completetheApp.click();
					break;	
				
				
			default:
				//elementF.sendKeys("default");
				break;

			}
			
			nextButton.click();
			emailAddress.sendKeys(email);
			
			
			
			String currenURL = driver.getCurrentUrl();
			//driver.navigate().to(currenURL);
			
			//driver.get("https://linkedin.com")
			String winHandleBefore = driver.getWindowHandle();
			
			submitButton.click();
			
			ProductUtil.CheckElementDoNotExists(".fa.fa-circle-o-notch", true);

			// Perform the click operation that opens new window

			// Switch to new window opened
			for(String winHandle : driver.getWindowHandles()){
			    driver.switchTo().window(winHandle);
			}
			
			System.out.println("switching the handle");

			// Perform the actions on new window

			// Close the new window, if that window no more required
			//driver.close();

			// Switch back to original browser (first window)
			driver.switchTo().window(winHandleBefore);
			
			
			
			
			
			return new ActionPage();
			
			
			
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
			System.out.println("other exception, Quote failed");
			return null; 
			
		}
		
		
		
	}

}
