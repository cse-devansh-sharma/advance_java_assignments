package com.cap.lms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

import jakarta.persistence.Column;

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
@Table(name="Leave_Type")
public class LeaveType {
	
	@Id
	@Column(name="leave_type_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int leaveTypeId;
	private String leaveName;
	private int maxDaysAllowed;
	
	@OneToMany(mappedBy = "leaveType")
	private List<LeaveRequest> leaveRequests;
}
