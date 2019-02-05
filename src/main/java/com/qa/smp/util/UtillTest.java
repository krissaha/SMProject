package com.qa.smp.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.qa.smp.base.TestBase;

public class UtillTest extends TestBase {

	public static long PAGE_LOAD_TIMEOUT = 30;
	public static long IMPLICIT_WAIT = 20;
	public static XSSFWorkbook wb;
	public static XSSFSheet sheet;

//	public UtillTest(String excelpath) {
//		try {
//			File src = new File(excelpath);
//			FileInputStream fis = new FileInputStream(src);
//			wb = new XSSFWorkbook(fis);
//			
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
	
	public static String readData(String sheetName, String data)
	{
//		sheet = wb.getSheetAt(sheetnumber);
//		String data = sheet.getRow(row).getCell(column).getStringCellValue();
//		return data;
		return "saishreedas@gmail.com";
		
	}
	

}
