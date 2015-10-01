package com.cucumber2.MavenCucumber2;
import org.openqa.selenium.*;
//import org.openqa.selenium.chrome.ChromeDriver;

public class GoCompare_Insurance {
	
	static WebDriver e;
	static WebElement ex;
	static String test;
	
	 public static void Select_Insurance_Type(String Insurance_Type){
		 try {
			 test = Insurance_Type;
			ex = e.findElement(By.xpath(test));
			System.out.println("Element is: " + ex.getText());
			ex.click();
			
		} catch (Exception e1) {
			
			e1.printStackTrace();
		}
		
		
	 }

}
