package com.cap.lms.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class LeaveRequest {
	@Id
	@Column(name="request_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int requestId;
	
	@ManyToOne
	@JoinColumn(name="employee_id")
	private Employee employee;
	
	
	@ManyToOne
	@JoinColumn(name = "leave_type_id")
	private LeaveType leaveType;
	
	private Date leaveStartDate;
	private Date leaveEndDate;
	private String status;
	
}
