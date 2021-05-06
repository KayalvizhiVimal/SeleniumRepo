package org.test.excelread;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWrite {
	static Workbook book;
	public static void main(String[] args) throws IOException {
		File fileLocation = new File("C:\\NewWorkspace\\MavenProject\\src\\test\\resources\\excel\\TestData.xlsx"); 
		
		//Replace in the Excel file
		FileInputStream inputStream=new FileInputStream(fileLocation);
		book=new XSSFWorkbook(inputStream);
//		Cell cell = book.getSheet("Sheet1").getRow(3).getCell(1);
//		String val = cell.getStringCellValue();
//		if(val.equals(null)) {
//			cell.setCellValue("Samsung");
//		}
		
		//Write in Excel file(create Sheet,Row and Cell)
		FileOutputStream outputStream=new FileOutputStream(fileLocation);
		Workbook book=new XSSFWorkbook();
		book.createSheet("Sheet2");
		book.write(outputStream);
		outputStream.close();
	}
}
