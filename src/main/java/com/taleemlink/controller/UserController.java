package com.taleemlink.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taleemlink.dto.UserDto;
import com.taleemlink.service.UserService;

@RestController
@RequestMapping ("api/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping
	public UserDto createUser(@RequestBody UserDto userDto) {
		return userService.createUser(userDto);
	}
	
	@GetMapping
	public List<UserDto> getAllUser(){
		return userService.getAllUsers();
	}
	
	@GetMapping ("/{id}")
	public UserDto getUserbyId(@PathVariable Long id) {
		return userService.getUserbyId(id);
	}
	
}
