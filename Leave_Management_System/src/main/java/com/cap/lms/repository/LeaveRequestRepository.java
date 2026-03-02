package com.cap.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cap.lms.model.*;


@Repository
public interface LeaveRequestRepository extends JpaRepository<LeaveRequest,Integer>{

}
