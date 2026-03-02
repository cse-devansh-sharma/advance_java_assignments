package com.cap.lms.service;

import org.springframework.stereotype.Service;
import com.cap.lms.repository.EmployeeRepository;
import com.cap.lms.model.*;
import java.util.*;

@Service
public class EmployeeService {
	
	private EmployeeRepository empRepository;
	public EmployeeService(EmployeeRepository empRepository){
		this.empRepository=empRepository;
	}
	
	
	public List<Employee> getAllEmployees(){
		List<Employee> allEmployees=empRepository.findAll();
		return allEmployees;
	}
	
	public void saveEmployee(Employee emp) {
		empRepository.save(emp);
		System.out.println("Employee Saved");
	}
	
	public void updateEmployee(Employee emp, Integer id) {
		if(empRepository.findById(id)!=null) {
			empRepository.save(emp);
			System.out.println("Employee Details Updated");
		}
		System.out.println("Employee Not Found");
		
	}
	
	public void deleteEmployee(Integer id) {
		if(empRepository.findById(id)!=null) {
			empRepository.deleteById(id);
			System.out.println("Employee Deleted");
		}
		System.out.println("Employee Not Found");
	}
}
