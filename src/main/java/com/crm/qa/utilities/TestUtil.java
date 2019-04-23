package com.crm.qa.utilities;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.crm.qa.base.TestBase;


public class TestUtil extends TestBase {
public static long page_load_timeout=20;
public static long implicit_wait =10;
static org.apache.poi.ss.usermodel.Workbook book;
static org.apache.poi.ss.usermodel.Sheet sheet;


public void switchTo(){
	
	driver.switchTo().frame("mainpanel");
	}


	    
public static Object[][] getTestData(String sheetname) throws Exception{
	FileInputStream f = new FileInputStream("C:\\TestData\\contactstestdata.xlsx");
	book= WorkbookFactory.create(f);
	sheet = book.getSheet("contactsList");
	Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	for(int i=0;i<sheet.getLastRowNum();i++)
		for(int k=0;k<sheet.getRow(0).getLastCellNum(); k++)
		{
			data[i][k]=sheet.getRow(i+1).getCell(k).toString();
			
		}
	return data;
}

}
