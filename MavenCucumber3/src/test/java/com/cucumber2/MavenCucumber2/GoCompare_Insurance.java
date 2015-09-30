package com.cucumber2.MavenCucumber2;
import org.openqa.selenium.*;
//import org.openqa.selenium.chrome.ChromeDriver;

public class GoCompare_Insurance {
	
	WebDriver e;
	WebElement ex;
	String test;
	
	 public void Select_Insurance_Type(String Insurance_Type){
		 try {
			//if(Insurance_Type.contains(label)){
				ex = e.findElement(By.xpath(Insurance_Type));
			e.findElement(By.xpath(Insurance_Type)).click();
			
			
			//}
			//else 
				System.out.println("Can't find element on page");
			System.out.println(ex.getText());
		} catch (Exception e1) {
			
			e1.printStackTrace();
		}
		
		
	 }

}
