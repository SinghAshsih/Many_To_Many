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
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int patient_Id;
	@Column
	private String patient_Name;
	@Column
	private String mobile_Number;
	@Column
	private int age;

	@ManyToMany(mappedBy = "patients")
	private Set<Doctor> doctors = new HashSet<Doctor>();

	public int getPatient_Id() {
		return patient_Id;
	}

	public String getMobile_Number() {
		return mobile_Number;
	}

	public int getAge() {
		return age;
	}

	public Set<Doctor> getDoctors() {
		return doctors;
	}

	public String getPatient_Name() {
		return patient_Name;
	}

	public void setPatient_Name(String patient_Name) {
		this.patient_Name = patient_Name;
	}

	public void setPatient_Id(int patient_Id) {
		this.patient_Id = patient_Id;
	}

	public void setMobile_Number(String mobile_Number) {
		this.mobile_Number = mobile_Number;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setDoctors(Set<Doctor> doctors) {
		this.doctors = doctors;
	}

}
