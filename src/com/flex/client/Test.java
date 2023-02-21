package com.flex.client;

import com.flex.service.Manager;
import com.flex.serviceImple.ShreeGraphics;
import java.util.*;
public class Test 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		Manager shree=new ShreeGraphics();
		while(true)
		{
			System.out.println("Enter Choice  = \n"
					+ "1. For Add Customer.\n"
					+ "2. For View Customer. \n"
					+ "3. For Add Location. \n"
					+ "4. For View Location. \n"
					+ "5. For Add Mounter. \n"
					+ "6. For View Mounter. \n"
					+ "7. For Add Amount. \n"
					+ "8. For View Amount. \n"
					+ "9. For Exit");
			int ch =sc.nextInt();
			switch(ch)
			{
				case 1:
					shree.addCustomer();
					break;
				case 2:
					shree.viewCustomer();
					break;
				case 3:
					shree.addLocation();
					break;
				case 4:
					shree.viewLocation();
					break;
				case 5:
					shree.addMounter();
					break;
				case 6:
					shree.viewMounter();
					break;
				case 7:
					shree.addAmount();
					break;
				case 8:
					shree.viewAmount();
					break;
				case 9:
					System.exit(0);
				default:
					System.out.println(" Enter Valid Choice ");
			}
		}
	
		
	}

}
