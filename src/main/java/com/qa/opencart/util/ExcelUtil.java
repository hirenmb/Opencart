package com.qa.opencart.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;

public class ExcelUtil {

	public static String path = "";

	private static final String TEST_DATA_SHEET_PATH = "./src/test/java/resources/data.xlsx";
	private static Workbook book;
	private static Sheet sheet;

	private WebDriver driver;

	public ExcelUtil(WebDriver driver) {
		this.driver = driver;
	}

	public static Object[][] getExcelData(String sheetName) throws FileNotFoundException {
		Object[][] data = null;
		FileInputStream ip = new FileInputStream(TEST_DATA_SHEET_PATH);
		try {
			book = WorkbookFactory.create(ip);
			sheet = book.getSheet(sheetName);
			System.out.println();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
int row = sheet.getLastRowNum();
int col =  sheet.getRow(0).getLastCellNum();
		System.out.println("Total row : - " + row +"Total Col : - "+col );
		data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
          data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

		
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
				data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
			}
		}

		return data;

	}

}
