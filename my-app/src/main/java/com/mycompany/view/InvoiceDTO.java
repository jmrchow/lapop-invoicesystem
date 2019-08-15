package com.mycompany.view;

import java.util.ArrayList;

public class InvoiceDTO {
	
	ArrayList<InvoiceBundle> invoiceBag = new ArrayList<InvoiceBundle>();
	
	private class InvoiceBundle{
		String itemName;
		String itemDescription;
		Integer itemQuantity;
		Integer itemPrice;
		Integer itemDiscount;
		
	}
	
	public void addBundle(Integer bundleNumber, String item,  String description, Integer quantity, Integer price, Integer discount) {
		InvoiceBundle newBundle = new InvoiceBundle();
		newBundle.itemName = item;
		newBundle.itemDescription = description;
		newBundle.itemQuantity = quantity;
		newBundle.itemPrice = price;
		newBundle.itemDiscount = discount;
		invoiceBag.add(newBundle);
		
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
	public ArrayList<InvoiceBundle> getBag() {
		return invoiceBag;
	}

}
