package dao;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import pojo.Employee;

public class Select {
	public static void main(String[] args) {
		SessionFactory sf=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		Session s=sf.openSession();
		
		System.out.println("Selecting all records");
		Query query=s.createQuery("From Employee");
		List<Employee> l=query.list();
		for(Employee e:l){
			System.out.println(e.getEmpNo()+" "+e.getEmpName()+" "+e.getEmpSal());
		}
		
		System.out.println("Max Salary");
		Query query1=s.createQuery("select max(empSal) from Employee");
		System.out.println(query1.list().get(0));
		
		Query q2=s.createQuery("From Employee where empName='Hk'");
		List<Employee> l2=q2.list();
		Employee emp=(Employee)l2.get(0);
		System.out.println(emp.getEmpNo()+" "+emp.getEmpName()+" "+emp.getEmpSal());
		
		Query q3=s.createQuery("from Employee where empNo=:no");
		System.out.println("Eno:");
		Scanner sc=new Scanner(System.in);
		int no=sc.nextInt();
		q3.setInteger("no", no);
		List<Employee> l3=q3.list();
		Employee emp2=(Employee)l3.get(0);
		System.out.println(emp2.getEmpNo()+" "+emp2.getEmpName()+" "+emp2.getEmpSal());
	}
}
