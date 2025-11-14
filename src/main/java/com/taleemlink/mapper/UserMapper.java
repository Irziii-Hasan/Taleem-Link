package com.taleemlink.mapper;

import com.taleemlink.dto.UserDto;
import com.taleemlink.model.User;

public class UserMapper {

    public static UserDto toDto(User user) {
        UserDto dto = new UserDto();

        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setRole(user.getRole().name());

        return dto;
    }

    public static User toEntity(UserDto dto) {
        User user = new User();

        user.setId(dto.getId());
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        // password intentionally skip — authentication ke ilawa expose nahi hota
        // role bhi controller ya service set karegi

        return user;
    }
}
