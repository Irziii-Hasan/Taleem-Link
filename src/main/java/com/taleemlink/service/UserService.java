package com.taleemlink.service;

import java.util.List;

import com.taleemlink.dto.UserDto;

public interface UserService {
	UserDto createUser(UserDto userDto);
	List<UserDto> getAllUsers();
	UserDto getUserbyId(Long id);
	
}
