package com.cap.code;
import java.util.*;
import java.util.stream.*;

public class GroupingByPractice {

    // ─── Employee class ───────────────────────────────────────────
    static class Employee {
        String name;
        String department;
        double salary;
        int age;

        Employee(String name, String department, double salary, int age) {
            this.name = name;
            this.department = department;
            this.salary = salary;
            this.age = age;
        }

        public String getName()       { return name; }
        public String getDepartment() { return department; }
        public double getSalary()     { return salary; }
        public int getAge()           { return age; }

        @Override
        public String toString() {
            return name + "(" + department + ", ₹" + salary + ")";
        }
    }

    // ─── Sample data ──────────────────────────────────────────────
    static List<Employee> employees = List.of(
        new Employee("Devansh",  "Engineering", 85000, 22),
        new Employee("Aman",     "Engineering", 92000, 25),
        new Employee("Priya",    "Engineering", 78000, 23),
        new Employee("Sneha",    "HR",          55000, 28),
        new Employee("Rahul",    "HR",          60000, 30),
        new Employee("Kiran",    "Finance",     70000, 35),
        new Employee("Meera",    "Finance",     74000, 29),
        new Employee("Arjun",    "Finance",     68000, 27)
    );
    
    public static void main(String args[]) {
    	
//    	Map<String,List<Employee>> departmentWise=employees.stream().collect(Collectors.groupingBy(Employee::getDepartment));
//    	
//    	for(Map.Entry<String, List<Employee>> emp:departmentWise.entrySet()) {
//    		System.out.println(emp.getKey());
//    		for(Employee em:emp.getValue()) {
//    			System.out.println(em);
//    		}
//    	}
//    	
////    	Map<String,Long> counts=employees.stream().collect(Collectors.groupingBy(emp->emp.getDepartment(),Collectors.counting()));
////    	System.out.println(counts);
//    	
//    	List<Employee> higher=departmentWise.entrySet().stream().map(emp->emp.getValue()).flatMap(List::stream).filter(a->a.getSalary()>40000).toList();
//    	System.out.println(higher);
//    	
//    	
//    	Map<String, Double> averageSalary=employees.stream().collect(Collectors.groupingBy(emp->emp.getDepartment(),Collectors.averagingDouble(emp->emp.getSalary())));
//    	System.out.println(averageSalary );
    	
    	Map<String,List<Employee>> sortBysalary=employees.stream().filter(a->a.getSalary()>50000).collect(Collectors.groupingBy(Employee::getDepartment));
    	System.out.println(sortBysalary);
    	
    	String name="Devansh Sharma is a boy";
    	
    	String result=Arrays.stream(name.split(" ")).reduce((a,b)->b+" "+a).orElse("");
    	System.out.println(result);
    }
}
