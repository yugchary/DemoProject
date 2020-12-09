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
///import com.lco.qa.testcases.AgentWebHomeTest;
import com.lco.qa.util.ProductUtil;
import com.lco.qa.util.Testutil;

public class PersonalPage extends TestBase {

	
	AgentWebHomePage agentWebHomePage;
	AgentWebLoginPage agentWebPage;
	
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
	public PersonalPage() {
		PageFactory.initElements(driver, this);

	}

	// Actions:

	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	public PersonalPage SampleTest(String un, String pwd) {

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
		
		ProcessFields(2, "customer", itrCount, "Customer", "In Person E Signature", "cc");
		
		//payment("cc");
		
		
		//agentWebPage.agentWebLogin(prop.getProperty("username"), prop.getProperty("password"));
		//url = driver.getCurrentUrl(); 
		
		//signUp("agent","Email E Signature", "eft");
		
		//signTypeFlow(rowNum,"Email E Signature", "eft");
		//driver.close();
		//flowType("Email E Signature","eft");
		//agentWebHomeTest.validateQuotationsnEApplications();
		
		makePayment(rowNum, "eft");

		return new PersonalPage();

	}

	public void ProcessFields(int rowNum, String clientType, int iteratorCount, String sheetName, String signType, String paymentType) {
		
		//String sheetName = "DTC";
		
		String currentURL ="";
		currentURL = driver.getCurrentUrl(); 
		
		
		
		try{
			inputData = ProductUtil.GetInputData(sheetName, 129, 5);
			agentWebHomePage = new AgentWebHomePage();
	
			int formFlag = 0;
			int checkboxFlag = 0;
			int buttonFlag = 0;
			int dropDownFlag = 0;
			int autoSuggFlag = 0;
			int datePickerFlag = 0;
			int i = 0;
			int counter = 0;
			By byFormL = null;
			By byFormF = null;
			By byButtonL = null;
			By byButtonF = null;
			By byNoButtonF = null;
			By byAutoSuggL = null;
			By byautoSuggF = null;
			By byDropdownF = null;
			By byDropdownL = null;
			By byCheckboxL = null;
			By byCheckboxF = null;
			By byDatepickerL = null;
			By byDatepickerF = null;
			String fieldFlag = null;
			boolean doneFlag = false;
			boolean agentFlag = false;
			boolean flowFlag = false;
			//String currentURL ="";
			
	
			byFormL = By.cssSelector(".form-group");
			byFormF = By.cssSelector(".form-group .field .form-control");
	
			byButtonL = By.cssSelector(".c-subheader-text.fs18.col-sm-12"); // class
																			// btn
			byButtonF = By.cssSelector(".single-select-btn-container .c-button-default");
			byNoButtonF = By.cssSelector("button[class='c-button-default circular single-select-btn  btn btn-default']");
	
			byAutoSuggL = By.cssSelector(".c-subheader-text.fs18.col-sm-12"); // auto
			byautoSuggF = By.xpath("//input[@autocomplete='off']");
	
			byDropdownL = By.cssSelector(".c-subheader-text.fs18"); // select
			byDropdownF = By.cssSelector(".Select-placeholder");
			
			byCheckboxL = By.cssSelector(".custom-checkbox-container");
			byCheckboxF = By.cssSelector(".custom-checkbox-container .custom-checkbox-checkmark");
	
			byDatepickerL = By.cssSelector(".c-subheader-text.fs18.col-sm-12");
			byDatepickerF = By.cssSelector(".react-datepicker-wrapper");
	
			HashMap<String, Integer> ele = FindElements();
	
			for (Entry eleType : ele.entrySet()) {
	
				String line = eleType.getKey() + " " + eleType.getValue();
				System.out.println("Fields: " + line);
	
				fieldFlag = eleType.getKey().toString();
	
				switch (fieldFlag) {
	
				case "formFlag":
					byFormL = By.cssSelector(".form-group");
					byFormF = By.cssSelector(".form-group .field .form-control");
					formFlag = Integer.parseInt(eleType.getValue().toString());
					break;
				case "buttonFlag":
					byButtonL = By.cssSelector(".c-subheader-text.fs18.col-sm-12"); // class
																					// btn
					byButtonF = By.cssSelector(".single-select-btn-container .c-button-default");
					byNoButtonF = By
							.cssSelector("button[class='c-button-default circular single-select-btn  btn btn-default']");
					buttonFlag = Integer.parseInt(eleType.getValue().toString());
					break;
				case "autoSuggFlag":
					byAutoSuggL = By.cssSelector(".c-subheader-text.fs18.col-sm-12"); // auto
					byautoSuggF = By.xpath("//input[@autocomplete='off']");
					autoSuggFlag = Integer.parseInt(eleType.getValue().toString());
					break;
				case "dropDownFlag":
					byDropdownF = By.cssSelector(".Select-placeholder");
					byDropdownL = By.cssSelector(".c-subheader-text.fs18"); // select
					dropDownFlag = Integer.parseInt(eleType.getValue().toString());
					break;
				case "checkboxFlag":
					byCheckboxL = By.cssSelector(".custom-checkbox-container");
					byCheckboxF = By.cssSelector(".custom-checkbox-container .custom-checkbox-checkmark");
					checkboxFlag = Integer.parseInt(eleType.getValue().toString());
					break;
				case "datePickerFlag":
					byDatepickerL = By.cssSelector(".c-subheader-text.fs18.col-sm-12");
					byDatepickerF = By.cssSelector(".react-datepicker-wrapper");
					datePickerFlag = Integer.parseInt(eleType.getValue().toString());
					break;
	
				default:
					break;
	
				}
	
				System.out.println(line);
	
			}
	
			String pageType = "def";
			boolean flag = false, breakFlag = true, errorFlag = false, beneficiaryFlag = true;
	
			do {
	
				
				currentURL = driver.getCurrentUrl();
				//Testutil.updateResult(Testutil.resultSheet, "URL", rowNum, currentURL);
				if (i == iteratorCount) {
					System.out.println("Iterator Limit");
					break;
				}
				
				/*formFlag = 0;
				checkboxFlag = 0;
				buttonFlag = 0;
				dropDownFlag = 0;
				autoSuggFlag = 0;
				datePickerFlag = 0;*/
				
	
				if (autoSuggFlag > 0) {
					pageType = "autoSugg";
					System.out.println("This is a page filled with " + pageType);
					// checkPage(CheckNextElement(byautoSuggF),
					// byautoSuggF,pageType);
					breakFlag = checkPage(CheckNextElement(autoSuggFlag, byAutoSuggL),
							CheckNextElement(autoSuggFlag, byautoSuggF), byAutoSuggL, byautoSuggF, pageType, sheetName);
	
					if (!breakFlag) {
						System.out.println("Break point");
						break;
					}
				}
	
				
	
				if (datePickerFlag > 0) {
					pageType = "datepicker";
					System.out.println("This is a page filled with " + pageType);
					// checkPage(CheckNextElement(byDatepickerF),
					// byDatepickerF,pageType);
					breakFlag = checkPage(CheckNextElement(datePickerFlag, byDatepickerL),
							CheckNextElement(datePickerFlag, byDatepickerF), byDatepickerL, byDatepickerF, pageType, sheetName);
					if (!breakFlag) {
						System.out.println("Break point");
						break;
					}
				}
	
				
				if (checkboxFlag > 0) {
					pageType = "checkbox";
					System.out.println("This is a page filled with " + pageType);
					breakFlag = checkPage(CheckNextElement(checkboxFlag, byCheckboxL),
							CheckNextElement(checkboxFlag, byCheckboxF), byCheckboxL, byCheckboxF, pageType, sheetName);
					if (!breakFlag) {
						System.out.println("Break point");
						break;
					}
				}
	
				
				if (formFlag > 0) {
					pageType = "form";
					System.out.println("This is a page filled with " + pageType);
					breakFlag = checkPage(CheckNextElement(formFlag, byFormL), CheckNextElement(formFlag, byFormF), byFormL,
							byFormF, pageType, sheetName);
					if (!breakFlag) {
						System.out.println("Break point");
						break;
					}
				}
	
				
				if (buttonFlag > 0) {
					pageType = "button";
					System.out.println("This is a page filled with " + pageType);
					// checkPage(CheckNextElement(byButtonF), byButtonF, pageType);
					breakFlag = checkPage(CheckNextElement(buttonFlag, byButtonL), CheckNextElement(buttonFlag, byButtonF),
							byButtonL, byButtonF, pageType, sheetName);
					if (!breakFlag) {
						System.out.println("Break point");
						break;
					}
				}
	
				
				if (dropDownFlag > 0) {
					pageType = "dropdown";
					System.out.println("This is a page filled with " + pageType);
					
					breakFlag = checkPage(CheckNextElement(dropDownFlag, byDropdownL),
							CheckNextElement(dropDownFlag, byDropdownF), byDropdownL, byDropdownF, pageType, sheetName);
					if (!breakFlag) {
						System.out.println("Break point");
						break;
					}
				}
	
				boolean singlebutton = false;
	
				if (formFlag == 0 && checkboxFlag == 0 && buttonFlag == 0 && dropDownFlag == 0 && autoSuggFlag == 0
						&& datePickerFlag == 0) {
	
					try {
						flowFlag = true;
						doneFlag = addBeneficiaries(rowNum, clientType, signType, "cc");					
						//errorFlag = true;
						System.out.println("completed");
						singlebutton = true;
	
					} catch (NoSuchElementException e) {
						System.out.println(e.getStackTrace());
						System.out.println("issue with sign-up/beneficiary not reached");
						errorFlag = true;
						singlebutton = true;
						Testutil.updateResult(Testutil.resultSheet, "Questions", rowNum, "Fail");
						Testutil.updateResult(Testutil.resultSheet, "URL", rowNum, currentURL);
					} catch (Exception e) {
						System.out.println(e.getStackTrace());
						System.out.println("other exception in addBeneficiaries");
					}
				}
	
				i++;
				
				boolean singlebuttonFlag = false;
	
				if (formFlag == 0 && checkboxFlag == 0 && buttonFlag == 1 && dropDownFlag == 0 && autoSuggFlag == 0
						&& datePickerFlag == 0){
					singlebutton = true;
					singlebuttonFlag = true;
				}
				
				boolean doubleButton = false;
	
				if (Testutil.doubleButtosFlag && singlebuttonFlag){
					singlebutton = false;
					doubleButton = true;
					
				}
				
				
				boolean completeFlag = false;
				
				if(doubleButton && !Testutil.doubleButtosFlag ) completeFlag = true;
				
				if(clientType.equalsIgnoreCase("agent") && doneFlag) agentFlag = true;	
				
				if(flag || agentFlag){
					System.out.println("execution completed for agent type");
					Testutil.updateResult(Testutil.resultSheet, "Questions", rowNum, "Pass");
					break;
				}
				
				if(!doneFlag && flowFlag){
					System.out.println("something went wrong");
					Testutil.updateResult(Testutil.resultSheet, "Questions", rowNum, "Fail");
					break;
				}
				
				
				if (singlebutton || completeFlag || agentFlag) {
					System.out.println("only button with single page " + i + ", auto load");
				} else {
					System.out.println("All submited in page " + i + ", going to next page. Clicking on Next button");
	
					driver.findElement(By.xpath("//button[@class='c-button-default circular  action btn btn-default']"))
							.click();
					
				}	
				
				
				
				ProductUtil.CheckElementDoNotExists(".fa.fa-circle-o-notch", true);			
	
				formFlag = 0;
				checkboxFlag = 0;
				buttonFlag = 0;
				dropDownFlag = 0;
				autoSuggFlag = 0;
				datePickerFlag = 0;
	
				ele = null;
	
				ele = FindElements();
	
				for (Entry eleType : ele.entrySet()) {
	
					String line = eleType.getKey() + " " + eleType.getValue();
					System.out.println("Fields: " + line);
					fieldFlag = eleType.getKey().toString();
	
					switch (fieldFlag) {
	
					case "formFlag":
						formFlag = Integer.parseInt(eleType.getValue().toString());
						break;
					case "buttonFlag":
						buttonFlag = Integer.parseInt(eleType.getValue().toString());
						break;
					case "autoSuggFlag":
						autoSuggFlag = Integer.parseInt(eleType.getValue().toString());
						break;
					case "dropDownFlag":
						dropDownFlag = Integer.parseInt(eleType.getValue().toString());
						break;
					case "checkboxFlag": // byCheckboxL =
						By.cssSelector(".custom-checkbox-container");
						
						checkboxFlag = Integer.parseInt(eleType.getValue().toString());
						break;
					case "datePickerFlag": // byDatepickerL =
						By.cssSelector(".c-subheader-text.fs18.col-sm-12");
						
						datePickerFlag = Integer.parseInt(eleType.getValue().toString());
						break;
	
					default:
						break;
	
					}
	
					System.out.println(line);
	
				}
	
				
	
				if (formFlag == 0 && checkboxFlag == 0 && buttonFlag == 0 && dropDownFlag == 0 && autoSuggFlag == 0
						&& datePickerFlag == 0) {
					counter++;
					if (counter == 2)
						flag = true;
				}
	
				if (!breakFlag){
					System.out.println("break point stopped the execution");
					Testutil.updateResult(Testutil.resultSheet, "Questions", rowNum, "Break");
					break;
				}
					
				if(flag || doneFlag){
					System.out.println("execution completed");
					Testutil.updateResult(Testutil.resultSheet, "Questions", rowNum, "Pass");
					break;
				}			
				
				if(errorFlag){
					System.out.println("execution completed with error");
					Testutil.updateResult(Testutil.resultSheet, "Questions", rowNum, "Fail");
					break;
				}
	
			} while (formFlag > 0 || checkboxFlag > 0 || buttonFlag > 0 || dropDownFlag > 0 || autoSuggFlag > 0
					|| datePickerFlag > 0 || beneficiaryFlag);
	
			//while (formFlag > 0 || checkboxFlag > 0 || buttonFlag > 0 || dropDownFlag > 0 || autoSuggFlag > 0 	|| datePickerFlag > 0 || flag  || doneFlag || errorFlag);
			// return new PersonalPage();
			
			//Testutil.updateResult(Testutil.resultSheet, "URL", rowNum, currentURL);	
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
			System.out.println("other exception, Test failed/by passed");
						
		}

	}

