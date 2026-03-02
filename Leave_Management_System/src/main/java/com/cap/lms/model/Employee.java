package com.cap.lms.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Employee{
	
	@Id
	@Column(name="employee_id")
	private int empId;
	
	private String name;
	private String email;
	private String department;
	private Date joiningDate;
	
	@OneToMany(mappedBy="employee")
	private List<LeaveRequest> requests; 
	
}
