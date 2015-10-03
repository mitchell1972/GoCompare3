package com.cucumber2.MavenCucumber2;

//import java.util.concurrent.TimeUnit;

//import junit.framework.*;

import org.junit.Assert;






import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.htmlunit.HtmlUnitDriver;
//import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.apache.log4j.*;

import java.io.*;

//import java.util.*;
//import org.apache.*;
import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;





import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.model.Log;




//import java.sql.*;
import java.util.logging.Logger;

import junit.framework.Test;

//import oracle.jdbc.pool.OracleDataSource;




public class GoCompareStepDef {
	
	static WebDriver driver;
	static WebElement Insurance_elements;
	static WebElement Motorbike_Insurance_element;
	static WebElement Car_Insurance_Page;
	static WebElement Car_Insurance;
	static WebElement Motorbike_Insurance_Page;
	static WebElement getQuotesButton;
	static WebElement firstNameField;
	static WebElement secondNameField;
	static WebElement dayOfBirth;
	static WebElement monthOfBirth;
	static WebElement yearOfBirth;
	static WebElement emailAddress;
	static WebElement confirmEmailAddress;
	static WebElement continueButton;
	static WebElement Motorbike_insurance_comparison_service;
	static XSSFCell Cell;
	static XSSFRow Row;
	static  XSSFWorkbook workbook;
	static XSSFSheet sheet;
	String cellData;
	String testResult;
	String host = "jdbc:microsoft:sqlserver://localhost:1433";
	String userName = "Mitchell-PC";
	String password = "mitchell1972";
	String url = "jdbc:sqlserver://localhost:1433";
	String dbName = "JavaDatabase";
	boolean integratedSecurity = true;
	static Logger logger;
	static Logger log;
	static String change;
	static String change2;
	static String change3;
	static String change4;
	static String change5;
	static String change6;
	static ExtentReports report;
	static ExtentTest testlogger;
	
	
	
