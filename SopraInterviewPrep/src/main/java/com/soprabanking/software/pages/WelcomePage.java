package com.soprabanking.software.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WelcomePage 
{
  @FindBy(className="zh-customers")
  public WebElement customer;
  
  @FindBy(className="zh-support")
  public WebElement support;
  
  @FindBy(xpath="//a[@class='zh-contact']")
  public WebElement contact_sales;
  
  @FindBy(xpath="//a[@class='zh-login']")
  public WebElement login;
  
  //Initializing WebElement for Current Page
  public WelcomePage(WebDriver driver)
  {
	  PageFactory.initElements(driver, this);;
  }
  
  public void navigateToLogin()
  {
	  login.click();
  }
}
