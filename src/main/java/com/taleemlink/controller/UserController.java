package com.taleemlink.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
		UserDto createdUser = userService.createUser(userDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);	
	}
	
	@GetMapping
	public ResponseEntity<List<UserDto>> getAllUser(){
		return ResponseEntity.ok(userService.getAllUsers());
	}
	
	@GetMapping ("/{id}")
	public ResponseEntity<UserDto> getUserbyId(@PathVariable Long id) {
		return ResponseEntity.ok(userService.getUserById(id));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<UserDto> updateUser(@PathVariable Long id, @RequestBody UserDto userDto){
		return ResponseEntity.ok(userService.updateUser(id, userDto));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUserById(@PathVariable Long id) {
		userService.deletedUser(id);
		return ResponseEntity.ok("User deleted successfully");
	}
}
