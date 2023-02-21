package com.flex.serviceImple;

import java.util.*;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.flex.model.Customer;
import com.flex.model.Location;
import com.flex.model.Mounter;
import com.flex.service.Manager;
import com.flex.util.HibernateUtil;

public class ShreeGraphics implements Manager
{
	Scanner sc=new Scanner(System.in);
	SessionFactory sf=HibernateUtil.getSessionFactory();
	List<Customer> customerList=new ArrayList<>();
	List<Location> locationList=new ArrayList<>();
	List<Mounter> mounterList=new ArrayList<>();

	@Override
	public void addCustomer() 
	{
		Customer c=new Customer();
//		System.out.println("Enter Recipt No = ");
//		c.setReciptNo(sc.nextInt());
		System.out.println("Enter Customer Name = ");
		c.setCustomerName(sc.next());
		System.out.println("Enter Mobile No = ");
		c.setMobileNo(sc.nextLong());
		viewLocation();
		if(locationList.isEmpty())
		{
			System.out.println("Location Are Not Available");
			return;
		}
		else
		{
			System.out.println("Choose Which Location You Want ? ");
			int locch=sc.nextInt();
			locationList.forEach((l)->
			{
				if(locch==l.getLocationId())
				{
					c.setLocDetails(l);
				}
			});
		}
		viewMounter();
		if(mounterList.isEmpty())
		{
			System.out.println("Mounters Are Not Available");
			return;
		}
		else
		{
			System.out.println("Choose Which Location You Want ? ");
			
			int mouch=sc.nextInt();
			mounterList.forEach((m)->
			{
				if(mouch==m.getMountId())
				{
					c.setMouDetails(m);
				}
			});
		}
		System.out.println("Enter Total Amount  = ");
		c.setAmountDetails(sc.nextDouble());
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session session=sf.openSession();
		session.save(c);
		session.beginTransaction().commit();
		session.close();
		System.out.println("Customer Added Successfully");
	}

	@Override
	public void viewCustomer() 
	{
		//System.out.println("Which Customer You want to see = ");
		Session session=sf.openSession();
		Query query=session.createQuery("from Customer");
		customerList =query.list();
		if(customerList.isEmpty())
		{
			System.out.println("Customers Are Not Available");
			return;
		}
		else
		{
			customerList.forEach((c)->
			{
				System.out.println("Recipt No = "+c.getReciptNo());
				System.out.println("Customer Name = "+c.getCustomerName());
				System.out.println("Customer Number = "+c.getMobileNo());
				System.out.println("<---Flex Details --->");
				System.out.println("Location Id = "+c.getLocDetails().getLocationId());
				System.out.println("Location Name = "+c.getLocDetails().getLocationName());
				System.out.println("Flex Size = "+c.getLocDetails().getHoardingSize());
				System.out.println("Mounter Name = "+c.getMouDetails().getMounterName());
			});
		}
		session.close();
	}

	@Override
	public void addLocation() 
	{
		Location l=new Location();
//		System.out.println("Enter Location Id = ");
//		l.setLocationId(sc.nextInt());
		System.out.println("Enter Location Name = ");
		l.setLocationName(sc.next());
		System.out.println("Enter Hoarding Size = ");
		l.setHoardingSize(sc.next());
		Session session=sf.openSession();
		session.save(l);
		session.beginTransaction().commit();
		session.close();
		System.out.println("Location Added Successfullyy");
	}

	@Override
	public void viewLocation() 
	{
		Session session=sf.openSession();
		Query query=session.createQuery("from Location");
		locationList =query.list();
		if(locationList.isEmpty())
		{
			System.out.println("Locations Not Found");
		}
		else
		{
			locationList.forEach((e)->
			{
				System.out.println("Location Id = "+e.getLocationId()+" Location Name = "+e.getLocationName()+" Location Size = "+e.getHoardingSize());
			});
		}
		session.close();
		
	}

	@Override
	public void addMounter() 
	{
		Mounter m=new Mounter();
//		System.out.println("Enter Mounter Id = ");
//		m.setMountId(sc.nextInt());
		System.out.println("Enter Mounter Name = ");
		m.setMounterName(sc.next());
		Session session=sf.openSession();
		session.save(m);
		session.beginTransaction().commit();
		System.out.println("Mounter Added Successfully");
		session.close();
	}

	@Override
	public void viewMounter() 
	{
		Session session=sf.openSession();
		Query query=session.createQuery("from Mounter");
		mounterList =query.list();
		if(mounterList.isEmpty())
		{
			System.out.println("Locations Not Found");
		}
		else
		{
			mounterList.forEach((e)->
			{
				System.out.println("Mounter Id = "+e.getMountId()+" Mounter Name = "+e.getMounterName());
			});
		}
		session.close();
	}

	@Override
	public void addAmount(double Amount)
	{
		double recivedAmount=Amount;
		System.out.println("Enter Recipt No =");
		int cust=sc.nextInt();
		if(customerList.isEmpty())
		{
			System.out.println("Customers Are Not Available");
		}
		else
		{
			customerList.forEach((c)->
			{
				if(cust==c.getReciptNo())
				{
					double remainingAmount = c.getAmountDetails()-recivedAmount;
					c.setAmountDetails(remainingAmount);
				}
			});
			
		}
		System.out.println("Amount Added Succesfully");
		
	}

	@Override
	public double viewAmount() 
	{
		System.out.println("Enter Recipt No =");
		int cust=sc.nextInt();
		if(customerList.isEmpty())
		{
			System.out.println("Customers Are Not Available");
		}
		else
		{
			for(Customer c:customerList)
			{
				if(cust==c.getReciptNo())
				{
					return c.getAmountDetails();
				}
			}
			
		}
		return 0;
		
	}

}
