package com.inventory.controller;

import java.io.Console;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.dto.JwtAuthResponse;
import com.inventory.dto.RegisterDto;
import com.inventory.dto.UserDTO;
import com.inventory.service.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	private AuthService authService;

	public AuthController(AuthService authService) {
		super();
		this.authService = authService;
	}
	
	@PostMapping("/login")
	public ResponseEntity<JwtAuthResponse> login(@RequestBody UserDTO userDTO)
	{
		String token = authService.Login(userDTO);
		
		JwtAuthResponse jwtAuthResponse=new JwtAuthResponse();
		
		jwtAuthResponse.setAcessToken(token);
		return ResponseEntity.ok(jwtAuthResponse);
		
	}

	@PostMapping("/register")
	public ResponseEntity<String> Register_user(@RequestBody RegisterDto registerDto ) throws Exception
	{
		String response=authService.Register(registerDto);
		System.out.println("register");
		return new ResponseEntity<>(response,HttpStatus.CREATED);
		
	}
}
