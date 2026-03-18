package com.cap.code.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Doctor {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long  id;
	private String name;
	private long contactDetails;
	private String qualification;
	private String specializationIn;
	public Doctor(String name, long contactDetails, String qualification, String specializationIn) {
		super();
		this.name = name;
		this.contactDetails = contactDetails;
		this.qualification = qualification;
		this.specializationIn = specializationIn;
	}
	public Doctor() {}
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
	public long getContactDetails() {
		return contactDetails;
	}
	public void setContactDetails(long contactDetails) {
		this.contactDetails = contactDetails;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getSpecializationIn() {
		return specializationIn;
	}
	public void setSpecializationIn(String specializationIn) {
		this.specializationIn = specializationIn;
	}
	
	
	
}
