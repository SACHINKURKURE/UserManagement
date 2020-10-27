package com.usrmgmt.app.bean;

public class AppUserBean {
	private String id;
	private String userName;
    private String password;
    private String gender;
    private String token;

	public AppUserBean(String id, String userName, String password, String gender) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.gender = gender;
		this.token = id+userName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	@Override
	public String toString() {
		return "AppUserBean [id=" + id + ", userName=" + userName + ", password=" + password + ", gender=" + gender
				+ ", token=" + token + "]";
	}
}