package com.cucumber2.MavenCucumber2;
import org.openqa.selenium.*;
//import org.openqa.selenium.chrome.ChromeDriver;

public class GoCompare_Insurance {
	
	static WebDriver e;
	static WebElement ex;
	String test;
	
	 public void Select_Insurance_Type(String Insurance_Type){
		 try {
			//if(Insurance_Type.contains(label)){
				
			ex = e.findElement(By.xpath(Insurance_Type));
			ex.click();
			
			
			//}
			//else 
				System.out.println("Element is: " + ex.getText());
			
		} catch (Exception e1) {
			
			e1.printStackTrace();
		}
		
		
	 }

}
