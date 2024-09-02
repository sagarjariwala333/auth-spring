package com.example.auth.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.auth.dto.LoginRequest;
import com.example.auth.entity.Auth;
import com.example.auth.services.AuthService;
import com.example.auth.utils.JwtUtil;
import com.example.auth.utils.PasswordUtil;

@RestController
@RequestMapping(path = "/api/auth")
public class AuthController {

    private final AuthService authService;

    // Constructor injection is preferred for better testability and immutability
    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }
    
    @PostMapping(path = "/signup")
    public ResponseEntity<?> register(@RequestBody Auth auth) {
    	try {
    		if (authService.getCredentials(auth.getUserId()).isPresent()) {
    			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User alredy exist");
    		}
    		auth.setPassword(PasswordUtil.encodePassword(auth.getPassword()));
    		Auth savedAuth = authService.setCreadetials(auth);
    		return ResponseEntity.status(HttpStatus.OK).body(savedAuth);
    	}
    	catch (Exception ex) {
    		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
    	}
    }
    
    @PostMapping(path = "/signin")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
    	try {
    		Optional<Auth> auth = authService.getCredentials(loginRequest.getUserId());
    		boolean isAutheticated = PasswordUtil.matches(loginRequest.getPassword(), auth.get().getPassword());
    		if(!isAutheticated) {
    			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
    		}
    		String token = JwtUtil.generateToken(loginRequest.getUserId());
    		return ResponseEntity.status(HttpStatus.OK).body(token);
    	}
    	catch (Exception e) {
			// TODO: handle exception
    		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
    }
}
