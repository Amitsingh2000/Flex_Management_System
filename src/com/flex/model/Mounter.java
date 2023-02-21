package com.flex.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="mounterDetails")
public class Mounter 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int mountId;
	private String mounterName;
	
	public int getMountId() 
	{
		return mountId;
	}
	public void setMountId(int mountId) 
	{
		this.mountId = mountId;
	}
	public String getMounterName() 
	{
		return mounterName;
	}
	public void setMounterName(String mounterName) 
	{
		this.mounterName = mounterName;
	}
	
	

}
