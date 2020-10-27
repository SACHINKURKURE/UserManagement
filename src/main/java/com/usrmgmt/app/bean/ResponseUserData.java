package com.usrmgmt.app.bean;

public class ResponseUserData {

	private String token;
	private UserDetail user;

	public ResponseUserData(String token, UserDetail user) {
		super();
		this.token = token;
		this.user = user;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public UserDetail getUser() {
		return user;
	}

	public void setUser(UserDetail user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "LoginResponseUserData [token=" + token + ", user=" + user + "]";
	}
}