package dao;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import pojo.Employee;

public class Insert {
	public static void main(String[] args) {
		
		SessionFactory sf=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		Session s=sf.openSession();
		Transaction tx=s.beginTransaction();
		
		Employee e=new Employee();
		
		Scanner sc=new Scanner(System.in);
		System.out.println("EmpNo:");
		int empNo=sc.nextInt();
		System.out.println("EmpName");
		String empName=sc.next();
		System.out.println("EmpSal:");
		float empSal=sc.nextFloat();
		
		e.setEmpNo(empNo);
		e.setEmpName(empName);
		e.setEmpSal(empSal);
		
		s.persist(e);
		System.out.println("Inserted");
		tx.commit();
		sc.close();
	}
	
}
