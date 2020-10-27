package com.usrmgmt.app.bean;

public class AppResponse {

	private String errorMessage;
	private boolean status;
	private ResponseUserData data;
	public AppResponse(String errorMessage, boolean status, ResponseUserData data) {
		super();
		this.errorMessage = errorMessage;
		this.status = status;
		this.data = data;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public ResponseUserData getData() {
		return data;
	}
	public void setData(ResponseUserData data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "LoginResponse [errorMessage=" + errorMessage + ", status=" + status + ", loginResponseUserData="
				+ data + "]";
	}
}