	public HashMap<String, Integer> FindElements() {

		// By elementsCount = By.cssSelector(".questions-content-container >
		// div");
		By elementsCount = By.cssSelector(".questions-container.c-center.row> div");

		List<WebElement> listWebElementLabel = driver.findElements(elementsCount);

		HashMap<String, Integer> ele = new HashMap<String, Integer>();

		HashMap<String, Integer> ele1 = null;

		System.out.println("found webelements: " + listWebElementLabel.size());

		Iterator<WebElement> l;

		l = listWebElementLabel.iterator();

		//

		int i = 0;
		String fieldType = null, className = null;
		By byElements = null;

		while (l.hasNext()) {

			WebElement elementL = l.next();
			i++;

			fieldType = null;
			className = null;

			className = elementL.getAttribute("class").toString();

			switch (className) {

			case "questions-content-container":
				// byElements =
				// By.xpath("//div[@class='questions-content-container']//div//following-sibling::*");
				ele1 = childElements();
				ele.putAll(ele1);
				break;

			case "form-group":

				fieldType = "formFlag";

				break;
			case "question-action-btn-container":
				byElements = By.cssSelector(".question-action-btn-container");
				// if (i>1) className =
				// driver.findElement(byElements).getAttribute("class").toString();
				break;

			default:
				break;

			}

			

			System.out.println("className: " + className);

			if (className == "form-group")
				fieldType = "formFlag";

			if (className.contains("c-custom-select"))
				fieldType = "dropDownFlag";

			if (className.contains("auto"))
				fieldType = "autoSuggFlag";

			if (className.contains("date"))
				fieldType = "datePickerFlag";

			// if (className.contains("btn")) fieldType = "buttonFlag";

			System.out.println("fieldType: " + fieldType);

			

			if (i > 1 && fieldType != null)
				if (ele.get(className) == null)
					ele.put(fieldType, 1);
				else
					ele.put(fieldType, i++);

		}
		return ele;

	}

