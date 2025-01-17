package com.inventory.auth.service;

import java.util.HashSet;

import java.util.Optional;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.inventory.auth.jpa.dto.JwtAuthResponse;
import com.inventory.auth.jpa.dto.RegisterDto;
import com.inventory.auth.jpa.dto.UserDTO;
import com.inventory.auth.jpa.entity.Role;
import com.inventory.auth.jpa.entity.User;
import com.inventory.auth.jpa.security.JwtTokenProvider;
import com.inventory.exception.ExceptionHandling;
import com.inventory.repository.RoleRepo;
import com.inventory.repository.UserRepo;

@Service
public class AuthServiceImpl implements AuthService {

	private AuthenticationManager authenticationManager;
	private UserRepo userRepo;
	private RoleRepo roleRepo;
	private PasswordEncoder passwordEncoder;
	private JwtTokenProvider jwtTokenProvider;

	public AuthServiceImpl(AuthenticationManager authenticationManager, UserRepo userRepo, RoleRepo roleRepo,
			PasswordEncoder passwordEncoder, JwtTokenProvider jwtTokenProvider) {
		super();
		this.authenticationManager = authenticationManager;
		this.userRepo = userRepo;
		this.roleRepo = roleRepo;
		this.passwordEncoder = passwordEncoder;
		this.jwtTokenProvider = jwtTokenProvider;
	}

	@Override
	public JwtAuthResponse Login(UserDTO userDto) {
		// System.out.println("userDto.getPassword: " + userDto.getPassword());
		User user = userRepo.findByEmail(userDto.getEmail()).get();

//		System.out.println("store  : "+ userDto.getStoreName());
//		System.out.println("user :" + user);

		if (user == null) {
			throw new ExceptionHandling(HttpStatus.BAD_REQUEST, "Please enter right credentials");
		}

		if (!(user.getStoreName().equals(userDto.getStoreName()))) {
			throw new ExceptionHandling(HttpStatus.BAD_REQUEST, "Please select the associated store");
		}

		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(userDto.getEmail(), userDto.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		String token = jwtTokenProvider.generateToken(authentication);
	
		JwtAuthResponse jwtAuthResponse = new JwtAuthResponse();

		jwtAuthResponse.setAccessToken(token);
		jwtAuthResponse.setUser(user.getName());
		return jwtAuthResponse;
	}

	@Override
	public String Register(RegisterDto registerDto) throws Exception {

		if (userRepo.existsByEmail(registerDto.getEmail())) {
			throw new Exception("Email already exits");
		}

		User user = new User();
		user.setName(registerDto.getName());
		user.setEmail(registerDto.getEmail());
		user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
		user.setStoreName(registerDto.getStoreName());
		Set<Role> roles = new HashSet<>();
		Role userRole = roleRepo.findByName("User").get();
		roles.add(userRole);
		user.setRoles(roles);

		userRepo.save(user);
		return "User Registered Successfully";
	}

}
