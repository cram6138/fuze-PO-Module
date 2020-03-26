package com.po.reservation.form;

import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.po.reservation.info.UserInfo;

public class ContainerForm {

	private String territory;
	private String market;
	private String subMarket;
	private String localMarket;
	private String containerCode;
	private String buyer;
	private int projectId;
	private String searchKey;
	private UserInfo userInfo;

	public ContainerForm() {}
	
	public ContainerForm(String territory, String market, String subMarket, String localMarket, String containerCode,
			String buyer, @Min(0) int projectId, String searchKey,UserInfo userInfo) {
		super();
		this.territory = territory;
		this.market = market;
		this.subMarket = subMarket;
		this.localMarket = localMarket;
		this.containerCode = containerCode;
		this.buyer = buyer;
		this.projectId = projectId;
		this.searchKey = searchKey;
		this.userInfo = userInfo;
	}

	public String getTerritory() {
		return territory;
	}

	public void setTerritory(String territory) {
		this.territory = territory;
	}

	public String getMarket() {
		return market;
	}

	public void setMarket(String market) {
		this.market = market;
	}

	public String getSubMarket() {
		return subMarket;
	}

	public void setSubMarket(String subMarket) {
		this.subMarket = subMarket;
	}

	public String getLocalMarket() {
		return localMarket;
	}

	public void setLocalMarket(String localMarket) {
		this.localMarket = localMarket;
	}

	public String getContainerCode() {
		return containerCode;
	}

	public void setContainerCode(String containerCode) {
		this.containerCode = containerCode;
	}

	public String getBuyer() {
		return buyer;
	}

	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getSearchKey() {
		return searchKey;
	}

	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	@Override
	public String toString() {
		return "ContainerForm [territory=" + territory + ", market=" + market + ", subMarket=" + subMarket
				+ ", localMarket=" + localMarket + ", containerCode=" + containerCode + ", buyer=" + buyer
				+ ", projectId=" + projectId + ", searchKey=" + searchKey + ",userInfo= " + userInfo + "]";
	}
}
