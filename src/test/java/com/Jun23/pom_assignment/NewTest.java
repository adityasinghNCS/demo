package com.Jun23.pom_assignment;

import org.testng.annotations.Test;

import com.Jun23.ReportGeneration.Baseclass;
import com.Jun23.ReportGeneration.Generator;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterMethod;

public class NewTest extends Baseclass{
	
	WebDriver driver;
	
  @Test
  public void f() throws InterruptedException {
	  Ebayhomepage page1 = new Ebayhomepage(driver);
	  page1.enterSearch("Samsung");
	  page1.clickDropdown();
	  Thread.sleep(2000);
	  page1.clickdropdownitem();
	  page1.clicksearchbutton();
	  Thread.sleep(2000);
//	  Thread.sleep(2000);
	  assertEquals(driver.getCurrentUrl(),"https://www.ebay.com/sch/i.html?_from=R40&_trksid=p2380057.m570.l1313&_nkw=Samsung&_sacat=15032","Search page not loaded");
	  
  }
  @BeforeClass
  public void beforeClass() {
	  WebDriverManager.chromedriver().setup();
	  ChromeOptions options = new ChromeOptions();
	  options.addArguments("--remote-allow-origins=*");
	  driver = new ChromeDriver(options);
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  
	  driver.get("https://www.ebay.com/");
	  System.out.println("Website opened");
  }

  @AfterClass
  public void afterClass() {
	  driver.close();
  }
  
  @AfterTest
  public void aftertest(){
	  extent.flush();
	  
  }
  
  @BeforeTest
  public void beforetest() {
	  Generator.reportCreation();
  }
  
  @AfterMethod
  public void aftermethod(ITestResult itr) throws IOException {
	  Generator.finishReportAfterTest(itr);
  }

}
