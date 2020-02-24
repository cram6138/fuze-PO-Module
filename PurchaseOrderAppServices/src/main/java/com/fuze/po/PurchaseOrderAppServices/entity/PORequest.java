package com.fuze.po.PurchaseOrderAppServices.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "po_request")
public class PORequest {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "site_name")
	private String siteName;
	@Column(name = "project_name")
	private String projectName;
	@Column(name = "project_id")
	private String projectId;
	@Column(name = "pslc")
	private String pslc;
	@Column(name = "ps_project")
	private String psProject;
	@Column(name = "project_status")
	private String projectStatus;
	@Column(name = "type")
	private String type;
	@Column(name = "project_type")
	private String projectType;
	@Column(name = "customer_project_type")
	private String customerProjectType;
	@Column(name = "site_tracker")
	private String siteTracker;
	
	
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
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public String getPslc() {
		return pslc;
	}
	public void setPslc(String pslc) {
		this.pslc = pslc;
	}
	public String getPsProject() {
		return psProject;
	}
	public void setPsProject(String psProject) {
		this.psProject = psProject;
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
	public String getProjectType() {
		return projectType;
	}
	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}
	public String getCustomerProjectType() {
		return customerProjectType;
	}
	public void setCustomerProjectType(String customerProjectType) {
		this.customerProjectType = customerProjectType;
	}
	public String getSiteTracker() {
		return siteTracker;
	}
	public void setSiteTracker(String siteTracker) {
		this.siteTracker = siteTracker;
	}
	
}
