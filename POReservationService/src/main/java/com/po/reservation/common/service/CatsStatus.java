package com.po.reservation.common.service;

public enum CatsStatus {

	AVAILABLE_ACCESS("EA"),
	RESERVED_ACCESS("ER"),
	RECIEVED("C");
	
	private String value;
	
	private CatsStatus(String key) {
		this.value = key;
	}
	
	public String getValue() {
		return this.value;
	}
}
