package com.inventory.config;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.inventory.security.JwtAuthenticationEntryPoint;
import com.inventory.security.JwtAuthenticationFilter;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

	private UserDetailsService userDetailsService;
	
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

	private JwtAuthenticationFilter jwtAuthenticationFilter;
	
	

public SecurityConfig(UserDetailsService userDetailsService,
			JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint, JwtAuthenticationFilter jwtAuthenticationFilter) {
		super();
		this.userDetailsService = userDetailsService;
		this.jwtAuthenticationEntryPoint = jwtAuthenticationEntryPoint;
		this.jwtAuthenticationFilter = jwtAuthenticationFilter;
	}

//	  @Bean
//	  public AuthTokenFilter authenticationJwtTokenFilter() {
//	    return new AuthTokenFilter();
//	  }

	  
	  @Bean
	  public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
	    return authConfig.getAuthenticationManager();
	  }

	  @Bean
	  public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	  }
	  
	  @Bean
	  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	    http.csrf(csrf -> csrf.disable())
	        .authorizeHttpRequests(auth -> 
	          auth.requestMatchers(HttpMethod.GET,"/api/auth/**").permitAll()
	          .requestMatchers("/api/auth/**").permitAll()
	              .anyRequest().authenticated()).httpBasic(Customizer.withDefaults()
	        ).exceptionHandling(exception -> exception.authenticationEntryPoint(jwtAuthenticationEntryPoint)
	        ).sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
	       	);
	    
	    http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
	    
	    return http.build();
	  }
}
