package com.Jun23.ReportGeneration;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class Baseclass {
	//Report File Creation
	protected static ExtentReports extent;

	//Publish messages
	static ExtentSparkReporter spark;
	
	// Log Generation
	static ExtentTest extenttest;
	
	static WebDriver driver;

}
