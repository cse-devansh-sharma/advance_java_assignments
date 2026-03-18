package com.cap.code.model;
import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
public class Patient {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String  name;
	private int  age;
	private Long contactNumber;
	private LocalDate AppointmentDate;
	private String status;
	private String medicalHistory;
	private Doctor doctorDetails;
	public Patient(String name, int age, Long contactNumber, LocalDate appointmentDate, String status,
			String medicalHistory, Doctor doctorDetails) {
		super();
		this.name = name;
		this.age = age;
		this.contactNumber = contactNumber;
		AppointmentDate = appointmentDate;
		this.status = status;
		this.medicalHistory = medicalHistory;
		this.doctorDetails = doctorDetails;
	}
	
	public Patient() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(Long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public LocalDate getAppointmentDate() {
		return AppointmentDate;
	}

	public void setAppointmentDate(LocalDate appointmentDate) {
		AppointmentDate = appointmentDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMedicalHistory() {
		return medicalHistory;
	}

	public void setMedicalHistory(String medicalHistory) {
		this.medicalHistory = medicalHistory;
	}

	public Doctor getDoctorDetails() {
		return doctorDetails;
	}

	public void setDoctorDetails(Doctor doctorDetails) {
		this.doctorDetails = doctorDetails;
	}
	
	
	
}