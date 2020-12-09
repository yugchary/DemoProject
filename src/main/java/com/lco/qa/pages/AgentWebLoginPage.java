package com.lco.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.lco.qa.base.TestBase;

public class AgentWebLoginPage extends TestBase{
	
	//Page Factory - OR
		@FindBy(xpath="")
		WebElement xyz;
		
		@FindBy(css=".test")
		WebElement selectItem;
		
		@FindBy(name="UID")
		WebElement loginID;
		
		@FindBy(name="PWD")
		WebElement password;
		
		@FindBy(xpath="//input[@type='image']")
		WebElement loginButton;
		
		
		@FindBy(xpath="//div[contains(text(),'Start a new Quote')]")
		WebElement startNewQuote;
		
		@FindBy(xpath="//a[contains(text(),'New Quote')]")
		WebElement newQuote;
		
	//Initialize the Page objects
	public AgentWebLoginPage(){
		PageFactory.initElements(driver, this);
		
	}	
	
	//Actions:
	
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public AgentWebHomePage agentWebLogin(String un, String pwd) {
		
		//driver.findElement(By.xpath(""));
		//driver.findElement(By.cssSelector("")).click();
		
		loginID.sendKeys(un);
		password.sendKeys(pwd);
		loginButton.click();
		
		return new AgentWebHomePage();
		
	}
	
	

}
