package com.po.reservation.form;

import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class ContainerForm {

	private String territory;
	private String market;
	private String subMarket;
	private String localMarket;
	private String containerCode;
	private String buyer;
	@Min(1)
	private int projectId;
	private String searchKey;

	public ContainerForm() {}
	
	public ContainerForm(String territory, String market, String subMarket, String localMarket, String containerCode,
			String buyer, @Min(0) int projectId, String searchKey) {
		super();
		this.territory = territory;
		this.market = market;
		this.subMarket = subMarket;
		this.localMarket = localMarket;
		this.containerCode = containerCode;
		this.buyer = buyer;
		this.projectId = projectId;
		this.searchKey = searchKey;
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

	@Override
	public String toString() {
		return "ContainerForm [territory=" + territory + ", market=" + market + ", subMarket=" + subMarket
				+ ", localMarket=" + localMarket + ", containerCode=" + containerCode + ", buyer=" + buyer
				+ ", projectId=" + projectId + ", searchKey=" + searchKey + "]";
	}
}
