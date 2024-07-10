package com.inventory.serviceimpl;

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

import com.inventory.dto.RegisterDto;
import com.inventory.dto.UserDTO;
import com.inventory.entity.Role;
import com.inventory.entity.User;
import com.inventory.exception.ExceptionHandling;
import com.inventory.repository.RoleRepo;
import com.inventory.repository.UserRepo;
import com.inventory.security.JwtTokenProvider;
import com.inventory.service.AuthService;

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
	public String Login(UserDTO userDto) {
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
		return token;
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
		Set<Role> roles = new HashSet<>();
		Role userRole = roleRepo.findByName("User").get();
		roles.add(userRole);
		user.setRoles(roles);

		userRepo.save(user);
		return "User Registered Successfully";
	}

}
