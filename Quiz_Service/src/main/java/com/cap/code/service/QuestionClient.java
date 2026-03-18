package com.cap.code.service;

import java.util.List;
import com.cap.code.model.*;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url="http://localhost:8082",value="Question-Client")
public interface QuestionClient {
	
	
	@GetMapping("/question/quiz/{quizId}")
	List<Question> getQuestionOfQuiz(@PathVariable long quizId);

}
