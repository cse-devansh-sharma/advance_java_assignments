package com.cap.code.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cap.code.service.QuizService;
import com.cap.code.model.*;

import java.util.*;

@RestController
@RequestMapping("/quiz")
public class QuizController {
	
	private QuizService quizService;

	public QuizController(QuizService quizService) {
		this.quizService = quizService;
	}
	
	
	//create
	@PostMapping
	public Quiz create(@RequestBody Quiz quiz) {
		return quizService.add(quiz);
	}
	
	//get all
	@GetMapping
	public List<Quiz> get(){
		return quizService.get();
	}
	
	//by id
	@GetMapping("/{id}")
	public Quiz getById(@PathVariable Long id) {
		return quizService.get(id);
	}
	
}
