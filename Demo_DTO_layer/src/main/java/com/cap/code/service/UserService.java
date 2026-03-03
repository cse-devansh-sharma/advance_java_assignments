package com.cap.code.service;
import com.cap.code.model.*;
import com.cap.code.repository.*;
import com.cap.code.dto.*;

import java.util.*;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	private UserRepository userRepository;
	private PasswordEncoder passwordEncoder;
	
	public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository=userRepository;
		this.passwordEncoder=passwordEncoder;
	}
	
	public UserResponseDto createUser(UserRequestDto userRequestDto) {
		
		String encodedPassword=passwordEncoder.encode(userRequestDto.getPassword());
		User user=Mapper.toEntity(userRequestDto);
		user.setPassword(encodedPassword);
		
		User saved=userRepository.save(user);
		return Mapper.toDto(saved);
	}
	
	public List<UserResponseDto> getAllUsers(){
		return userRepository.findAll().stream().map(Mapper::toDto).toList();
	}
	
}
