package dao;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import pojo.CustomerPojo;
import pojo.VendorPojo;

public class OneToManyMain {
	public static void main(String[] args) {
		SessionFactory sf=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();		
		Session s=sf.openSession();
		Transaction tx=s.beginTransaction();
		
		VendorPojo v1=new VendorPojo();
		VendorPojo v2=new VendorPojo();
		CustomerPojo c1=new CustomerPojo();
		CustomerPojo c2=new CustomerPojo();
		v1.setvName("KFC");
		v1.setvMail("kfc@mail.com");
		c1.setcName("Hari");
		c2.setcName("Arun");
		Set<CustomerPojo> cust=new HashSet<>();
		cust.add(c1);
		cust.add(c2);
		v1.setCust(cust);
		
		v2.setvName("Dominos");
		v2.setvMail("dom@mail.com");
		CustomerPojo c3=new CustomerPojo();
		CustomerPojo c4=new CustomerPojo();
		c3.setcName("Mani");
		c4.setcName("Cj");
		Set<CustomerPojo> cust2=new HashSet<>();
		cust2.add(c3);
		cust2.add(c4);
		v2.setCust(cust2);
		
		s.persist(v1);
		s.persist(v2);
		tx.commit();
		s.close();
	}
}
