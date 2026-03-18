package com.cap.code.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cap.code.model.*;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer>{
	List<Student> findAllByOrderByNameDesc();
	
	List<Student> findByNameStartingWith(String prefix);
	
	List<Student> findByNameEndingWith(String suffix);
	
	List<Student> findByIdGreaterThan(Integer id);
	
	Page<Student> findAll(Pageable pageable);

}
