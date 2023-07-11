package com.Jun23.CaptureImg;

import java.io.IOException;
import org.apache.commons.io.FileUtils;
import java.io.File;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.Jun23.ReportGeneration.Baseclass;


public class Capture extends Baseclass {
	
public static String takescreenshot(WebDriver driver) throws IOException {
		
		String filepath = System.getProperty("user.dir")+"/screenshots/"+"scrshot.png";
		
		TakesScreenshot tks = ((TakesScreenshot) driver);
		File sourcefile = tks.getScreenshotAs(OutputType.FILE);
		File destfile = new File(filepath);
		
		FileUtils.copyFile(sourcefile, destfile);
		
		return filepath;
	}

}
