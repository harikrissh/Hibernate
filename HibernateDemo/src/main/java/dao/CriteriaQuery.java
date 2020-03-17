package dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import pojo.Employee;

public class CriteriaQuery {
	public static void main(String[] args) {
		SessionFactory sf=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		Session s=sf.openSession();
		Transaction tx=s.beginTransaction();
		Criteria cr=s.createCriteria(Employee.class);
		cr.add(Restrictions.gt("empSal", 30000));
		List<Employee> l=(List<Employee>)cr.list();
		for(Employee e:l)
			System.out.println(e.getEmpNo()+" "+e.getEmpName()+" "+e.getEmpSal());
	}
}
