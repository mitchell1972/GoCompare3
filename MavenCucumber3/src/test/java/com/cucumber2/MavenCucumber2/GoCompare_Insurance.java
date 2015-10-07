package com.cucumber2.MavenCucumber2;
import java.io.File;
import java.io.IOException;

import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.*;
//import org.openqa.selenium.chrome.ChromeDriver;

public class GoCompare_Insurance {
	
	static WebDriver e;
	static WebElement ex;
	static String test;
	
	 public static void Select_Insurance_Type(WebElement Insurance_Type){
		 try {
			ex = Insurance_Type;
			System.out.println("Element is: " + ex.getText());
			ex.click();
			
		} catch (Exception e1) {
			
			e1.printStackTrace();
		}
		
		
	 }
	 
	 public static void getscreenshot(String filepath, WebDriver e){
		 File scrFile = ((TakesScreenshot)e).getScreenshotAs(OutputType.FILE);
		 try {
			FileUtils.copyFile(scrFile, new File(filepath));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 
	 }

}
