package com.soprabanking.software.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestDataFromExcel 
{
	 public static Workbook workbook;
	 public static Sheet sheet;
	 public static Row row;
	 public static Cell cell;
	public static HashMap<String, String> testDataMap=new HashMap<String, String>();
    public static void getExcelData(String FilePath, String FileName, String SheetName) throws IOException
   {
	 String ExcelPath = FilePath + FileName;
	 File ExcelFile=new File(ExcelPath);
	 FileInputStream fis=new FileInputStream(ExcelFile);
	 int dotIndex=FileName.indexOf(".");
	 String FileExt=FileName.substring(dotIndex+1);
	 System.out.println(FileExt);
	 if(FileExt.equals("xlsx"))
	 {
		 workbook=new XSSFWorkbook(fis);
	 }
	 else
	 {
		 System.out.println("File Format Not Supported");
	 }
	 
	    sheet=workbook.getSheet(SheetName);
	    testDataMap.put(sheet.getRow(0).getCell(0).toString(), sheet.getRow(1).getCell(0).toString());
	    testDataMap.put(sheet.getRow(0).getCell(1).toString(), sheet.getRow(1).getCell(1).toString());
	    /*int rowCount=sheet.getLastRowNum();
	    System.out.println();
	    for(int i=1;i<=rowCount;i++)
	    {
	    	row=sheet.getRow(i);
	    	int colCount=row.getLastCellNum();
	    	for (int j=0;j<colCount;j++)
	    	{
	    		//System.out.println(row.getCell(j).getStringCellValue());
	    		testDataMap.put(sheet.getRow(0).getCell(j).getStringCellValue(), row.getCell(j).getStringCellValue());
	    		//cell=row.getCell(j);
	    		//System.out.println(cell.getStringCellValue());
	    		System.out.println(testDataMap);
	    		
	    	}
	    }*/
	 
	 
 }
}
