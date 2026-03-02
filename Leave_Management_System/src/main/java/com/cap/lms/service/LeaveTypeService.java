package com.cap.lms.service;
import com.cap.lms.repository.*;

import java.util.List;

import org.springframework.stereotype.Service;
import com.cap.lms.model.*;

@Service
public class LeaveTypeService {
	LeaveTypeRepository leaveTypeRepository;
	
	public LeaveTypeService(LeaveTypeRepository leaveTypeRepository) {
		this.leaveTypeRepository=leaveTypeRepository;
	}
	
	public void addLeaveType(LeaveType leaveType) {
		leaveTypeRepository.save(leaveType);
		System.out.println("Leave Tyype Saved");
	}
	
	public List<LeaveType> viewLeaveTypes(){
		List<LeaveType> listLeaveTypes = leaveTypeRepository.findAll();
		return listLeaveTypes;
	}
	
}
