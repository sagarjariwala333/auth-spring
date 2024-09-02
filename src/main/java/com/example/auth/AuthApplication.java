package com.example.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.example.auth.dao.AuthRepository;
import com.example.auth.entity.Auth;

@SpringBootApplication
public class AuthApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(AuthApplication.class, args);
		applicationContext.getBean(AuthRepository.class);
	}
}
