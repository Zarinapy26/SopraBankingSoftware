package com.soprabanking.software.tests;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.soprabanking.software.basetest.BaseTest;
import com.soprabanking.software.pages.SignIn;
import com.soprabanking.software.pages.WelcomePage;
import com.soprabanking.software.util.TestDataFromExcel;

public class SignInTest extends BaseTest 
{
  @Test(priority=2)
  public void verifySignIn()
  {
	  driver.get(prop.getProperty("appUrl"));
	  eTest.log(LogStatus.INFO, "Application has Launched");
	  WelcomePage wp=new WelcomePage(driver);
	  eTest.log(LogStatus.INFO, "WelcomePage Page Elements are initialized");
	  wp.navigateToLogin();
	  eTest.log(LogStatus.INFO, "SignIn link is Clicked");
	  SignIn si=new SignIn(driver);
	  eTest.log(LogStatus.INFO, "SignIn Page Elements are initialized");
	  //si.performSignIn(prop.getProperty("email"), prop.getProperty("password"));
	  si.performSignIn(TestDataFromExcel.testDataMap.get("Email"), TestDataFromExcel.testDataMap.get("Password"));
	  eTest.log(LogStatus.INFO, "Email and Password Taken From Excel");
	  eTest.log(LogStatus.PASS, "Login is Succesful");
	  //System.out.println(TestDataFromExcel.testDataMap.get("Email"));
	  //System.out.println(TestDataFromExcel.testDataMap.get("Password"));
  }  
}