	//GoCompareStepDef motorbike_Page;
	static String dataFile = "H:\\GoCompareDataSheet.xlsx"; 
	@Before
	//@org.junit.Before
	public void openBrowser(){
		System.setProperty("webdriver.chrome.driver","C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
		driver = new ChromeDriver();
		//driver.get("http://www.gocompare.com");
		driver.get(this.readExcelFile(3, 1));
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		logger = Logger.getLogger(Test.class.getName());
		logger.info(System.getProperty("java.library.path"));
		 report = new ExtentReports("H:\\Reports\\GoCompareTestLogs.html",false);
		 testlogger = report.startTest("TestGoCompare");
		testlogger.log(LogStatus.INFO, "Go Compare Browser Opened and Maximised");
		
		try {
			Thread.sleep(9000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//motorbike_Page = new GoCompareStepDef();
	}
	
	
	public String readExcelFile(int rowIndex, int columnIndex){
		try {
			FileInputStream file = new FileInputStream(dataFile);
			//create workbook instance
			 workbook = new XSSFWorkbook(file);
			 
			 //Get the desired worksheet
			 sheet = workbook.getSheet("Data");
			 Cell = sheet.getRow(rowIndex).getCell(columnIndex);
			 cellData = Cell.getStringCellValue();
			 //iterate through each row 
			 file.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cellData;
		
	}
	
	public void recordResult(String result,int rowIndex,int columnIndex){
		try {
			FileInputStream file = new FileInputStream(new File(dataFile));
			//create workbook instance
			 workbook = new XSSFWorkbook(file);
			sheet = workbook.getSheet("Data");
			
			Cell sheetCell = sheet.getRow(rowIndex).createCell(columnIndex);
			
			sheetCell.setCellValue(result);
			file.close();
            FileOutputStream fl = new FileOutputStream(new File(dataFile));
			workbook.write(fl);
			
			fl.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.testResult = result;
	}
	
	/*
	public void ReadDatabase(){
		
		try {

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			
			Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=JavaDatabase;integratedSecurity=true");
			
			if(con != null ){
				System.out.println("Connected");
			}
			String query ="select * from GoCompare";
			Statement stmt = null;
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()){
			String car_insurance = rs.getString("CarInsurance");
			//String motor_insurance = rs.getString("MotorBikeInsurance");
			System.out.println(car_insurance);
			
			//con.close();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	*/
	/*
	public void readOracleDB(){
		String oracle_url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user_name = "system";
		String password = "mitchell";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(oracle_url,user_name,password);
			if (con!=null){
				System.out.println("Connected to ORacle_DB");
			}
			String query = "Select * from GOCOMPARE";
			Statement st = null;
			st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while(rs.next()){
			String carInsurance = rs.getString("CARINSURANCE");
			String motorInsurance = rs.getString("MOTORBIKEINSURANCE");
			String vanInsurance = rs.getString("VANINSURANCE");
			String homeInsurance = rs.getString("HOMEINSURANCE");
			String breakdown = rs.getString("BREAKDOWNCOVER");
			String caravan = rs.getString("CARAVANINSURANCE");
			System.out.println(carInsurance);
			System.out.println(motorInsurance);
			System.out.println(vanInsurance);
			System.out.println(homeInsurance);
			System.out.println(breakdown);
			System.out.println(caravan);
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	*/
	
	@After
	//@org.junit.After 
	
	public void closeBrowser(){
		driver.manage().deleteAllCookies();
		driver.close();
		
	}
	
	@Given("^I'm hovering over the Insurance menu$")
	public void i_m_hovering_over_the_Insurance_menu(){
		try
		{
		System.out.println("Print Given");
		Thread.sleep(1000);
    	Insurance_elements = driver.findElement(By.className("menu_1"));
		Actions action = new Actions(driver);
		action.moveToElement(Insurance_elements).build().perform();
		
		}
		catch(Exception e){}
	}

	@Given("^the various insurance types are displayed$")
	public void the_various_insurance_types_are_displayed() {
		
		System.out.println("Print Given2");
	  
		Insurance_elements = driver.findElement(By.xpath("//*[@id='navigationContainer']/ul/li[2]/div/ul[1]/li[2]/a"));
		Motorbike_Insurance_element = driver.findElement(By.xpath("//*[@id='navigationContainer']/ul/li[2]/div/ul[1]/li[3]/a"));
	  
	    Assert.assertTrue(Insurance_elements.isDisplayed());
	    Assert.assertTrue(Motorbike_Insurance_element.isDisplayed());
	    //this.ReadDatabase();
	}
	

	@When("^I click on Car Insurance$")
	public void i_click_on_Car_Insurance() throws InterruptedException {
		Thread.sleep(1000);
		
		Car_Insurance = driver.findElement(By.xpath("//*[@id='navigationContainer']/ul/li[2]/div/ul[1]/li[2]/a"));
		
	    GoCompare_Insurance.Select_Insurance_Type(Car_Insurance);	
		
		//driver.findElement(By.xpath("//*[@id='navigationContainer']/ul/li[2]/div/ul[1]/li[2]/a")).click();  
		//this.readOracleDB();
	}

	@Then("^the Car insurance page is displayed$")
	public void the_Car_insurance_page_is_displayed() {
		
		 //Car_Insurance_Page = driver.findElement(By.xpath("//*[@id='ctl00_ctl00_phBody_ucHeroContainer_ctl00_headerDiv']/div[1]/div"));
		 
		 try {
			
			Thread.sleep(3000);
			 Car_Insurance_Page = driver.findElement(By.xpath("//*[@id='ctl00_ctl00_phBody_ucHeroContainer_ctl00_headerDiv']/div[1]/div"));
			 Assert.assertTrue(Car_Insurance_Page.getText().toString().contains("Compare quotes from over 120 insurance brands")); 
			 System.out.println(Car_Insurance_Page.getText().toString());
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	
	
	@When("^I click on Motorbike Insurance$")
	public void i_click_on_Motorbike_Insurance() throws InterruptedException {
		Thread.sleep(10000);
		Motorbike_Insurance_element.click();
	    // Write code here that turns the phrase above into concrete actions
	    
	}
	
	@Then("^the Motorbike insurance page is displayed$")
	public void the_Motorbike_insurance_page_is_displayed(){
	   
		//Motorbike_Insurance_Page = driver.findElement(By.xpath("//*[@id='ctl00_ctl00_phBody_ucHeroContainer_ctl00_headerDiv']/div[1]/div"));
		
		try {
			Thread.sleep(3000);
			Motorbike_Insurance_Page = driver.findElement(By.xpath("//*[@id='ctl00_ctl00_phBody_ucHeroContainer_ctl00_headerDiv']/div[1]/div"));
			Assert.assertTrue(Motorbike_Insurance_Page.getText().toString().contains("Compare bike insurance quotes from multiple insurance brands"));
			 System.out.println(Motorbike_Insurance_Page.getText().toString());
			
		 
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	
	@Given("^I'm on the motorbike Insurance Page$")
	public void i_m_on_the_motorbike_Insurance_Page() {
	   try {
		Thread.sleep(3000);
		Insurance_elements = driver.findElement(By.className("menu_1"));
		Actions action = new Actions(driver);
		action.moveToElement(Insurance_elements).build().perform();
		Motorbike_Insurance_element = driver.findElement(By.xpath("//*[@id='navigationContainer']/ul/li[2]/div/ul[1]/li[3]/a"));
		Motorbike_Insurance_element.click();
	} catch (InterruptedException e) {
		
		e.printStackTrace();
	}   
	   
	   
	}


	@Given("^the Get Quotes button is visible$")
	public void the_Get_Quotes_button_is_visible() {
		 try{
		Thread.sleep(3000);
		getQuotesButton = driver.findElement(By.xpath("//*[@id='ctl00_ctl00_phBody_ucHeroContainer_ctl00_headerDiv']/div[1]/div/span[2]/a[1]/img"));
	
		Assert.assertTrue(getQuotesButton.isEnabled());
	
		 }
		 catch(Exception e){
			 e.printStackTrace();
		 }
	   
	}

	@When("^I click on the Get Quotes Button$")
	public void i_click_on_the_Get_Quotes_Button() {
		try {
			Thread.sleep(3000);
			getQuotesButton = driver.findElement(By.className("get_quotes"));
			 
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		 getQuotesButton.click();
	    
	}

	@Then("^the start a new quote page is displayed$")
	public void the_start_a_new_quote_page_is_displayed() {
	try {
		Thread.sleep(3000);
		   firstNameField = driver.findElement(By.id("Customer_FirstName"));
		   secondNameField = driver.findElement(By.id("Customer_Surname"));
		   
	} catch (InterruptedException e) {
		
		e.printStackTrace();
	}	
   
   Assert.assertTrue(firstNameField.isEnabled());
   Assert.assertTrue(secondNameField.isEnabled());

	   
	}

	@Given("^I'm on the motorbike insurance comparison service page$")
	public void i_m_on_the_motorbike_insurance_comparison_service_page() {
		Insurance_elements = driver.findElement(By.className("menu_1"));
		Actions action = new Actions(driver);
		action.moveToElement(Insurance_elements).build().perform();
		Motorbike_Insurance_element = driver.findElement(By.xpath("//*[@id='navigationContainer']/ul/li[2]/div/ul[1]/li[3]/a"));
		Motorbike_Insurance_element.click();
		
		try {
			Thread.sleep(4000);
			getQuotesButton = driver.findElement(By.className("get_quotes"));
			getQuotesButton.click();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		
	}

	@Given("^the FirstName, Surname, DateOfBirth and EmailAddress fields are displayed$")
	public void the_FirstName_Surname_DateOfBirth_and_EmailAddress_fields_are_displayed() {
		try {
			Thread.sleep(3000);
			   firstNameField = driver.findElement(By.id("Customer_FirstName"));
			   secondNameField = driver.findElement(By.id("Customer_Surname"));
			   
			   dayOfBirth = driver.findElement(By.id("Customer_DateOfBirth_Day"));
			   monthOfBirth = driver.findElement(By.id("Customer_DateOfBirth_Month"));
			   yearOfBirth = driver.findElement(By.id("Customer_DateOfBirth_Year"));
			   
			   emailAddress = driver.findElement(By.id("Customer_Email"));
			   confirmEmailAddress = driver.findElement(By.id("Customer_EmailConfirmation"));
			   
			   continueButton =  driver.findElement(By.xpath("//*[@id='form0']/div[4]/div[1]/input"));
			   
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}	
	   
	   Assert.assertTrue(firstNameField.isEnabled());
	   Assert.assertTrue(secondNameField.isEnabled());
	   Assert.assertTrue(dayOfBirth.isEnabled());
	   Assert.assertTrue(monthOfBirth.isEnabled());
	   Assert.assertTrue(yearOfBirth.isEnabled());
	   Assert.assertTrue(continueButton.isEnabled());
	}

	@When("^I enter the correct details$")
	public void i_enter_the_correct_details(){
	    
		firstNameField = driver.findElement(By.id("Customer_FirstName"));
		firstNameField.sendKeys("Jonathan");
		
		secondNameField = driver.findElement(By.id("Customer_Surname"));
		secondNameField.sendKeys("Johnson");
		
		dayOfBirth = driver.findElement(By.id("Customer_DateOfBirth_Day"));
		dayOfBirth.sendKeys(this.readExcelFile(0, 1));
		
		monthOfBirth = driver.findElement(By.id("Customer_DateOfBirth_Month"));
		monthOfBirth.sendKeys(this.readExcelFile(1, 1));
		
		yearOfBirth = driver.findElement(By.id("Customer_DateOfBirth_Year"));
		yearOfBirth.sendKeys(this.readExcelFile(2, 1));
		
		emailAddress = driver.findElement(By.id("Customer_Email"));
		emailAddress.sendKeys("johnjames@gmail.com");
		
		confirmEmailAddress = driver.findElement(By.id("Customer_EmailConfirmation"));
		confirmEmailAddress.sendKeys("johnjames@gmail.com");
		
	}

	@When("^click on the Continue button$")
	public void click_on_the_Continue_button(){
	   driver.findElement(By.xpath("//*[@id='form0']/div[4]/div[1]/input")).click();
	   
	}

	@Then("^the Personal details page for the name entered is displayed$")
	public void the_Personal_details_page_for_the_name_entered_is_displayed() throws Exception {
		Thread.sleep(5000);
		Motorbike_insurance_comparison_service = driver.findElement(By.id("ctl00_lblHeaderText"));
		
	   Assert.assertTrue(Motorbike_insurance_comparison_service.isEnabled());
	   
	   if(Motorbike_insurance_comparison_service.isEnabled()){
		   
		   this.recordResult("Pass", 0, 2);
	   }
	
	}



}
