package com.cap.code.service;
import java.util.List;

import com.cap.code.model.*;

public interface QuestionService {
	
	//create 
	public Question create(Question question);
	
	//get ALL
	
	public List<Question> getAll();
	
	//get by id
	
	public Question get(Long id);
	
	public List<Question> getByQuizId(Long quizId);

}
