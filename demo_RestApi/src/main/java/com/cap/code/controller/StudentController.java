package com.cap.code.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.cap.code.model.*;
import com.cap.code.exception.*;

import com.cap.code.service.*;



@RestController
@RequestMapping("/student")
public class StudentController {
	private StudentService studentService;
	
	public StudentController(StudentService studentService) {
		this.studentService=studentService;
	}
	
	@GetMapping()
	public ResponseEntity<List<Student>> getStudents(){
		return ResponseEntity.ok(studentService.getAllStudents());
	}
	
	
	@PostMapping()
	public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
		return new ResponseEntity<>(studentService.saveStudent(student),HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Student> findById(@PathVariable int id) throws StudentNotFoundException {
		Student temp=studentService.findStudentById(id);
		return ResponseEntity.ok(temp);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable int id, @RequestBody Student student) throws StudentNotFoundException{
		Student updated=studentService.updateStudent(id, student);
		return ResponseEntity.ok(updated);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable Integer id) throws StudentNotFoundException{
		studentService.deleteStudent(id);
		return ResponseEntity.ok("Student deleted successfully");
	}

}
