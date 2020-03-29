package com.fuze.po.PurchaseOrderAppServices.entity;

import java.sql.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * @author Bhajuram.c
 *
 */
@Entity
@Table(name = "project")
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "site_name")
	private String siteName;
	@Column(name = "project_name")
	private String projectName;
	@Column(name = "market")
	private String market;
	@Column(name = "sub_market")
	private String subMarket;
	@Column(name = "project_type")
	private String projectType;
	@Column(name = "fuze_project")
	private String fuzeProject;
	@Column(name = "pslc")
	private String pslc;
	@Column(name = "project_status")
	private String projectStatus;
	@Column(name = "type")
	private String type;
	@Column(name = "custom_project_type")
	private String customProjectType;
	@Column(name = "site_tracker")
	private String siteTracker;
	@Column(name = "teritory")
	private String teritory;
	@Column(name = "usebydate")
	private Date useByDate;
	@Column(name = "effective_date")
	private Date effectiveDate;
	@Column(name = "project_description")
	private String project_description;
	@Column(name = "pslc_description")
	private String pslc_description;
	@Column(name = "local_market")
	private String localMarket;
	@ManyToMany(mappedBy = "projects")
	private Set<PORequest> porequests;

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

	public Set<PORequest> getPorequests() {
		return porequests;
	}

	public void setPorequests(Set<PORequest> porequests) {
		this.porequests = porequests;
	}

	@Override
	public String toString() {
		return "Project [id=" + id + ", siteName=" + siteName + ", projectName=" + projectName + ", market=" + market
				+ ", subMarket=" + subMarket + ", projectType=" + projectType + ", fuzeProject=" + fuzeProject
				+ ", pslc=" + pslc + ", projectStatus=" + projectStatus + ", type=" + type + ", customProjectType="
				+ customProjectType + ", siteTracker=" + siteTracker + ", teritory=" + teritory + ", useByDate="
				+ useByDate + ", effectiveDate=" + effectiveDate + ", project_description=" + project_description
				+ ", pslc_description=" + pslc_description + ", localMarket=" + localMarket + ", porequests="
				+ porequests + "]";
	}


}
