package com.cap.code.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cap.code.model.Student;


@Repository
public interface StudentRepo extends JpaRepository<Student,Long>{

}
