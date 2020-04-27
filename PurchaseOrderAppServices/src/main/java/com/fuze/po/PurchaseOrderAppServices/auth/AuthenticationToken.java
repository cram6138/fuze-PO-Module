package com.fuze.po.PurchaseOrderAppServices.auth;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthenticationToken {

	@JsonProperty
	private String accessToken;
	@JsonProperty
	private String message;
	@JsonProperty
	private String sessionId;
	@JsonProperty
	private UserInfo userInfo;
	
	

	public AuthenticationToken() {
	}

	public AuthenticationToken(String accessToken, String message, UserInfo userInfo) {
		super();
		this.accessToken = accessToken;
		this.message = message;
		this.userInfo = userInfo;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getMessage() {
		return message;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	
	
}
