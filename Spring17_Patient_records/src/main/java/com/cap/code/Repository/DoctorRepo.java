package com.cap.code.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cap.code.model.Doctor;

import jakarta.persistence.Entity;


@Repository
public interface DoctorRepo extends JpaRepository<Doctor,Long>{

}
