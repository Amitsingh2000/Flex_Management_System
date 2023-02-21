package com.flex.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Customer 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int reciptNo;
	String customerName;
	long mobileNo;
	@OneToOne(cascade = CascadeType.ALL)
	Location locDetails;
	@OneToOne(cascade = CascadeType.ALL)
	Mounter mouDetails;
	Double amountDetails;
	
	public int getReciptNo() {
		return reciptNo;
	}
	public void setReciptNo(int reciptNo) {
		this.reciptNo = reciptNo;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public Location getLocDetails() {
		return locDetails;
	}
	public void setLocDetails(Location locDetails) {
		this.locDetails = locDetails;
	}
	public Mounter getMouDetails() {
		return mouDetails;
	}
	public void setMouDetails(Mounter mouDetails) {
		this.mouDetails = mouDetails;
	}
	public Double getAmountDetails() {
		return amountDetails;
	}
	public void setAmountDetails(Double amountDetails) {
		this.amountDetails = amountDetails;
	}

	

}
