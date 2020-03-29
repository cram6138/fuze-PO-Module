package com.fuze.po.PurchaseOrderAppServices.forms;

import java.sql.Date;
import java.util.Set;

import javax.persistence.Column;

/**
 * @author Bhajuram.c
 *
 */
public class ProjectForm {

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
	private Date useByDate;
	private Date effectiveDate;
	private String project_description;
	private String pslc_description;
	private String localMarket;
	private Set<PORequestForm> porequests;

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
	public Date getUseByDate() {
		return useByDate;
	}

	public void setUseByDate(Date useByDate) {
		this.useByDate = useByDate;
	}

	public Date getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public String getProject_description() {
		return project_description;
	}

	public void setProject_description(String project_description) {
		this.project_description = project_description;
	}

	public String getPslc_description() {
		return pslc_description;
	}

	public void setPslc_description(String pslc_description) {
		this.pslc_description = pslc_description;
	}

	public String getLocalMarket() {
		return localMarket;
	}

	public void setLocalMarket(String localMarket) {
		this.localMarket = localMarket;
	}

	public Set<PORequestForm> getPorequests() {
		return porequests;
	}

	public void setPorequests(Set<PORequestForm> porequests) {
		this.porequests = porequests;
	}

	@Override
	public String toString() {
		return "ProjectForm [id=" + id + ", siteName=" + siteName + ", projectName=" + projectName + ", market="
				+ market + ", subMarket=" + subMarket + ", projectType=" + projectType + ", fuzeProject=" + fuzeProject
				+ ", pslc=" + pslc + ", projectStatus=" + projectStatus + ", type=" + type + ", customProjectType="
				+ customProjectType + ", siteTracker=" + siteTracker + ", teritory=" + teritory + ", useByDate="
				+ useByDate + ", effectiveDate=" + effectiveDate + ", project_description=" + project_description
				+ ", pslc_description=" + pslc_description + ", localMarket=" + localMarket + ", porequests="
				+ porequests + "]";
	}

}
