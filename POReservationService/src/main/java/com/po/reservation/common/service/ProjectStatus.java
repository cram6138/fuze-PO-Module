package com.po.reservation.common.service;

public enum ProjectStatus {

	OPEN("O"),
	INSERVICE("I"),
	CANCEL("C"),
	FUZE("FUZE");
	
	private String value;
	
	private ProjectStatus(String key) {
		this.value = key;
	}
	
	public String getValue() {
		return this.value;
	}

}
