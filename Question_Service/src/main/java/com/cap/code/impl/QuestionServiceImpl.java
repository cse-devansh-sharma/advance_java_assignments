package com.cap.code.impl;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cap.code.model.Question;
import com.cap.code.repository.QuestionRepository;
import com.cap.code.service.*;


@Service
public class QuestionServiceImpl implements QuestionService{
	
	private QuestionRepository questionRepository;
	
	public QuestionServiceImpl(QuestionRepository questionRepository) {
		this.questionRepository=questionRepository;
	}

	@Override
	public Question create(Question question) {
		// TODO Auto-generated method stub
		return questionRepository.save(question);
	}

	@Override
	public List<Question> getAll() {
		// TODO Auto-generated method stub
		return questionRepository.findAll();
	}

	@Override
	public Question get(Long id) {
		// TODO Auto-generated method stub
		return questionRepository.findById(id).orElseThrow(()->new  RuntimeException("Question Not Found"));
	}

	@Override
	public List<Question> getByQuizId(Long quizId) {
		// TODO Auto-generated method stub
		return questionRepository.findByQuizId(quizId);
	}

}
