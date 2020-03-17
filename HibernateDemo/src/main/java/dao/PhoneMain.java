package dao;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import pojo.PhoneUsingAnnotation;

public class PhoneMain {
	public static void main(String[] args) {
		SessionFactory sf=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();		
		Session s=sf.openSession();
		Transaction tx=s.beginTransaction();
		
		PhoneUsingAnnotation p=new PhoneUsingAnnotation();
		Scanner sc=new Scanner(System.in);

		System.out.println("Phone Name:");
		String name=sc.nextLine();
		System.out.println("RAM:");
		String ram=sc.nextLine();

		p.setPhoneName(name);
		p.setRamSize(ram);
		
		s.persist(p);
		System.out.println("inserted");
		tx.commit();
		
		
	}
}
