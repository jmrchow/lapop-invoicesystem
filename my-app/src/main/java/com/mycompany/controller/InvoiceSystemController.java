package com.mycompany.controller;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFDataFormat;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.mycompany.view.CustomerDTO;
import com.mycompany.view.InvoiceDTO;
import com.mycompany.view.InvoiceUI;

import model.Customer;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.util.CellRangeAddress;


public class InvoiceSystemController {
	
	private static final String TEMPLATE_FILE = "/Users/jeremychow/personal-projects/InvoiceSystem/my-app/src/main/resources/com/mycompany/model/InvoiceTemplate.xlsx";
	private static final String CUSTOMER_PERSISTENCE_FILENAME = "customers.ser";
	
	public ArrayList<Customer> customerList;
	
	private static XSSFWorkbook readFile(String filename) throws IOException{
		try(FileInputStream fis = new FileInputStream(filename)){
			return new XSSFWorkbook(fis);}
		}

	public static void createInvoice(InvoiceDTO data) throws IOException {
		
		String item;
		String description;
		Integer price;
		Integer quantity;
		Integer discount;
		
		for (int i = 0; i < InvoiceUI.NUMBER_OF_LINES; i++) {
			int column = 2;
			
			try {
				
			item = data.getItem(i);
			description = data.getDescription(i);
			price = data.getPrice(i);
			quantity = data.getQuantity(i);
			discount = data.getDiscount(i);
			
			}
			catch (NullPointerException e) {
				item = "";
				description = "";
				price = 0;
				quantity = 0;
				discount = 0;
			}
		
			try {
				XSSFWorkbook wb = InvoiceSystemController.readFile(TEMPLATE_FILE);
				XSSFSheet sheet = wb.getSheetAt(0);
				XSSFRow row = sheet.getRow(8 + i);
				XSSFCell cell = row.getCell(column);
				cell.setCellValue(item);
				cell = row.getCell(column + 1);
				cell.setCellValue(description);
				cell = row.getCell(column + 2);
				cell.setCellValue(price);
				cell = row.getCell(column + 3);
				cell.setCellValue(quantity);
				cell = row.getCell(column + 4);
				cell.setCellValue(discount);
			
				try (FileOutputStream stream = new FileOutputStream(TEMPLATE_FILE)){
					wb.write(stream);
				}
			
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static void createCustomer(CustomerDTO data) {
		Customer newCustomer = new Customer(data.companyName, data.contactName, data.address1, data.address2, data.city, data.province, data.postalCode);
		
	}
	
	public void loadPersistence(){
		this.customerList = new ArrayList<Customer>();
        // Serialization  
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(CUSTOMER_PERSISTENCE_FILENAME)))
        {    
            // Reading the object from a file 
            
            
              
            // Method for deserialization of object 
            this.customerList = (ArrayList<Customer>)in.readObject(); 
        }
          
        catch(IOException ex) 
        { 
            System.out.println("IOException is caught"); 
        } 
          
        catch(ClassNotFoundException ex) 
        { 
            System.out.println("ClassNotFoundException is caught"); 
        } 
  
	}
	
	
}
