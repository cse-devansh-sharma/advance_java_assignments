package com.cap.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cap.lms.model.LeaveType;


@Repository
public interface LeaveTypeRepository extends JpaRepository<LeaveType,Integer>{

}
