package com.example.auth.services.interfaces;

import java.util.Optional;

import com.example.auth.entity.Auth;

public interface IAuthService {
	public Optional<Auth> getCredentials(long userId);
	public Auth setCreadetials(Auth auth);
	public void deleteCredentials(long id);
	public Auth updateRole(long id, String role);
	public Auth updatePassword(long id, String password);
}
