package com.taleemlink.dto;

import lombok.Data;

@Data
public class SignupRequest {

    private String name;
    private String email;
    private String role; 
    private String password;
    
}