	public int CheckWebElements(By by) {

		List<WebElement> listWebElementLabel = driver.findElements(by);

		System.out.println("found webelements: " + listWebElementLabel.size());

		return listWebElementLabel.size();

		

	}

	public int CheckWebElements(By by, String elementType) {

		List<WebElement> listWebElementLabel = driver.findElements(by);

		if (elementType == "button")
			listWebElementLabel = driver.findElements(by);

		System.out.println("found webelements: " + listWebElementLabel.size());

		return listWebElementLabel.size();

	}

	public Iterator<WebElement> CheckNextElement(int size, By byF) {

		if (size > 0) {
			List<WebElement> listWebElementField = driver.findElements(byF);
			System.out.println(listWebElementField.size());
			return listWebElementField.iterator();
		} else
			return null;

	}

	public Iterator<WebElement> CheckNextElement(By byF) {

		List<WebElement> listWebElementField = driver.findElements(byF);
		System.out.println(listWebElementField.size());
		if (listWebElementField.size() > 0) {
			return listWebElementField.iterator();
		} else
			return null;

	}

	public boolean checkPage(Iterator<WebElement> l, Iterator<WebElement> f, By byL, By byF, String pageType, String sheetName) {

		int i = 0;
		boolean flag = true;

		while (l.hasNext() && f.hasNext() && flag) {
			i++;

			if (pageType == "checkbox" && i == 1)
				flag = FillPage(l, f, i, pageType, sheetName);

			if (pageType != "checkbox")
				flag = FillPage(l, f, i, pageType, sheetName);
			else {
				f.next();
				l.next();
			}

		}
		return flag;

	}

