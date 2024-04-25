package com.modal;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "patient")
public class Patient {
	@Id
	@Column(name = "patient_Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int patientId;
	@Column(name = "patient_Name")
	private String patientName;
	@Column(name = "mobile_Number")
	private String mobileNumber;
	@Column
	private int age;

	@ManyToMany(mappedBy = "patients")
	private Set<Doctor> doctors = new HashSet<Doctor>();

	public int getPatientId() {
		return patientId;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public int getAge() {
		return age;
	}

	public Set<Doctor> getDoctors() {
		return doctors;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setDoctors(Set<Doctor> doctors) {
		this.doctors = doctors;
	}

}
