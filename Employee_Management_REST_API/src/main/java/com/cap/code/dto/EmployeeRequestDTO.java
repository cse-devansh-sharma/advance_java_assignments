package com.cap.code.dto;

import com.cap.code.model.Department;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class EmployeeRequestDTO {
		
		@NotBlank(message = "First name is required")
	    private String firstName;
		
		 @NotBlank(message = "Email cannot be blank")
	    private String lastName;
	    
	    @Email(message = "Email must be valid")
	    @NotBlank(message = "Email cannot be blank")
	    private String email;
	    
	    @Positive(message="Salary can't be negative")
	    private double salary;
	    
	    private Department department;


		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public double getSalary() {
			return salary;
		}

		public void setSalary(double salary) {
			this.salary = salary;
		}

		public Department getDepartment() {
			return department;
		}

		public void setDepartment(Department department) {
			this.department = department;
		}
	    
	
}
