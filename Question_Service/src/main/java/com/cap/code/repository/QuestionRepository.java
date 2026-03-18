package com.cap.code.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cap.code.model.*;

public interface QuestionRepository extends JpaRepository<Question,Long>{
	List<Question> findByQuizId(Long quizId);
}
