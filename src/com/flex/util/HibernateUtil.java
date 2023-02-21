package com.flex.util;

import java.util.HashMap;
import java.util.Map;
import org.hibernate.SessionFactory;
import org.hibernate.boot.*;
import org.hibernate.boot.registry.*;
import org.hibernate.cfg.Environment;
import org.hibernate.dialect.MySQL55Dialect;
import com.flex.model.Customer;
import com.flex.model.Location;
import com.flex.model.Mounter;


public class HibernateUtil {
	private static SessionFactory sf;
	private static StandardServiceRegistry registry;
	public static SessionFactory getSessionFactory()
	{
		try {
			if(sf==null)
			{
				// connection properties
				Map<String,String> map=new HashMap<>();
				map.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
				map.put(Environment.URL, "jdbc:mysql://localhost:3306/fms");
				map.put(Environment.USER, "root");
				map.put(Environment.PASS, "root");
				//hibernate propeties
				map.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
				map.put(Environment.HBM2DDL_AUTO, "update");
				map.put(Environment.SHOW_SQL,"false");
				
				
				// create object of StandardServiceRegistryBuilder
				registry=new StandardServiceRegistryBuilder().applySettings(map).build();
				// create object of MetaDataSources
				MetadataSources mds=new MetadataSources(registry);
				mds.addAnnotatedClass(Customer.class);
				mds.addAnnotatedClass(Location.class);
				mds.addAnnotatedClass(Mounter.class);
				// create object of MetaData
				  Metadata md  =  mds.getMetadataBuilder().build();
				  // create object of SessionFactory
				  sf=md.getSessionFactoryBuilder().build();
			}
		}
			catch (Exception e) {
				e.printStackTrace();
			}
		
		return sf;
	}

}