	public void checkPage(Iterator<WebElement> f, By byF, String pageType) {

		int i = 0;

		while (f.hasNext()) {
			i++;

			FillPage(f, i, pageType);

		}

	}

	public boolean FillPage(Iterator<WebElement> l, Iterator<WebElement> f, int i, String pageType, String sheetName) {

		String FieldType, FieldValue = null, breakPoint = null;
		WebElement elementL = l.next();
		WebElement elementF = f.next();

		boolean flag = false;

		// String returnText =element.getAttribute("type").toString();

		String returnText = elementL.getText().toString();
		
		
		List<WebElement> labels = driver.findElements(By.cssSelector(".c-subheader-text.fs18.col-sm-12"));
		
		List<WebElement> buttons = driver.findElements(By.cssSelector("button[class='c-button-default circular single-select-btn  btn btn-default']"));
		
		
		if(buttons.size()<=2){		
			if (labels.size()==2) returnText = driver.findElement(By.xpath("//div[@class='questions-content-container']//child::*//following-sibling::*//div")).getText().toString();
		}

		System.out.println("returnText: " + returnText);

		int len = returnText.length();

		if (returnText.charAt(0) == '*' && len > 1)
			returnText = returnText.substring(len - (len - 1));

		// String value = Testutil.getFromXls("Questions", "Question",
		// returnText);
		
		String lines[] = returnText.split("\\r?\\n");
		
		if(lines.length>0) returnText = lines[0];
		
		
		
		String value = Testutil.getFromHashMap(inputData, returnText);
		System.out.println("value:" + value);

		boolean nullValue = Testutil.isNullOrEmpty(value);
		// boolean flag = Testutil.getOccuringChar(value, '_');

		if (!nullValue) {
			int len1 = value.length();
			if (len1 <= 2)
				flag = Testutil.getOccuringChar(value, '_');
		}

		if (value == "" || nullValue || flag) {

			

			FieldType = pageType;

			// t.next().click();
			System.out.println("i value: " + i + returnText);

		} else {
			String inputValues[] = value.split("_");

			

			if (inputValues.length > 2) {
				breakPoint = inputValues[2];
				System.out.println(inputValues[0] + "and" + inputValues[1] + "and" + inputValues[2]);
			}

			System.out.println(inputValues[0] + "and" + inputValues[1]);
			FieldType = inputValues[0];
			FieldValue = inputValues[1];

			nullValue = Testutil.isNullOrEmpty(breakPoint);

			if (!nullValue){
				
				String curr_URL = driver.getCurrentUrl();
				int row_num = xls.getCellRowNum(sheetName, "BreakPoint", breakPoint);
				xls.setCellData(sheetName, "URL", row_num, curr_URL);
				return false;
				
			}

			
			
			int count=0;

			//if (returnText.contains(Testutil.doubleButtos)) {
				
			if (pageType.contains("button")) {	

				count++;
				Testutil.doubleButtosFlag = true;

				try {

					if (FieldValue.contains("No"))
						elementF = driver.findElement(By.xpath("//div[contains(text(),'" + returnText
								+ "')]//following-sibling::*//div//button[contains(text(),'No')]"));
					else
						elementF = driver.findElement(By.xpath("//div[contains(text(),'" + returnText
								+ "')]//following-sibling::*//div//button[contains(text(),'Yes')]"));

				} catch (NoSuchElementException e) {
					System.out.println("multiple buttons in a page not found");
				}
				
				if (count>1) Testutil.doubleButtosFlag = false;

			}

			

			int len1 = FieldValue.length();

			if (FieldValue.contains("."))
				FieldValue = FieldValue.substring(0, len1 - 2);

		}

		FillData(elementF, FieldType, FieldValue);

		return true;

	}

