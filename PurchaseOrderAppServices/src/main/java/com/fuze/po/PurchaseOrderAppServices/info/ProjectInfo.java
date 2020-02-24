package com.fuze.po.PurchaseOrderAppServices.info;

import javax.persistence.Column;

public class ProjectInfo {

	private int id;
	private String siteName;
	private String projectName;
	private String market;
	private String subMarket;
	private String projectType;
	private String fuzeProject;
	private String pslc;
	private String projectStatus;
	private String type;
	private String customProjectType;
	private String siteTracker;
	private String teritory;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
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

	public String getProjectType() {
		return projectType;
	}

	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}

	public String getFuzeProject() {
		return fuzeProject;
	}

	public void setFuzeProject(String fuzeProject) {
		this.fuzeProject = fuzeProject;
	}

	public String getPslc() {
		return pslc;
	}

	public void setPslc(String pslc) {
		this.pslc = pslc;
	}

	public String getProjectStatus() {
		return projectStatus;
	}

	public void setProjectStatus(String projectStatus) {
		this.projectStatus = projectStatus;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCustomProjectType() {
		return customProjectType;
	}

	public void setCustomProjectType(String customProjectType) {
		this.customProjectType = customProjectType;
	}

	public String getSiteTracker() {
		return siteTracker;
	}

	public void setSiteTracker(String siteTracker) {
		this.siteTracker = siteTracker;
	}

	public String getTeritory() {
		return teritory;
	}

	public void setTeritory(String teritory) {
		this.teritory = teritory;
	}
	
}
