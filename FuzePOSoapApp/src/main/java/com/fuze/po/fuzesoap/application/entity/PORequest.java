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

/**
 * @author Bhajuram.c
 *
 */
@Entity
@Table(name = "po_request")
public class PORequest {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "po_name")
	private String poName;
	@Column(name = "pslc")
	private String pslc;
	@Column(name = "po_status")
	private String poStatus;
	@Column(name = "teritory")
	private String teritory;
	@Column(name = "market")
	private String market;
	@Column(name = "site_tracker")
	private String siteTracker;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "po_projects", joinColumns = @JoinColumn(name = "po_request_id"), inverseJoinColumns = @JoinColumn(name = "project_id"))
	private Set<ProjectEntity> projects;

	@Column(name = "ps_project")
	private String psProject;

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

	public String getSiteTracker() {
		return siteTracker;
	}

	public void setSiteTracker(String siteTracker) {
		this.siteTracker = siteTracker;
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

	public String getPoName() {
		return poName;
	}

	public void setPoName(String poName) {
		this.poName = poName;
	}

	public String getPsProject() {
		return psProject;
	}

	public void setPsProject(String psProject) {
		this.psProject = psProject;
	}

	@Override
	public String toString() {
		return "PORequest [id=" + id + ", poName=" + poName + ", pslc=" + pslc + ", poStatus=" + poStatus
				+ ", teritory=" + teritory + ", market=" + market + ", siteTracker=" + siteTracker + ", projects="
				+ projects + ", psProject=" + psProject + "]";
	}

}
