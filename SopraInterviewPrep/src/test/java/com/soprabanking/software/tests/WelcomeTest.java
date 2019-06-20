package com.soprabanking.software.tests;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.soprabanking.software.basetest.BaseTest;
import com.soprabanking.software.pages.WelcomePage;

public class WelcomeTest extends BaseTest
{
  @Test(priority=1)
  public void verifyLoginLinkNavigation()
  {
	  driver.get(prop.getProperty("appUrl"));
	  eTest.log(LogStatus.INFO, "Application has Launched");
	  WelcomePage wp=new WelcomePage(driver);
	  eTest.log(LogStatus.INFO, "WelcomePage Elements are initialized");
	  wp.navigateToLogin();
	  eTest.log(LogStatus.PASS, "Navigated to Login Link Succesfully");
  }
}