	public void FillPage(Iterator<WebElement> f, int i, String pageType) {

		String FieldType, FieldValue = null;

		WebElement elementF = f.next();

		// String returnText =element.getAttribute("type").toString();
		String returnText = elementF.getText().toString();
		System.out.println("returnText: " + returnText);

		int len = returnText.length();

		if (returnText.charAt(0) == '*' && len > 1)
			returnText = returnText.substring(len - (len - 1));

		// String FieldValue = Testutil.getFromXls("Questions", "Question",
		// returnText);

		// t.next().click();
		System.out.println("i value: " + i + pageType);

		String value = Testutil.getFromHashMap(inputData, returnText);
		System.out.println("value:" + value);

		if (value == "" || value.contentEquals("_")) {

			if (returnText.isEmpty())
				returnText = pageType;

			// t.next().click();
			System.out.println("i value: " + i + returnText);

			FieldType = IdentifyWebElementType(elementF, returnText);

			// FieldType = IdentifyWebElementType(elementF, pageType);

		} else {
			String inputValues[] = value.split("_");

			// System.out.println(Testutil.getFromHashMap(inputData, "First
			// Name"));

			System.out.println(inputValues[0] + "and" + inputValues[1]);
			FieldType = inputValues[0];
			FieldValue = inputValues[1];

			// if(FieldValue == "Yes")

			int len1 = FieldValue.length();

			if (FieldValue.contains("."))
				FieldValue = FieldValue.substring(0, len1 - 2);

		}

		FillData(elementF, FieldType, FieldValue);

	}

