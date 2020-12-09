package com.lco.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.formula.functions.Rows;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.lco.qa.base.TestBase;
import com.lco.qa.pages.AgentWebLoginPage;

public class Testutil extends TestBase {

	public static long pageLoadTimeout = 240;
	public static long implicitlyWait = 10;
	public static long waitTime = 2000;
	static final int MAX_CHAR = 256;	
	//public static WebDriverWait wait = new WebDriverWait(driver, 15*Testutil.waitTime);

	// public static String TESTDATA_SHEET_PATH =
	// "C:\\Users\\akkyu01\\eclipse-workspace\\JavaTraining\\Sureify\\src\\main\\java\\com\\lco\\qa\\testdata\\LCO_TestData.xlsx";
	//public static String TESTDATA_SHEET_PATH = "/home/yugandher/git/ApplyandBuyAutomation/src/main/java/com/lco/qa/testdata/LCO_TestData.xlsx";
	public static String TESTDATA_SHEET_PATH = "/home/yugander/Downloads/git/ApplyandBuyAutomation/src/main/java/com/lco/qa/testdata/Input_Data.xlsx";
	//public static String TESTDATA_SHEET_PATH = "/usr/share/tag/testdata/Input_Data.xlsx";
	public static String email_ID = "yugandher@sureify.com";
	
	public static String resultSheet = "Result";

	public static boolean doubleButtosFlag = false;
	public static String doubleButtos = "Is the Proposed Insured currently confined to a hospital, nursing home, psychiatric facility or currently receiving home health care/assisted living care?";

	static Workbook book;
	static Sheet sheet;

	static XSSFCell Cell;

	static XSSFRow Row;

