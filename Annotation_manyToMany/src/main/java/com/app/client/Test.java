package com.app.client;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.app.entity.Certifications;
import com.app.entity.Employee;
import com.app.utility.HibernateUtility;

public class Test {

	public void save() {
		Employee emp1 = new Employee();
		emp1.setName("Rutuja");

		Employee emp2 = new Employee();
		emp2.setName("Vrushali");

		Session session = HibernateUtility.getSession().openSession();

		Certifications c1 = (Certifications) session.get(Certifications.class, 101);
		Certifications c2 = (Certifications) session.get(Certifications.class, 102);
		Certifications c3 = (Certifications) session.get(Certifications.class, 103);

		List<Certifications> certificate = new ArrayList<Certifications>();
		certificate.add(c1);
		certificate.add(c3);

		emp1.setCerticatesList(certificate);

		List<Certifications> certificate2 = new ArrayList<Certifications>();
		certificate2.add(c1);
		certificate2.add(c2);

		emp2.setCerticatesList(certificate2);

		session.save(emp1);
		session.save(emp2);

		session.beginTransaction().commit();
		System.out.println("Saved successfully");

	}

	@SuppressWarnings("unchecked")
	public void selectAll() {
		HibernateUtility.getSession().openSession().createCriteria(Employee.class).list().forEach(System.out::println);
	}

	public void update() {
		Session session = HibernateUtility.getSession().openSession();

		Employee emp = (Employee) session.get(Employee.class,10);
		emp.setName("Vrushali");

		List<Certifications> certificatesList = new ArrayList<>();

		for (Certifications C : emp.getCerticatesList()) {
			if (C.getId() == 102) {
				C.setCertificate("java");
				certificatesList.add(C);
			}
		}
		emp.setCerticatesList(certificatesList);

		session.update(emp);

		session.beginTransaction().commit();

		System.out.println("Updated successfully");
	}

	public void delete() {
		Session session = HibernateUtility.getSession().openSession();
		Employee emp = (Employee) session.get(Employee.class, 9);
		session.delete(emp);
		session.beginTransaction().commit();
		System.out.println("Deleted successfully");

	}

	public static void main(String[] args) {

		Test t = new Test();
		// t.save();
		t.selectAll();
		//t.update();
		 t.delete();
	}

}
