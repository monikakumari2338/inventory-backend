package com.inventory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;

@SpringBootApplication
@SecurityScheme(name = "bearerAuth", type = SecuritySchemeType.HTTP, bearerFormat = "JWT", scheme = "bearer")
@EnableScheduling
public class InventoryMangementApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryMangementApplication.class, args);
	}
	
	  @Bean
      public WebMvcConfigurer corsConfigurer()
      {
          return new WebMvcConfigurer() {
              @Override
              public void addCorsMappings(CorsRegistry registry) {
                  registry.addMapping("/**").allowedOrigins("exp://10.188.172.165:8081");
                  registry.addMapping("/**").allowedOrigins("http://localhost:5173");
              }
          };
      }

}
