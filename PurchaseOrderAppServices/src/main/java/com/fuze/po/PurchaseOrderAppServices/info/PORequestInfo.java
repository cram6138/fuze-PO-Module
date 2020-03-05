package com.fuze.po.PurchaseOrderAppServices.info;

import java.util.Set;

/**
 * @author Bhajuram.c
 *
 */
public class PORequestInfo {

	private int id;
	private String pslc;
	private String poName;
	private String teritory;
	private String market;
	private String poStatus;
	private Set<ProjectInfo> projects;
	private Set<ItemInfo> items;
	private String siteTracker;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPslc() {
		return pslc;
	}

	public void setPslc(String pslc) {
		this.pslc = pslc;
	}

	public String getPoName() {
		return poName;
	}

	public void setPoName(String poName) {
		this.poName = poName;
	}

	public String getTeritory() {
		return teritory;
	}

	public void setTeritory(String teritory) {
		this.teritory = teritory;
	}

	public String getMarket() {
		return market;
	}

	public void setMarket(String market) {
		this.market = market;
	}

	public String getPoStatus() {
		return poStatus;
	}

	public void setPoStatus(String poStatus) {
		this.poStatus = poStatus;
	}

	public Set<ProjectInfo> getProjects() {
		return projects;
	}

	public void setProjects(Set<ProjectInfo> projects) {
		this.projects = projects;
	}

	public Set<ItemInfo> getItems() {
		return items;
	}

	public void setItems(Set<ItemInfo> items) {
		this.items = items;
	}

	public String getSiteTracker() {
		return siteTracker;
	}

	public void setSiteTracker(String siteTracker) {
		this.siteTracker = siteTracker;
	}

}
