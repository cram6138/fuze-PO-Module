package com.fuze.po.PurchaseOrderAppServices.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "e_quotes")
public class EQuotes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "eQuote_name")
	private String eQuoteName;
	@Column(name = "sub_market")
	private String subMarket;
	@Column(name = "site_type")
	private String siteType; 
	@Column(name = "site_sub_type")
	private String siteSubType;
	@Column(name = "vendor_name")
	private String vendorName;
	@Column(name = "project_type")
	private String projectType;
	@Column(name = "candidate_type")
	private String candidateType;
	@Column(name = "activity_type")
	private String activityType;
	@Column(name = "RAN_vendor")
	private String RANVendor;
	@Column(name = "encloser")
	private String encloser;
	@Column(name = "generator")
	private String generator;
	@Column(name = "band")
	private String band;
	@Column(name = "created_by")
	private String createdBy;
	@Column(name = "created_on")
	private Date createdOn = new Date();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String geteQuoteName() {
		return eQuoteName;
	}
	public void seteQuoteName(String eQuoteName) {
		this.eQuoteName = eQuoteName;
	}
	public String getSubMarket() {
		return subMarket;
	}
	public void setSubMarket(String subMarket) {
		this.subMarket = subMarket;
	}
	public String getSiteType() {
		return siteType;
	}
	public void setSiteType(String siteType) {
		this.siteType = siteType;
	}
	public String getSiteSubType() {
		return siteSubType;
	}
	public void setSiteSubType(String siteSubType) {
		this.siteSubType = siteSubType;
	}
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public String getProjectType() {
		return projectType;
	}
	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}
	public String getCandidateType() {
		return candidateType;
	}
	public void setCandidateType(String candidateType) {
		this.candidateType = candidateType;
	}
	public String getActivityType() {
		return activityType;
	}
	public void setActivityType(String activityType) {
		this.activityType = activityType;
	}
	public String getRANVendor() {
		return RANVendor;
	}
	public void setRANVendor(String rANVendor) {
		RANVendor = rANVendor;
	}
	public String getEncloser() {
		return encloser;
	}
	public void setEncloser(String encloser) {
		this.encloser = encloser;
	}
	public String getGenerator() {
		return generator;
	}
	public void setGenerator(String generator) {
		this.generator = generator;
	}
	public String getBand() {
		return band;
	}
	public void setBand(String band) {
		this.band = band;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	
}
