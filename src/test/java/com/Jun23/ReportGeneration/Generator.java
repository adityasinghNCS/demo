package com.Jun23.ReportGeneration;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import com.Jun23.CaptureImg.Capture;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class Generator extends Baseclass{
public static void reportCreation() {
		
		// to create report
		extent = new ExtentReports();
		
		// publish / build the report
		spark = new ExtentSparkReporter("reports/testreports.html");
		
		// attaching reporter
		extent.attachReporter(spark);
		
	}

	public static void finishReportAfterTest(ITestResult itr) throws IOException {
		
		// object to add logs /messages
		extenttest = extent.createTest(itr.getName());
		
		if(itr.getStatus() == ITestResult.SUCCESS) {
			
			extenttest.log(Status.PASS,("Test "+ itr.getName() +"execution successful"));
			extenttest.log(Status.INFO,("Test method execution success. End"));
			extenttest.assignCategory("Success-category");
			
			
		}else if(itr.getStatus() == ITestResult.FAILURE) {

			extenttest.log(Status.FAIL,("Test "+ itr.getName() +"execution failed"));
			extenttest.log(Status.INFO,("Test method execution failed. End"));
			extenttest.assignCategory("Failed-category");
			extenttest.assignAuthor("TestLead");
			
			extenttest.addScreenCaptureFromPath(Capture.takescreenshot(driver));
			
		}else if(itr.getStatus() == ITestResult.SKIP) {

			extenttest.log(Status.SKIP,("Test "+ itr.getName() +"execution skipped"));
			extenttest.assignCategory("Skipped-category");

		}
		
		
		
	}

}
