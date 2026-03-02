package com.cap.code.service;

import org.springframework.stereotype.Service;
import com.cap.code.repository.*;
import java.util.List;

import com.cap.code.exception.StudentNotFoundException;
import com.cap.code.model.*;

@Service
public class StudentService {
	private StudentRepository studentRepository;
	
	public StudentService(StudentRepository studentRepository) {
		this.studentRepository=studentRepository;
	}
	
	public List<Student>  getAllStudents(){
		return studentRepository.findAll();
	}
	
	public Student saveStudent(Student student) {
		studentRepository.save(student);
		return student;
	}
	
	public Student findStudentById(Integer id) {
		return studentRepository.findById(id).orElseThrow(()->new StudentNotFoundException("Student not found with id: " + id));
	}
	
	public Student updateStudent(Integer id, Student student){

        Student existingStudent = studentRepository.findById(id).orElseThrow(() ->new StudentNotFoundException("Student not found with id: " + id));
        existingStudent.setEmail(student.getEmail());
        existingStudent.setName(student.getName());
       
        return studentRepository.save(existingStudent);
    }
	
	public void deleteStudent(Integer id) throws StudentNotFoundException {

        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() ->
                        new StudentNotFoundException("Student not found with id: " + id));

        studentRepository.delete(existingStudent);
    }
	
	
}
