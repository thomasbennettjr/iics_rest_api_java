package com.metaopsis.icsapi.helper;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ValidSessionIdRequest {
	@JsonProperty("@type")
	private String type = "validatedToken";
	private String userName;
	private String icToken;
	
	public ValidSessionIdRequest(String userName, String icToken) {
		this.userName = userName;
		this.icToken = icToken;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getIcToken() {
		return icToken;
	}

	public void setIcToken(String icToken) {
		this.icToken = icToken;
	}

	@Override
	public String toString() {
		return "ValidSessionIdRequest [type=" + type + ", userName=" + userName + ", icToken=" + icToken + "]";
	}
	
	
	
}
