package com.cap.code.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cap.code.model.Question;
import com.cap.code.service.QuestionService;

@RestController
@RequestMapping("/question")
public class QuestionController {

	
	private QuestionService questionService;
	
	public QuestionController(QuestionService questionService) {
		this.questionService=questionService;
	}
	
	
	
	@PostMapping
	public Question create(@RequestBody Question question) {
		return questionService.create(question);
	}
	
	@GetMapping
	public List<Question>  getAll(){
		return questionService.getAll();
	}
	
	@GetMapping("/{id}")
	public Question get(@PathVariable Long id) {
		return questionService.get(id);
	}
	
	
	@GetMapping("/quiz/{quizId}")
	public List<Question> getQuestionofQuiz(@PathVariable Long quizId){
		return questionService.getByQuizId(quizId);
	}
	
	
}
