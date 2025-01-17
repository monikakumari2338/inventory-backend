package com.inventory.auth.service;

import com.inventory.auth.jpa.dto.JwtAuthResponse;
import com.inventory.auth.jpa.dto.RegisterDto;
import com.inventory.auth.jpa.dto.UserDTO;

public interface AuthService {

	JwtAuthResponse Login(UserDTO userDto);

	String Register(RegisterDto registerDto) throws Exception;
}
