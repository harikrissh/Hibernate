package dao;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import pojo.Employee;

public class NamedQuery {
	public static void main(String[] args) {
		SessionFactory sf=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		Session s=sf.openSession();
		List<Employee> l=s.getNamedQuery("view records").list();
		for(Employee e: l)
			System.out.println(e.getEmpNo()+" "+e.getEmpName()+" "+e.getEmpSal());
		
		System.out.println("Eno:");
		Scanner sc=new Scanner(System.in);
		int no=sc.nextInt();
		Query q3=s.getNamedQuery("delete");		
		q3.setInteger("no", no);
		int del=q3.executeUpdate();
		System.out.println(del+" records deleted");
	}
}
