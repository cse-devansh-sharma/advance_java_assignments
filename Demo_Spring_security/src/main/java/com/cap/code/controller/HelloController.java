package com.cap.code.controller;
import org.springframework.web.bind.annotation.*;


@RestController
public class HelloController {

	@GetMapping("/")
	public String greet() {
		return "Welcome to telusko";
	}
}
