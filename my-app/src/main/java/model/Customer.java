package model;

import java.io.Serializable;

public class Customer implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String companyName;
	String contactName;
	String address1;
	String address2;
	String city;
	String province;
	String postalCode;
	
	public Customer(String companyName, String contactName, String address1, String address2, String city, String province, String postalCode) {
		this.companyName = companyName;
		this.contactName = contactName;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.province = province;
		this.postalCode = postalCode;
		
	}

}
