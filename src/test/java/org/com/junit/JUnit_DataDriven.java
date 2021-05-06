package org.com.junit;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.test.BaseClass;
import org.test.excelread.ExcelRead;

public class JUnit_DataDriven extends BaseClass {
	ExcelRead excel=new ExcelRead();

	@BeforeClass
	public static void beforeClass(){
		browserLaunch("chrome");
		browserMaximize();
		deleteCookies();
	}
	@Before
	public  void before(){

	}
	@Test
	public void test1() throws IOException {
		urlLaunch("https://adactinhotelapp.com/");
		File fileLocation = new File("C:\\NewWorkspace\\MavenProject\\src\\test\\resources\\excel\\TestData.xlsx"); 
		FileInputStream stream=new FileInputStream(fileLocation);
		Workbook book=new XSSFWorkbook(stream);
		Sheet sheet=book.getSheet("NewSheet");
		findById("username").sendKeys(sheet.getRow(1).getCell(0).getStringCellValue());
		findById("password").sendKeys(sheet.getRow(1).getCell(1).getStringCellValue());
		findById("login").click();
		selectDropdownByText(findById("location"),"London");
		selectDropdownByText(findById("hotels"),"Hotel Sunshine");
		selectDropdownByText(findById("room_type"),"Standard");
		selectDropdownByText(findById("room_nos"),"1 - One");
		findById("Submit").click();
		findById("radiobutton_0").click();
		findById("continue").click();
		
		findById("first_name").sendKeys(sheet.getRow(1).getCell(2).getStringCellValue());
		findById("last_name").sendKeys(sheet.getRow(1).getCell(3).getStringCellValue());
		findById("address").sendKeys(sheet.getRow(1).getCell(4).getStringCellValue());
		double numericCellValue = sheet.getRow(1).getCell(5).getNumericCellValue();
		findById("cc_num").sendKeys(String.valueOf((long)numericCellValue));
		selectDropdownByText(findById("cc_type"), "VISA");
		selectDropdownByText(findById("cc_exp_month"), "July");
		selectDropdownByText(findById("cc_exp_year"), "2022");
		findById("cc_cvv").sendKeys("100");
		findById("book_now").click();
	}

	@After
	public  void after(){

	}
	@AfterClass
	public static void afterClass(){
		//		windowQuit();
	}
}