	public String IdentifyWebElementType(WebElement elementL, String returnText) {

		String FieldType;
		switch (returnText) {

		case "*First Name":
		case "First Name":
			FieldType = "First Name";
			System.out.println("This is a text field WebElement " + returnText);
			break;

		case "*Phone (HOME/CELL)":
		case "Phone (WORK)":
			FieldType = "Phone";
			System.out.println("This is a text field WebElement " + returnText);
			break;
		case "*Zip":
		case "*ZIP":
		case "Zip":
		case "ZIP":
		case "*Annual Income":
		case "*What is your annual household income?":
			FieldType = "Number";
			System.out.println("This is a ZIP WebElement " + returnText);
			break;

		case "*Social Security #":
			FieldType = "SSN";
			System.out.println("This is a SSN WebElement " + returnText);
			break;
		case "*Driver's license #":
		case "Driver's license #":
			FieldType = "DL";
			System.out.println("This is a SSN WebElement " + returnText);
			break;
		case "City":
			FieldType = "Text";
			System.out.println("This is a City WebElement " + returnText);
			break;
		case "checkbox":
			FieldType = "Checkbox";
			System.out.println("This is a Checkbox WebElement " + returnText);
			break;
		case "button":
			FieldType = "Button";
			System.out.println("This is a Button WebElement " + returnText);
			break;
		case "dropdown":
			FieldType = "Dropdown";
			System.out.println("This is a Dropdown WebElement " + returnText);
			break;
		case "autoSugg":
		case "AutoSugg":
			FieldType = "AutoSugg";
			System.out.println("This is a Dropdown WebElement " + returnText);
			break;
		case "datepicker":
			FieldType = "DatePicker";
			System.out.println("This is a Dropdown WebElement " + returnText);
			break;

		default:
			FieldType = "Text";
			System.out.println("This is a default  WebElement " + returnText);
			break;

		}
		return FieldType;
	}

