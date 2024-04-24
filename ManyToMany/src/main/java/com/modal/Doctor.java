package com.modal;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "doctor")
public class Doctor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int doctor_Id;

	@Column
	private String doctor_Name;
	@Column
	private String specialization;

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "doctor_patient", joinColumns = { @JoinColumn(name = "doctor_id") }, inverseJoinColumns = {
			@JoinColumn(name = "patient_id") })
	private Set<Patient> patients = new HashSet<Patient>();

	

	public int getDoctor_Id() {
		return doctor_Id;
	}

	public String getDoctor_Name() {
		return doctor_Name;
	}

	public String getSpecialization() {
		return specialization;
	}

	public Set<Patient> getPatients() {
		return patients;
	}

	public void setDoctor_Id(int doctor_Id) {
		this.doctor_Id = doctor_Id;
	}

	public void setDoctor_Name(String doctor_Name) {
		this.doctor_Name = doctor_Name;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public void setPatients(Set<Patient> patients) {
		this.patients = patients;
	}

}
