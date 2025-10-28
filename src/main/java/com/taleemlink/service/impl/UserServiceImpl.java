package com.taleemlink.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.taleemlink.dto.UserDto;
import com.taleemlink.model.User;
import com.taleemlink.repository.UserRepository;
import com.taleemlink.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	
	
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public UserDto createUser(UserDto userDto) {
	    User user  = new User();
	    user.setName(userDto.getName());
	    user.setEmail(userDto.getEmail());

	    User savedUser = userRepository.save(user);

	    UserDto dto = new UserDto();
	    dto.setId(savedUser.getId()); 
	    dto.setName(savedUser.getName());
	    dto.setEmail(savedUser.getEmail());

	    return dto;
	}


	@Override
	public List<UserDto> getAllUsers() {
		List<User> users = userRepository.findAll();
		List<UserDto> userDtos = users.stream().map(user -> {
	        UserDto dto = new UserDto();
	        dto.setId(user.getId());
	        dto.setName(user.getName());
	        dto.setEmail(user.getEmail());
	        return dto;
	    }).collect(Collectors.toList());

		return userDtos;
	}

	@Override
	public UserDto getUserbyId(Long id) {
		User user =  userRepository.findById(id)
				.orElseThrow(()-> new RuntimeException("User not found with id: "+ id));
		UserDto dto = new UserDto();
		dto.setId(user.getId());
		dto.setName(user.getName());
		dto.setEmail(user.getEmail());
		
		return dto;
		
	}

}
