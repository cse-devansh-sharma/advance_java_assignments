package com.cap.code.service;

import org.springframework.stereotype.Service;
import com.cap.code.Repository.*;
import com.cap.code.model.*;

@Service
public class ParientService {
	private PatientRepo patientRepo;
	private DoctorRepo doctorRepo;
	
	
	public ParientService(PatientRepo patientRepo, DoctorRepo doctorRepo) {
		this.doctorRepo=doctorRepo;
		this.patientRepo=patientRepo;
	}
}