	public void FillData(WebElement elementF, String FieldType, String FieldValue) {

		boolean nullValue = Testutil.isNullOrEmpty(FieldValue);
		// String iFieldType = FieldType.compareToIgnoreCase(str);
		switch (FieldType) {
		case "Text":
		case "text":

			// elementF.sendKeys("999");
			if (nullValue)
				elementF.sendKeys("99");
			else
				elementF.sendKeys(FieldValue);
			System.out.println("typed number");

			break;

		case "First Name":
			// elementF.sendKeys("12345");
			if (nullValue)
				elementF.sendKeys("12345");
			else
				elementF.sendKeys(FieldValue);
			break;
		case "Phone":
			if (EnterInputData(elementF, "9999999999")) {
				System.out.println("typed text");
				// elementF.sendKeys("text");
				if (nullValue)
					elementF.sendKeys("ab");
				else
					elementF.sendKeys(FieldValue);
			}

			break;
		case "Number":
			// elementF.sendKeys("12345");
			if (nullValue)
				elementF.sendKeys("12345");
			else
				elementF.sendKeys(FieldValue);

			break;
		case "SSN":
			// elementF.sendKeys("222222222");
			if (nullValue)
				elementF.sendKeys("222222222");
			else
				elementF.sendKeys(FieldValue);
			break;
		case "DL":
			// elementF.sendKeys("753475837");
			if (nullValue)
				elementF.sendKeys("111111111");
			else
				elementF.sendKeys(FieldValue);
			break;

		case "Dropdown":
		case "DropDown":
		case "dropdown":
			dropdown.click();
			// stateValue.sendKeys("Alabama (AL)");
			Testutil.staticWait();

			if (nullValue) {

				// By byXpath = By.xpath("//div[@role='combobox']");

				Actions act = new Actions(driver);// driver variable is chrome
													// web driver ref

				WebElement selectInput = driver.findElement(By.className("Select-input"));// Thread.sleep(5000);

				act.click(selectInput).build().perform();// Thread.sleep(5000);

				// list of all option
				List<WebElement> selectValues = driver.findElements(By.className("Select-option"));// Thread.sleep(5000);

				// first option:
				WebElement firstWebElement = selectValues.get(0);// Thread.sleep(5000);

				act.click(firstWebElement).build().perform();// Thread.sleep(5000);

			} else {

				stateValue.sendKeys(FieldValue);
				selectItem.click();
			}

			break;
		case "Checkbox":
		case "checkbox":
			System.out.println("Check box clicked");
			elementF.click();
			break;
		case "Button":
		case "button":
			System.out.println("Button clicked");

			List<WebElement> listWebElementLabel = driver.findElements(By.xpath("//button[contains(text(),'No')]"));

			System.out.println("found webelements: " + listWebElementLabel.size());

			if (listWebElementLabel.size() > 1) {
				if (nullValue) {
					noButton.click();
				} else {
					if (FieldValue.contains("Yes"))
						elementF.click();
					else
						elementF.click();
						//noButton.click();
				}
			} else {
				if (nullValue) {
					noButton.click();
				} else {
					if (FieldValue.contains("Yes"))
						yesButton.click();
					else
						noButton.click();
				}
			}
			// elementF.click();
			break;
		case "MultiSelection":
			break;
		case "AutoSugg":
		case "autoSugg":
			autoSugg.click();
			if (nullValue)
				elementF.sendKeys("ab");
			else
				elementF.sendKeys(FieldValue);

			Testutil.staticWait();
			By byXpath = By.xpath("//ul[@class='dropdown-menu']");
			// selectAutoSugg.click();
			// driver.findElement(By.xpath("//ul[@class='dropdown-menu']//li[1]//a//div")).click();
			// driver.findElement(By.xpath("//ul[@class='dropdown-menu']//li[1]//a//div")).submit();
			selectOptionWithIndex(byXpath, "li", 1);

			break;
		case "DatePicker":
		case "datepicker":
			// DOB.sendKeys("03/12/1979");
			if (nullValue)
				DOB.sendKeys("03/12/1979");
			else
				DOB.sendKeys(FieldValue);
			dateSelect.click();
			break;

		default:
			if (EnterInputData(elementF, "text")) {
				// elementF.sendKeys("999");
				if (nullValue)
					elementF.sendKeys("999");
				else
					elementF.sendKeys(FieldValue);
				System.out.println("typed number");
			}

			break;

		}

	}

	public boolean EnterInputData(WebElement ele, String text) {

		boolean returnType;
		ele.sendKeys(text);

		// Retrieve typed value
		String typedValue = ele.getAttribute("value");

		// Get the length of typed value
		int size = typedValue.length();

		if (size == 0) {
			System.out.println("Alphabets are not allowed.");
			returnType = true;
		} else
			returnType = false;

		return returnType;

	}

	public void selectOptionWithIndex(By byXpath, String tagName, int indexToSelect) {

		try {
			// WebElement autoOptions =
			// driver.findElement(By.xpath("//ul[@class='dropdown-menu']"));
			WebElement autoOptions = driver.findElement(byXpath);
			// wait.until(ExpectedConditions.visibilityOf(autoOptions));

			List<WebElement> optionsToSelect = autoOptions.findElements(By.tagName(tagName));
			// List<WebElement> optionsToSelect =
			// autoOptions.findElements(By.tagName("li"));
			System.out.println("size: " + optionsToSelect.size());
			if (indexToSelect <= optionsToSelect.size()) {
				System.out.println("Trying to select based on index: " + indexToSelect);
				optionsToSelect.get(indexToSelect).click();
			}
		} catch (NoSuchElementException e) {
			System.out.println(e.getStackTrace());
			System.out.println("element not found");
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
			System.out.println("other exception");
		}
	}

