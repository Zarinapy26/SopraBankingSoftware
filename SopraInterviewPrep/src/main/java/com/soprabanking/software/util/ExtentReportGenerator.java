package com.soprabanking.software.util;

import java.io.File;
import java.util.Date;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

public class ExtentReportGenerator 
{
   public static ExtentReports getExtentReportInstance()
   {
	   Date date=new Date();
	   String eReportFile=date.toString().replace(" ", "_").replace(":", "_")+".html";
	   String eReportPath="Report//"+eReportFile;
	   ExtentReports eReport=new ExtentReports(eReportPath, true,DisplayOrder.NEWEST_FIRST);
	   File configFile=new File("Reports-Config.xml");
	   eReport.loadConfig(configFile);
	   eReport.addSystemInfo("Selenium Version", "3.14");
	   eReport.addSystemInfo("TestNG Version", "6.14.3");
	   eReport.addSystemInfo("Executed BY", "Zarina");
	   return eReport;
   }
}
