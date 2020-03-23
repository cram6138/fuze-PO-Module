package com.fuze.po.fuzesoap.application.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "po_request")
public class PORequestEntity {

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

	@Column(name = "status")
	private String status;

	@Column(name = "po_name")
	private String poName;

	@Column(name = "po_status")
	private String poStatus;

	@Column(name = "teritory")
	private String teritory;

	@Column(name = "market")
	private String market;
	
	@Column(name = "local_market")
	private String localMarket;
	
	
	

	public String getLocalMarket() {
		return localMarket;
	}

	public void setLocalMarket(String localMarket) {
		this.localMarket = localMarket;
	}

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "po_projects", joinColumns = @JoinColumn(name = "po_request_id"), inverseJoinColumns = @JoinColumn(name = "project_id"))
	private Set<ProjectEntity> projects;

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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPoName() {
		return poName;
	}

	public void setPoName(String poName) {
		this.poName = poName;
	}

	public String getPoStatus() {
		return poStatus;
	}

	public void setPoStatus(String poStatus) {
		this.poStatus = poStatus;
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

	public Set<ProjectEntity> getProjects() {
		return projects;
	}

	public void setProjects(Set<ProjectEntity> projects) {
		this.projects = projects;
	}

	@Override
	public String toString() {
		return "PORequestEntity [id=" + id + ", siteName=" + siteName + ", projectName=" + projectName + ", projectId="
				+ projectId + ", pslc=" + pslc + ", psProject=" + psProject + ", projectStatus=" + projectStatus
				+ ", type=" + type + ", projectType=" + projectType + ", customerProjectType=" + customerProjectType
				+ ", siteTracker=" + siteTracker + ", status=" + status + ", poName=" + poName + ", poStatus="
				+ poStatus + ", teritory=" + teritory + ", market=" + market + ", localMarket=" + localMarket
				+ ", projects=" + projects + ", getLocalMarket()=" + getLocalMarket() + ", getId()=" + getId()
				+ ", getSiteName()=" + getSiteName() + ", getProjectName()=" + getProjectName() + ", getProjectId()="
				+ getProjectId() + ", getPslc()=" + getPslc() + ", getPsProject()=" + getPsProject()
				+ ", getProjectStatus()=" + getProjectStatus() + ", getType()=" + getType() + ", getProjectType()="
				+ getProjectType() + ", getCustomerProjectType()=" + getCustomerProjectType() + ", getSiteTracker()="
				+ getSiteTracker() + ", getStatus()=" + getStatus() + ", getPoName()=" + getPoName()
				+ ", getPoStatus()=" + getPoStatus() + ", getTeritory()=" + getTeritory() + ", getMarket()="
				+ getMarket() + ", getProjects()=" + getProjects() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

	
}
