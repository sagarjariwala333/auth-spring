package com.example.auth.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.auth.dao.AuthRepository;
import com.example.auth.entity.Auth;
import com.example.auth.services.interfaces.IAuthService;

@Service
public class AuthService implements IAuthService {

	@Autowired
	private AuthRepository authRepository;
	
	@Override
	public Optional<Auth> getCredentials(long userId) {
		// TODO Auto-generated method stub
		Optional<Auth> credentials = authRepository.findByUserId(userId);
		return credentials;
	}

	@Override
	public Auth setCreadetials(Auth auth) {
		// TODO Auto-generated method stub
		Auth credentials = authRepository.save(auth);
		return credentials;
	}

	@Override
	public void deleteCredentials(long id) {
		// TODO Auto-generated method stub
		authRepository.deleteById(id);
	}

	@Override
	public Auth updateRole(long id, String role) {
		// TODO Auto-generated method stub
		Optional<Auth> auth = authRepository.findByUserId(id);
		Auth credetial = auth.get();
		credetial.setRole(role);
		Auth updatedAuth = authRepository.save(credetial);
		return updatedAuth;
	}

	@Override
	public Auth updatePassword(long id, String password) {
		// TODO Auto-generated method stub
		Optional<Auth> auth = authRepository.findByUserId(id);
		Auth credetial = auth.get();
		credetial.setPassword(password);
		Auth updatedAuth = authRepository.save(credetial);
		return updatedAuth;
	}
}
