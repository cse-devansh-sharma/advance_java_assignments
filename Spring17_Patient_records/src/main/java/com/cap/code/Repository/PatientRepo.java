package com.cap.code.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cap.code.model.Patient;


@Repository
public interface PatientRepo extends JpaRepository<Patient,Long>{

}
