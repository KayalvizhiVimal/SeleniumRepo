package org.test.excelread;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {
	public static void main(String[] args) throws IOException {
		//		getValueFromExcel();
		getCellValues();
	}

	public static String getValueFromExcel() throws IOException {
		String value;
		File fileLocation = new File("C:\\NewWorkspace\\MavenProject\\src\\test\\resources\\excel\\TestData.xlsx"); 
		FileInputStream stream=new FileInputStream(fileLocation);
		Workbook book=new XSSFWorkbook(stream);
		Cell cell = book.getSheet("Sheet1").getRow(1).getCell(0);
		int cellType = cell.getCellType(); // type 0 - num,date // type 1- string
		if(cellType == 0 ) {
			if(DateUtil.isCellDateFormatted(cell)) {
				Date dateCellValue = cell.getDateCellValue();
				//MMMM- July
				//MMM- jul
				//MM- 07
				SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MMMM-yyyy");
				value = dateFormat.format(dateCellValue);
				System.out.println(value);
			}else {
				double numericCellValue = cell.getNumericCellValue();
				long longVal=(long)numericCellValue;
				value = String.valueOf(longVal);
				System.out.println(value);
			}

		}else {
			value = cell.getStringCellValue();
			System.out.println(value);
		}
		return value;

	}

	public static String getCellValues() throws IOException{
		Cell cellValue = null;
		String value = null;
		File fileLocation = new File("C:\\NewWorkspace\\MavenProject\\src\\test\\resources\\excel\\TestData.xlsx"); 
		FileInputStream stream=new FileInputStream(fileLocation);
		Workbook book=new XSSFWorkbook(stream);
		Sheet sheet = book.getSheet("Sheet1");
		for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
			Row rowValue = sheet.getRow(i);
			for (int j = 0; j < rowValue.getPhysicalNumberOfCells(); j++) {
				cellValue=rowValue.getCell(j);
				int cellType = cellValue.getCellType(); // type 0 - num,date // type 1- string
				if(cellType == 0 ) {
					if(DateUtil.isCellDateFormatted(cellValue)) {
						Date dateCellValue = cellValue.getDateCellValue();
						//MMMM- July
						//MMM- jul
						//MM- 07
						SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MMMM-yyyy");
						value = dateFormat.format(dateCellValue);
						System.out.println(value);
					}else {
						double numericCellValue = cellValue.getNumericCellValue();
						long longVal=(long)numericCellValue;
						value = String.valueOf(longVal);
						System.out.println(value);
					}

				}else {
					value = cellValue.getStringCellValue();
					System.out.println(value);
				}
			}
		}
		return value;
	}
}
