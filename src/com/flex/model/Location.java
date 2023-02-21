package com.flex.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name="locationDetails")
public class Location 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int locationId;
	private String locationName;
	private String hoardingSize;
	
	public int getLocationId() 
	{
		return locationId;
	}
	public void setLocationId(int locationId) 
	{
		this.locationId = locationId;
	}
	public String getLocationName() 
	{
		return locationName;
	}
	public void setLocationName(String locationName) 
	{
		this.locationName = locationName;
	}
	public String getHoardingSize() 
	{
		return hoardingSize;
	}
	public void setHoardingSize(String hoardingSize) 
	{
		this.hoardingSize = hoardingSize;
	}
	
	

}
