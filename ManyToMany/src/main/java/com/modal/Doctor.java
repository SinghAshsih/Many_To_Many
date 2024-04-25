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
	@Column(name = "doctor_Id")
	private int doctorId;

	@Column(name = "doctor_Name")
	private String doctorName;
	@Column
	private String specialization;

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "doctor_patient", joinColumns = { @JoinColumn(name = "doctor_id") }, inverseJoinColumns = {
			@JoinColumn(name = "patient_id") })
	private Set<Patient> patients = new HashSet<Patient>();

	public int getDoctorId() {
		return doctorId;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public String getSpecialization() {
		return specialization;
	}

	public Set<Patient> getPatients() {
		return patients;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public void setPatients(Set<Patient> patients) {
		this.patients = patients;
	}

}
