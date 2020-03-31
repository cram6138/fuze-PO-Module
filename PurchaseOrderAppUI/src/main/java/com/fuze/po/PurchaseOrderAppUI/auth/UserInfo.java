package com.fuze.po.PurchaseOrderAppUI.auth;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;

public class UserInfo {

	private int id;
	private String username;
	private boolean isActive;
	private List<String> userRole;
	private String firstName;
	private String lastName;
	private Date createdOn;
	private String territory;
	private String Market;
	
	public String getTerritory() {
		return territory;
	}
	public void setTerritory(String territory) {
		this.territory = territory;
	}
	public String getMarket() {
		return Market;
	}
	public void setMarket(String market) {
		Market = market;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	public List<String> getUserRole() {
		return userRole;
	}
	public void setUserRole(List<String> userRole) {
		this.userRole = userRole;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	
	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", username=" + username + ", isActive=" + isActive + ", userRole=" + userRole
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", createdOn=" + createdOn + ", territory="
				+ territory + ", Market=" + Market + "]";
	}

	 
}
