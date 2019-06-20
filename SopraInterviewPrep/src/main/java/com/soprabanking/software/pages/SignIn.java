package com.soprabanking.software.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignIn 
{
   @FindBy(id="lid")
   public WebElement email;
   
   @FindBy(id="pwd")
   public WebElement password;
   
   @FindBy(xpath="//div[@id='signin_submit']")
   public WebElement SignIn;
   
   //Initializes webelement for this page
   public SignIn(WebDriver driver)
   {
	   PageFactory.initElements(driver, this);
   }
   
   public void performSignIn(String email, String Password)
   {
     this.email.sendKeys(email);
     this.password.sendKeys(Password);
     this.SignIn.click();
     
   }
}
