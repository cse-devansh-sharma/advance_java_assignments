package com.cap.code.service;
import java.util.List;

import com.cap.code.model.*;

public interface QuizService {
	Quiz add(Quiz quiz);
	
	List<Quiz> get();
	
	Quiz get(Long id);
}
