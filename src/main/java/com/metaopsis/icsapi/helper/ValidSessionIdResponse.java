package com.metaopsis.icsapi.helper;

public class ValidSessionIdResponse {
	private int timeUntilExpire;
	private boolean isValidToken;
	
	public ValidSessionIdResponse(int timeUntilExpire, boolean isValidToken) {
		this.timeUntilExpire = timeUntilExpire;
		this.isValidToken = isValidToken;
	}
	
	
	
	public ValidSessionIdResponse() {
	}



	public int getTimeUntilExpire() {
		return timeUntilExpire;
	}

	public void setTimeUntilExpire(int timeUntilExpire) {
		this.timeUntilExpire = timeUntilExpire;
	}

	public boolean isValidToken() {
		return isValidToken;
	}

	public void setIsValidToken(boolean isValidToken) {
		this.isValidToken = isValidToken;
	}

	@Override
	public String toString() {
		return "ValidSessionIdResponse [timeUntilExpire=" + timeUntilExpire + ", isValidToken=" + isValidToken + "]";
	}
	
	
}
