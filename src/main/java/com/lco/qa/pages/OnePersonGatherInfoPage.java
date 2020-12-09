package com.lco.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.lco.qa.base.TestBase;
import com.lco.qa.util.Testutil;
import com.lco.qa.util.Xlsutil;

public class OnePersonGatherInfoPage extends TestBase {
	
	//Page Factory - OR
	
	
	@FindBy(xpath="//p[contains(text(),'One person')]")	
	//@FindBy(css=".active-image")
	//@FindBy(xpath="//div[@class='c-select-one-person active col-sm-3']//p[contains(text(),'One person')]")
	//@FindBy(xpath="//div[@class='c-select-one-person active col-sm-3']//p")
	//@FindBy(xpath="//img[@class='active-image']")
	WebElement onePImg;	
	
	@FindBy(name="first-applicant-name-0")
	WebElement first_applicant_name_0;
	
	@FindBy(xpath="//label[contains(text(), 'Female')]")
	WebElement fradioBtn;
	
	@FindBy(xpath="//label[contains(text(), 'Male')]")
	WebElement mradioBtn;
		
	
	@FindBy(xpath="//input[@placeholder='MM/DD/YYYY']")
	WebElement DOB;
	
	@FindBy(xpath="//div[@class='react-datepicker__week']//div[@aria-label='day-12']")
	WebElement dateSelect;
	
	
	@FindBy(xpath="//*[contains(text(),'State')]//following-sibling::*//*[@class='Select-multi-value-wrapper']//input")	
	//@FindBy(xpath="//input[@aria-activedescendant='react-select-2--value']")
	WebElement stateValue;
	
	
	@FindBy(css=".Select-option.is-focused")
	//@FindBy(xpath="//div[@class='Select-option is-focused']")
		//#react-select-2--option-0
	WebElement selectItem;
	
	@FindBy(xpath="//*[contains(text(),'How would you rate your overall health?')]//following-sibling::*//*[@class='Select-multi-value-wrapper']//input")	
	//@FindBy(xpath="//input[@aria-activedescendant='react-select-2--value']")
	WebElement rateHealth;
	
	
	@FindBy(xpath="//label[contains(text(), 'Yes')]")
	WebElement tobUseY;
	
	@FindBy(xpath="//label[contains(text(), 'No')]")
	WebElement tobUseN;
	
	
	
	//@FindBy(xpath="//div//button[@class='c-button-default circular hidden-xs  btn btn-default']")
	//@FindBy(xpath="//div//button[@class='c-button-default circular visible-xs btn btn-default']")
	@FindBy(xpath="//div[@class='c-submit-person-info-btn c-center']//button[1]")
	//@FindBy(xpath="//div[@class='c-submit-person-info-btn c-center']//button[@class='c-button-default.visible.btn-default']")
	//button[@class='c-button-default circular hidden-xs active btn btn-default']
	WebElement nextBtn;
	
	@FindBy(xpath="")
	WebElement xyz;
	
	//Initialize the Page objects
	public OnePersonGatherInfoPage(){
		PageFactory.initElements(driver, this);
		
	}
	
		
	
	//Actions:
	
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	
	public ProductSelectionPage Quote(int rowNum, String FirstName, String DateOfBirth, String Gender, String State, String tobaccoUse, String healthRate) {
		
		String currentURL ="";
		currentURL = driver.getCurrentUrl();
		
		//onePImg.click();
		try{
			
			first_applicant_name_0.sendKeys(FirstName);
			driver.findElement(By.xpath("//label[contains(text(), '" + Gender + "')]")).click();
			//fradioBtn.click();
			
			DOB.sendKeys(DateOfBirth);
			String[] array = DateOfBirth.split("/", -1);
			
			String day = array[1];
			day= day.replaceFirst("^0", "");
			
			driver.findElement(By.xpath("//div[@class='react-datepicker__week']//div[@aria-label='day-" + day + "']")).click();
			//dateSelect.click();
			
					
			stateValue.sendKeys(State);
			selectItem.click();	
			
			
			
			rateHealth.sendKeys(healthRate);
			selectItem.click();	
			
			//tobUseY.click();
			driver.findElement(By.xpath("//label[contains(text(), '" + tobaccoUse + "')]")).click();
			nextBtn.click();
			
			
			
			Testutil.updateResult(Testutil.resultSheet, "URL", rowNum, currentURL);
			return new ProductSelectionPage();
			
			
			
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
			System.out.println("other exception, Quote failed");
			
			Testutil.updateResult(Testutil.resultSheet, "Quote", rowNum, "Fail");
			Testutil.updateResult(Testutil.resultSheet, "URL", rowNum, currentURL);
			return null; 
			
		}
		
		
		
		
		
		
		
	}
	
	
	public ProductSelectionPage Quote1() {
		
		
		onePImg.click();
		
		first_applicant_name_0.sendKeys("test");
		fradioBtn.click();
		
		DOB.sendKeys("03/12/1979");
		dateSelect.click();
		
				
		stateValue.sendKeys("Alaska");
		selectItem.click();	
		
		
		String state_code = driver.findElement(By.xpath("//div[contains(text(),'State')]//following-sibling::*//input")).getAttribute("value");
		System.out.println(state_code);			
		xls.setCellData("Quote1", "State_Code", 2, state_code);
		
		
		
		rateHealth.sendKeys("Excellent");
		selectItem.click();	
		
		tobUseY.click();
		nextBtn.click();
		
		return new ProductSelectionPage();
		
	}

}
