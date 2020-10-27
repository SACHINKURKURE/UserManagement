package com.usrmgmt.app.bean;

public class GenderMasterBean {
	private String errorMsg;
	private boolean status;
    private String genderData;
    
	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getGenderData() {
		return genderData;
	}

	public void setGenderData(String genderData) {
		this.genderData = genderData;
	}

	public GenderMasterBean(String errorMsg, boolean status, String genderData) {
		super();
		this.errorMsg = errorMsg;
		this.status = status;
		this.genderData = genderData;
	}

	@Override
	public String toString() {
		return "GenderMasterBean [errorMsg=" + errorMsg + ", status=" + status + ", genderData=" + genderData + "]";
	}
}