	public static Object[] getTestData(String sheetName) {

		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[] data = new Object[sheet.getLastRowNum()];

		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i] = sheet.getRow(i + 1).getCell(k).toString();
				System.out.println(data[i]);
			}
		}
		return data;

	}

	public static Object[][] getTableArray(String FilePath, String SheetName, int rowsCount, int colsCount, int startRow, int startCol) throws Exception {

		String[][] tabArray = null;
		Xlsutil xl = new Xlsutil(TESTDATA_SHEET_PATH, SheetName);

		//int startRow = 2;

		//int startCol = 1;

		int ci, cj;

		// int totalRows = sheet.getLastRowNum();

		//int totalRows = xl.getRowCount(SheetName);
		
		int totalRows = rowsCount;

		// you can write a function as well to get Column count

		// int totalCols = 3;

		//int totalCols = xl.getColumnCount(SheetName);
		
		int totalCols = colsCount;

		// int totalCols = sheet.getCol

		// tabArray = new String[totalCols][totalRows-1];
		tabArray = new String[totalRows - 1][totalCols];

		ci = 0;

		for (int i = startRow; i <=totalRows; i++, ci++) {

			cj = 0;

			for (int j = startCol; j <= totalCols; j++, cj++) {

				// tabArray[ci][cj] = getCellData(i, j);

				tabArray[ci][cj] = xl.getCellData(SheetName, j - 1, i);

				//System.out.println(tabArray[ci][cj]);

			}

		}

		return (tabArray);

	}

	public static String getCellData(int RowNum, int ColNum) throws Exception {

		try {

			Cell = (XSSFCell) sheet.getRow(RowNum).getCell(ColNum);

			int dataType = Cell.getCellType();

			if (dataType == 3) {

				return "";

			} else {

				// String CellData = Cell.getStringCellValue();

				String CellData = Cell.getRawValue();

				return CellData;

			}
		} catch (Exception e) {

			System.out.println(e.getMessage());

			throw (e);

		}

	}

	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");

		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));

	}

	public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		// after execution, you could see a folder "FailedTestsScreenshots"
		// under src folder
		String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/" + screenshotName + dateName
				+ ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}

	public static String getFromXls(String sheetName, String colName, String cellValue) {

		Xlsutil xl = new Xlsutil(TESTDATA_SHEET_PATH, sheetName);
		int rowNum = xl.getCellRowNum(sheetName, colName, cellValue);
		int colNum = 3;

		return xl.getCellData(sheetName, colNum, rowNum);
	}

	public static String getFromHashMap(HashMap<String, String> inputData, String key) {

		return inputData.get(key);

	}

	public static boolean isNullOrEmpty(String str) {
		if (str != null && !str.isEmpty())
			return false;

		return true;
	}

	public static boolean getOccuringChar(String str, char c) {
		// Create an array of size 256 i.e. ASCII_SIZE
		int count[] = new int[MAX_CHAR];
		boolean flag = false;

		int len = str.length();

		// Initialize count array index
		for (int i = 0; i < len; i++)
			count[str.charAt(i)]++;

		// Create an array of given String size
		char ch[] = new char[str.length()];
		for (int i = 0; i < len; i++) {
			ch[i] = str.charAt(i);
			int find = 0;
			for (int j = 0; j <= i; j++) {

				// If any matches found
				if (str.charAt(i) == ch[j])
					find++;
			}

			if (find == 1)
				System.out.println("Number of Occurrence of " + str.charAt(i) + " is:" + count[str.charAt(i)]);

			if (find == 1 && str.charAt(i) == c && count[str.charAt(i)] == len) {
				flag = true;
				break;
			} else
				flag = false;

		}
		return flag;

	}

	public static void staticWait() {
		try {
			Thread.sleep(Testutil.waitTime);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void staticLongWait(By by) {
		try {
			
			TestBase.wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			Assert.assertNotNull(driver.findElement(by));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void WaitnClick(By by) {
		try {
			
			TestBase.wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			Assert.assertNotNull(driver.findElement(by));
			driver.findElement(by).click();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void staticLongWait() {
		try {
			
			Thread.sleep(15*Testutil.waitTime);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void selectFromDropdown(int item){
		Actions act = new Actions(driver);// driver variable is chrome
		// web driver ref

		WebElement selectInput = driver.findElement(By.className("Select-input"));// Thread.sleep(5000);
		
		act.click(selectInput).build().perform();// Thread.sleep(5000);
		
		// list of all option
		List<WebElement> selectValues = driver.findElements(By.className("Select-option"));// Thread.sleep(5000);
		
		staticWait();
		
		int index = selectValues.indexOf(item);
		
		// first option:
		WebElement firstWebElement = selectValues.get(index);// Thread.sleep(5000);
		
		
		
		act.click(firstWebElement).build().perform();// Thread.sleep(5000);
	}
	
	public static void loginGmail(){
		
		url = prop.getProperty("gmail_url");
		initialization();
		WebElement email_phone = driver.findElement(By.xpath("//input[@id='identifierId']"));
		String gmail_uid = prop.getProperty("gmail_uid");
		String gmail_pwd = prop.getProperty("gmail_pwd");
		email_phone.sendKeys(gmail_uid);
		driver.findElement(By.id("identifierNext")).click();
		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		//WebDriverWait wait = new WebDriverWait(driver, 10*Testutil.waitTime);
		TestBase.wait.until(ExpectedConditions.elementToBeClickable(password));
		password.sendKeys(gmail_pwd);
		driver.findElement(By.id("passwordNext")).click();
		
		// some optional actions for reaching gmail inbox
		driver.findElement(By.xpath("//a[@aria-label='Google apps']")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Gmail')]")).click();
		
		
	}
	
	public static void openVeryFirstEmail(){
		List<WebElement> a = driver.findElements(By.xpath("//*[@class='yW']/span"));
        System.out.println(a.size());
        a.get(0).click();
        /*for (int i = 0; i < a.size(); i++) {
            System.out.println(a.get(i).getText());
            if (a.get(i).getText().equals(from)) //to click on a specific mail.
                {                                           
                a.get(i).click();
            }
        }*/
	}
	
	public static void findElements(By by){
		
	
		List<WebElement> arrows = driver.findElements(by);
				
		boolean arrowFlag = true;
		boolean returnFlag = false;
		Testutil.staticLongWait(by); 

		System.out.println("arrows webelements found: " + arrows.size());

		Iterator<WebElement> webele = arrows.iterator();

		// webele.next();

		WebElement arrowEle = null;

		while(webele.hasNext()) {
			arrowEle = webele.next();

			while (arrowFlag) {
				
				try{
					System.out.println("trying to click the element");
					if (arrowEle.isDisplayed()) {
						arrowEle.click();
						System.out.println("clicked the element");
						arrowFlag = false;
						
						
						Testutil.staticWait();
						
					} else {
						System.out.println("the element is not displayed");
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
		
	}
	
	public static void loginAgentPanel(){
	
	
		AgentWebLoginPage agentWebPage;
		agentWebPage = new AgentWebLoginPage();
		url = prop.getProperty("agent_url");
		initialization();
		agentWebPage.agentWebLogin(prop.getProperty("username"), prop.getProperty("password"));		
		driver.findElement(By.xpath("//img[@alt='Quotations/E-Applications']")).click();
		
	
	}

	public static void updateResult(String sheetName, String colName, int rowNum, String cellValue){
		
		Xlsutil xl = new Xlsutil(TESTDATA_SHEET_PATH, sheetName);		
		xl.setCellData(sheetName, colName, rowNum, cellValue);
		
	}
}