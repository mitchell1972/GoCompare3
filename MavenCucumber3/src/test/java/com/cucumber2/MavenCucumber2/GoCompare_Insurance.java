package com.cucumber2.MavenCucumber2;
import org.openqa.selenium.*;
//import org.openqa.selenium.chrome.ChromeDriver;

public class GoCompare_Insurance {
	
	
	static WebElement element;
	static WebDriver e;
	String text;
	
	
	 public static WebElement Select_Insurance_Type(String Insurance_Type){
		element = e.findElement(By.xpath(Insurance_Type));
		 return element;
	 }

}
