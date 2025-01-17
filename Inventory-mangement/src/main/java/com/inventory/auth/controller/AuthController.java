package com.inventory.auth.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.auth.jpa.dto.JwtAuthResponse;
import com.inventory.auth.jpa.dto.RegisterDto;
import com.inventory.auth.jpa.dto.UserDTO;
import com.inventory.auth.service.AuthService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/api/auth")
@SecurityRequirement(name = "bearerAuth")
public class AuthController {

	private AuthService authService;

	public AuthController(AuthService authService) {
		super();
		this.authService = authService;
	}

	@PostMapping("/login")
	public ResponseEntity<JwtAuthResponse> login(@RequestBody UserDTO userDTO) {
		JwtAuthResponse jwtAuthResponse = authService.Login(userDTO);

		// JwtAuthResponse jwtAuthResponse = new JwtAuthResponse();

		// jwtAuthResponse.setAccessToken(token);
		// System.out.println("jwtAuthResponse : " + jwtAuthResponse);
		return ResponseEntity.ok(jwtAuthResponse);

	}

	@PostMapping("/register")
	public ResponseEntity<String> Register_user(@RequestBody RegisterDto registerDto) throws Exception {
		String response = authService.Register(registerDto);
		System.out.println("register");
		return new ResponseEntity<>(response, HttpStatus.CREATED);

	}
}
