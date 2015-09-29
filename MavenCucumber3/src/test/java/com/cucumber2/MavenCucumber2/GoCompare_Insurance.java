package com.cucumber2.MavenCucumber2;
import org.openqa.selenium.*;
//import org.openqa.selenium.chrome.ChromeDriver;

public class GoCompare_Insurance {
	
	
	static WebElement element;
	static WebDriver e;
	String text;
	
	
	 public static WebElement Select_Insurance_Type(String Insurance_Type){
		 try {
			Thread.sleep(5000);
			element = e.findElement(By.xpath(Insurance_Type));
		} catch (InterruptedException e1) {
			
			e1.printStackTrace();
		}
		
		 return element;
	 }

}
