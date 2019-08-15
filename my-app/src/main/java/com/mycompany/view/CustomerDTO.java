package com.mycompany.view;

public class CustomerDTO {
	
	public String companyName;
	public String contactName;
	public String address1;
	public String address2;
	public String city;
	public String province;
	public String postalCode;
	
	public CustomerDTO(String companyName, String contactName, String address1, String address2, String city, String province, String postalCode) {
		this.companyName = companyName;
		this.contactName = contactName;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.province = province;
		this.postalCode = postalCode;

	}

}
