package com.taleemlink.service;

import java.util.List;

import com.taleemlink.dto.SignupRequest;
import com.taleemlink.dto.UserDto;

public interface UserService {
	UserDto createUser(UserDto userDto);
	List<UserDto> getAllUsers();
	UserDto getUserById(Long id);
	void deletedUser(Long id);
	UserDto updateUser(Long id, UserDto userDto);
	UserDto register(SignupRequest request);

	
	
}
