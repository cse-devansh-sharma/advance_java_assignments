package com.cap.code.impl;
import java.util.List;
import java.util.function.Function;

import org.springframework.stereotype.Service;

import com.cap.code.model.Quiz;
import com.cap.code.service.*;
import com.cap.code.repository.*;

@Service
public class QuizServiceImpl implements QuizService{
	
	private QuizRepository quizRepository;
	private QuestionClient questionClient;
	
	

	public QuizServiceImpl(QuizRepository quizRepository, QuestionClient questionClient) {
		this.quizRepository = quizRepository;
		this.questionClient = questionClient;
	}

	@Override
	public Quiz add(Quiz quiz) {
		// TODO Auto-generated method stub
		return quizRepository.save(quiz);
	}

	@Override
	public List<Quiz> get() {
		// TODO Auto-generated method stub
		List<Quiz> quizzez=quizRepository.findAll();
		
		List<Quiz> newQuizList=quizzez.stream().map(quiz->{
			quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getId()));
			return quiz;
		}).toList();
		
		return newQuizList;
	}

	@Override
	public Quiz get(Long id) {
		// TODO Auto-generated method stub
		return quizRepository.findById(id).orElseThrow(()->new RuntimeException("Quiz not Found"));
	}

}
