package com.usrmgmt.app.bean;

public class UserDetail {	
	private String id;
	private String userName;
    private String gender;
    
	public UserDetail(String id, String userName, String gender) {
		super();
		this.id = id;
		this.userName = userName;
		this.gender = gender;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "UserDetail [id=" + id + ", userName=" + userName + ", gender=" + gender + "]";
	}
}