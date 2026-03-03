package com.cap.code.dto;

import com.cap.code.model.*;

public class Mapper {
	
	public static User toEntity(UserRequestDto userRequestDto) {
		User user =new User(userRequestDto.getFirstName(), userRequestDto.getLastName(),userRequestDto.getEmail(), userRequestDto.getPassword());
		return user;
	}
	
	public static UserResponseDto toDto(User user) {
		return new UserResponseDto(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail());
	}

}
