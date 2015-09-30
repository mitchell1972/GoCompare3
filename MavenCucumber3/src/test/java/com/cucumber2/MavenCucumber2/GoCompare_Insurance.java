package com.cucumber2.MavenCucumber2;
import org.openqa.selenium.*;
//import org.openqa.selenium.chrome.ChromeDriver;

public class GoCompare_Insurance {
	
	WebDriver e;
	WebElement ex;
	String test;
	
	 public void Select_Insurance_Type(String Insurance_Type, String label){
		 try {
			
		
			
			if(Insurance_Type.contains(label)){
				Thread.sleep(30000);
			e.findElement(By.xpath(Insurance_Type)).click();
			}
			else 
				System.out.println("Can't find element on page");
		} catch (Exception e1) {
			
			e1.printStackTrace();
		}
		
		
	 }

}