	public void CheckElementExists(String css, boolean flag) {

		// boolean present = true;

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
				flag = false;
			} catch (NoSuchElementException e) {
				flag = true;
			}

		}

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

	public HashMap<String, Integer> childElements() {

		String fieldType = null;
		// WebElement dropdown = driver(or your parent locator of
		// ul).findElement(By.tagName("ul"));

		By elementsCount = By.cssSelector(".questions-content-container");
		WebElement divElement = driver.findElement(elementsCount);
		HashMap<String, Integer> ele = new HashMap<String, Integer>();

		// List<WebElement> listWebElementLabel =
		// driver.findElement(elementsCount);

		List<WebElement> options = divElement.findElements(By.tagName("div"));
		System.out.println(options);
		int i = 0;
		for (WebElement option : options) {
			/*
			 * if (option.getText().equali=0s(searchText)) { option.click(); //
			 * click the desired option
			 * 
			 * }
			 */

			fieldType = null;
			String className = null;

			className = option.getAttribute("class").toString();

			System.out.println(option.getAttribute("class").toString());

			if (className.contains("form-group"))
				fieldType = "formFlag";

			if (className.contains("c-custom-select"))
				fieldType = "dropDownFlag";

			if (className.contains("btn"))
				fieldType = "buttonFlag";

			if (className.contains("auto"))
				fieldType = "autoSuggFlag";

			if (className.contains("date"))
				fieldType = "datePickerFlag";

			if (className.contains("btn"))
				fieldType = "buttonFlag";

			System.out.println(fieldType);

			i++;
			if (fieldType != null)
				if (ele.get(className) == null)
					ele.put(fieldType, 1);
				else
					ele.put(fieldType, i++);

		}
		return ele;
	}

	public boolean clientTypeFlow(int rowNum, String clientType, String signType, String paymentType){
		
		boolean returnFlag = false;

		switch (clientType) {

		case "customer":
			System.out.println("clicked esign and submit");
			driver.findElement(By.cssSelector("div > button")).click();
			ProductUtil.CheckElementDoNotExists(".fa.fa-circle-o-notch", true);
			
			signDoc(rowNum, "Customer Application PDF");
			
			Testutil.updateResult(Testutil.resultSheet, "Customer Application PDF", rowNum, "Pass");
			
			String msg="Thank you! Your application has been submitted, we will be in touch with you shortly.";
			
			if(ProductUtil.msgExist(rowNum, By.xpath("//*[contains(text(), '"+ msg +"')]"), msg)) {
				returnFlag = false;
				break;
			}
			
			Testutil.staticLongWait();
			
			paymentTypeFlow(rowNum, paymentType);
			
			Testutil.staticLongWait();
			
			signDoc(rowNum, "Customer Payment form signature");
			Testutil.updateResult(Testutil.resultSheet, "Customer Payment form signature", rowNum, "Pass");
			
			Testutil.staticLongWait();
			
			returnFlag= signTypeFlow(rowNum, signType, paymentType);
			
			
			break;
		
		case "agent":
			
			ProcessFields(rowNum, "agent", 1, "agent", signType, paymentType);
			
			signatureType.sendKeys(signType);
			selectItem.click();
			
			
			
			agentWebHomePage.agentPanel();
			
			signDoc(rowNum, "Agent Application PDF");
			
			Testutil.updateResult(Testutil.resultSheet, "Agent Application PDF", rowNum, "Pass");
			
			Testutil.staticLongWait();			
			
			//agentWebHomePage.flowType(signType, paymentType, "");
			driver.quit();
			signTypeFlow(rowNum, signType, paymentType);
			
			
			
			
			
			returnFlag = true;
			break;
			
		default:
			break;
			
		}
		
		return returnFlag;
		
		

		
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
			
			paymentTypeFlow(rowNum, paymentType);
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

    public boolean makePayment(int rowNum, String paymentType) {
    	
    	String currentURL ="";
		
		//AgentWebHomeTest agentWebHomeTest;
    	//agentWebHomeTest = new AgentWebHomeTest();
    	boolean returnFlag = false;
		
		try{
    	
	    	
	    	//agentWebHomeTest.validateQuotationsnEApplications();
	
			driver.findElement(By.xpath("//a[contains(text(),'Make payment')]")).click();
			Testutil.staticLongWait();
	
			paymentTypeFlow(rowNum, paymentType);
			Testutil.staticLongWait();
			driver.quit();
			EmailSign(rowNum, "SIGN PAYMENT FORM", "Thank you! Your application has been submitted, we will be in touch with you shortly.", "Customer Payment form signature");
			//agentWebHomeTest.validateQuotationsnEApplications();
			/*ProductUtil.clickButton("Continue to Customer Signature");
			Testutil.staticLongWait();
			signDoc();
			Testutil.staticLongWait();*/
	
			driver.findElement(By.xpath("//a[contains(text(),'Sign TIA')]")).click();
			Testutil.staticLongWait();
			signDoc(rowNum, "Agent Payment form signature");
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



