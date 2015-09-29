package com.cucumber2.MavenCucumber2;
import org.openqa.selenium.*;
//import org.openqa.selenium.chrome.ChromeDriver;

public class GoCompare_Insurance {
	
	WebDriver e;
	String text;
	
	
	 public void Select_Insurance_Type(String Insurance_Type){
		 try {
			Thread.sleep(5000);
			e.findElement(By.xpath(Insurance_Type)).click();
		} catch (InterruptedException e1) {
			
			e1.printStackTrace();
		}
		
		
	 }

}
