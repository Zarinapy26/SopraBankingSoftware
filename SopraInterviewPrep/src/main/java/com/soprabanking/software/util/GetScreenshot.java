package com.soprabanking.software.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class GetScreenshot 
{
   public static String capture(WebDriver driver,String ScreenshotName)throws IOException
   {
	   String dest=System.getProperty("user.dir")+"/Screenshot/"+ScreenshotName+System.currentTimeMillis()+".png";
	   TakesScreenshot ts=(TakesScreenshot)driver;
	  File source=ts.getScreenshotAs(OutputType.FILE);
	  File destination=new File(dest);
	  FileUtils.copyFile(source, destination);
	   return dest;
   }
}
