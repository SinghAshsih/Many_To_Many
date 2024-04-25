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
		doctor1.setDoctorName("Dr. Anuj Rajawat");
		doctor1.setSpecialization("Cardiologist");

		Doctor doctor2 = new Doctor();
		doctor2.setDoctorName("Dr. Deepak Sharma");
		doctor2.setSpecialization("Physician");

		Patient patient1 = new Patient();
		patient1.setPatientName("Suit");
		patient1.setAge(25);
		patient1.setMobileNumber("820-2563-391");

		Patient patient2 = new Patient();
		patient2.setPatientName("Puja Singh");
		patient2.setAge(19);
		patient2.setMobileNumber("900-2222-131");

		Set<Patient> set = new HashSet<Patient>();
		set.add(patient1);
		set.add(patient2);

		doctor1.setPatients(set);
		doctor2.setPatients(set);
		Session session = sessionFactory.openSession();

		Transaction tx = session.beginTransaction();
		session.save(doctor1);
		session.save(doctor2);
		session.save(patient1);
		session.save(patient2);

		tx.commit();
		session.close();
		sessionFactory.close();

	}
}
