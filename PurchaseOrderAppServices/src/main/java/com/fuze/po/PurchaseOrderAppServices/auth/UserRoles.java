package com.fuze.po.PurchaseOrderAppServices.auth;

public enum UserRoles {
	
	ADMIN("ADMIN"),
	EMPLOYEE("EMPLOYEE"),
	CUSTOMER("CUSTOMER"),
	MANAGER("MANAGER"),
	BUYER("BUYER"),
	ENGINEER("ENGINEER");
	
	private String value;

	private UserRoles(String role) {
		this.value = role;
	}
	
	public String getValue() {
		return this.value;
	}
}
