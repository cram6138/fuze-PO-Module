package com.fuze.po.PurchaseOrderAppUI.auth;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserCredential {

	//@JsonProperty
	private String username;
	//@JsonProperty
	private String password;

	public UserCredential(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public UserCredential() {
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
