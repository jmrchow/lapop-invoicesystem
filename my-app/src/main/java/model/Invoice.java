package model;

import java.util.ArrayList;
import java.util.Date;

import com.mycompany.view.InvoiceDTO;


public class Invoice {
	String invoiceNumber;
	Customer invoiceCustomer;
	Date invoiceDate;
	ArrayList<InvoiceBundle> invoiceBag;
	
	private class InvoiceBundle{
		String itemName;
		String itemDescription;
		Integer itemQuantity;
		Integer itemPrice;
		Integer itemDiscount;
		
	}
	
	public void addBundle(InvoiceDTO data) {
		InvoiceBundle newBundle = new InvoiceBundle();
		// convoluted for loop but whatever
		for (int i = 0; i < data.getBag().size(); i++) {
			newBundle.itemName = data.getItem(i);
			newBundle.itemDescription = data.getDescription(i);
			newBundle.itemQuantity = data.getQuantity(i);
			newBundle.itemPrice = data.getPrice(i);
			newBundle.itemDiscount = data.getDiscount(i);
			invoiceBag.add(newBundle);
		}
		
	}
	
	public String getItem(int i) {
		return invoiceBag.get(i).itemName;
	}
	public String getDescription(int i) {
		return invoiceBag.get(i).itemDescription;
	}
	public Integer getQuantity(int i) {
		return invoiceBag.get(i).itemQuantity;
	}
	public Integer getPrice(int i) {
		return invoiceBag.get(i).itemPrice;
	}
	public Integer getDiscount(int i) {
		return invoiceBag.get(i).itemDiscount;
	}

}

