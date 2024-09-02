package com.example.auth.dto;

public class LoginRequest {
	
	private long userId;
	private String password;
	
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public LoginRequest(long userId, String password) {
		super();
		this.userId = userId;
		this.password = password;
	}
	public LoginRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "LoginRequest [userId=" + userId + ", password=" + password + "]";
	}
	
}
