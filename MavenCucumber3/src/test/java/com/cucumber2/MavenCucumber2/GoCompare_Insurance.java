package com.cucumber2.MavenCucumber2;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoCompare_Insurance {
	
	
	WebElement element;
	WebDriver e;
	String text;
	
	
	 public WebElement Select_Insurance_Type(String Insurance_Type){
		element = e.findElement(By.xpath(Insurance_Type));
		 return element;
	 }

}
