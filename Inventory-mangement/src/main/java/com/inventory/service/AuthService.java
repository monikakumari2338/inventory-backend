package com.inventory.service;

import com.inventory.dto.JwtAuthResponse;
import com.inventory.dto.RegisterDto;
import com.inventory.dto.UserDTO;

public interface AuthService {

	JwtAuthResponse Login(UserDTO userDto);

	String Register(RegisterDto registerDto) throws Exception;
}
