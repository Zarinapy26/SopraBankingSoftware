package com.soprabanking.software.basetest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.soprabanking.software.util.ExtentReportGenerator;
import com.soprabanking.software.util.GetScreenshot;
import com.soprabanking.software.util.TestDataFromExcel;

public class BaseTest 
{
  public static WebDriver driver;
  public static Properties prop;
  public static ExtentReports eReport;
  public static ExtentTest eTest;
  
  public BaseTest()
  {
	  prop=new Properties();
	  FileInputStream file;
	  try 
	  {
		file= new FileInputStream(System.getProperty("user.dir") + "/src/main/java/com/soprabanking/software/config/info.properties");
		prop.load(file);
	  }
	  catch(FileNotFoundException e)
	  {
		  e.printStackTrace();
	  } 
	  catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
 
  @BeforeMethod
   public static void initializeTest() throws IOException
   {
	  //Browser Stuff 
	  String browser=prop.getProperty("browser");
	   if(browser.equals("chrome"))
	   {
		   System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
		   driver=new ChromeDriver();
	   }
	   
	   eReport=ExtentReportGenerator.getExtentReportInstance();
	   eTest=eReport.startTest("Zoho Welcome and Sign In Test");
	   eTest.log(LogStatus.INFO, "Browser has instantiated and Opened");
	   driver.manage().window().maximize();
	   eTest.log(LogStatus.INFO, "Browser is maximized");
	   driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	   eTest.log(LogStatus.INFO, "Browser is set for Implict wait");
	   
	   //Excel Test Data
	   TestDataFromExcel.getExcelData(System.getProperty("user.dir")+"/TestData/", "TestData.xlsx", "Test Data");
   }
  
  @AfterMethod
  public static void Closure(ITestResult result) throws IOException
  {
	if(result.getStatus()==ITestResult.FAILURE)
	{
		String ScreenShotPath=GetScreenshot.capture(driver, "FailedTCSnap");
		eTest.log(LogStatus.FAIL, result.getName()+"Test Case is Failed due to below issue:");
		eTest.log(LogStatus.INFO, "Snapshot Below"+eTest.addScreenCapture(ScreenShotPath));
	}
	
	else if(result.getStatus()==ITestResult.SUCCESS)
	{
		String ScreenShotPath=GetScreenshot.capture(driver, "PassedSnap");
		eTest.log(LogStatus.PASS, result.getName()+"Test Case is Passed");
		eTest.log(LogStatus.INFO, "Snapshot Below"+eTest.addScreenCapture(ScreenShotPath));
	}
	  
	  
	  eReport.endTest(eTest);
	  eReport.flush();
  }
  
}
