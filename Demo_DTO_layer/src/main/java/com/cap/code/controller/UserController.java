package com.cap.code.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cap.code.dto.*;
import java.util.List;
import com.cap.code.service.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {
	private UserService userService;
	
	public UserController(UserService userService) {
		this.userService=userService;
	}
	
	@GetMapping()
	public List<UserResponseDto> allUsers(){
		return userService.getAllUsers();
	}
	
	@PostMapping()
	public UserResponseDto createUser(@Valid @RequestBody UserRequestDto userRequestDto) {
		return userService.createUser(userRequestDto);
	}
	
}
