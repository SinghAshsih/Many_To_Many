package com.modal;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ClientManyToMany {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("/com/modal/hibernate.cfg.xml");
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Doctor doctor1 = new Doctor();
		doctor1.setDoctor_Name("Dr. Anjali Verma");
		doctor1.setSpecialization("Dermatologist");

		Doctor doctor2 = new Doctor();
		doctor2.setDoctor_Name("Dr. Sunita Sharma");
		doctor2.setSpecialization("Gynecologist");

		Patient patient1 = new Patient();
		patient1.setPatient_Name("Sumit");
		patient1.setAge(25);
		patient1.setMobile_Number("820-6563-391");

		Patient patient2 = new Patient();
		patient2.setPatient_Name("Pawan Sing");
		patient2.setAge(19);
		patient2.setMobile_Number("900-2162-131");

		Set<Patient> list = new HashSet<Patient>();
		list.add(patient1);
		list.add(patient2);

		doctor1.setPatients(list);
		doctor2.setPatients(list);
		Session session = sessionFactory.openSession();

		Transaction tx = session.beginTransaction();
		session.save(doctor1);
		session.save(patient1);
		session.save(patient2);

		tx.commit();

	}
}
