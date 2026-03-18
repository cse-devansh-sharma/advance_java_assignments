package com.cap.code.dto;

public class EmployeeResponseDTO {
	
	 	private Long empId;
	    private String firstName;
	    private String lastName;
	    private String email;
	    private double salary;

	    private Long deptId;
	    private String deptName;
	    private  String location;
		public EmployeeResponseDTO(Long empId, String firstName, String lastName, String email, double salary,
				Long deptId, String deptName, String location) {
			super();
			this.empId = empId;
			this.firstName = firstName;
			this.lastName = lastName;
			this.email = email;
			this.salary = salary;
			this.deptId = deptId;
			this.deptName = deptName;
			this.location = location;
		}
		public Long getEmpId() {
			return empId;
		}
		public void setEmpId(Long empId) {
			this.empId = empId;
		}
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
		public Long getDeptId() {
			return deptId;
		}
		public void setDeptId(Long deptId) {
			this.deptId = deptId;
		}
		public String getDeptName() {
			return deptName;
		}
		public void setDeptName(String deptName) {
			this.deptName = deptName;
		}
		public String getLocation() {
			return location;
		}
		public void setLocation(String location) {
			this.location = location;
		}

}
