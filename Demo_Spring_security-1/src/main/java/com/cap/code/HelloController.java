package com.cap.code;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletRequest;


@RestController
public class HelloController {

	@GetMapping("/")
	public String greet(HttpServletRequest request) {
		return "Welcome to telusko "+request.getSession().getId();
	}
}       
