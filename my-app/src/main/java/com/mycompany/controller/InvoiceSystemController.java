package com.mycompany.controller;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFDataFormat;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.util.CellRangeAddress;


public class InvoiceSystemController {
	
	private static final String TEMPLATE_FILE = "/Users/jeremychow/personal-projects/InvoiceSystem/my-app/src/main/resources/com/mycompany/model/InvoiceTemplate.xlsx";
	
	private static XSSFWorkbook readFile(String filename) throws IOException{
		try(FileInputStream fis = new FileInputStream(filename)){
			return new XSSFWorkbook(fis);}
		}

	public static void createInvoice() throws IOException {
		
		try {
			XSSFWorkbook wb = InvoiceSystemController.readFile(TEMPLATE_FILE);
			XSSFSheet sheet = wb.getSheetAt(0);
			XSSFRow row = sheet.getRow(8);
			XSSFCell cell = row.getCell(5);
			cell.setCellValue(0);
			row = sheet.getRow(9);
			cell = row.getCell(5);
			cell.setCellValue(0);
			
			try (FileOutputStream stream = new FileOutputStream(TEMPLATE_FILE)){
				wb.write(stream);
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
