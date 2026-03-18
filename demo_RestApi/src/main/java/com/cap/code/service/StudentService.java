package com.cap.code.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
		return studentRepository.findAllByOrderByNameDesc();
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
	
	public List<Student> specificNames(String prefix){
		return studentRepository.findByNameStartingWith(prefix);
	}
	
	public List<Student> specificSurnames(String suffix){
		return studentRepository.findByNameEndingWith(suffix);
	}
	
	public Page<Student> getAllStudents(int page, int size, String sortBy, String direction) {

        Sort sort = direction.equalsIgnoreCase("asc") ?
                Sort.by(sortBy).ascending() :
                Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(page, size, sort);

        return studentRepository.findAll(pageable);
    }
	
	
}
