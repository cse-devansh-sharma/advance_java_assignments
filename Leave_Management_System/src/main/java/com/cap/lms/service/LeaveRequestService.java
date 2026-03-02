package com.cap.lms.service;
import com.cap.lms.repository.*;
import com.cap.lms.model.*;

import org.springframework.stereotype.Service;

@Service
public class LeaveRequestService {
	
	private LeaveRequestRepository leaveRequestRepository;
	public LeaveRequestService(LeaveRequestRepository leaveRequestRepository) {
		this.leaveRequestRepository=leaveRequestRepository;
	}
	
	public void applyLeave(Employee emp, LeaveType leaveType) {
		
	}

}
