package com.fuze.po.PurchaseOrderAppServices.info;

import java.util.Date;

public class EQuoteInfo {

	private int id;
	private String eQuoteName;
	private String subMarket;
	private String siteType;
	private String siteSubType;
	private String vendorName;
	private String projectType;
	private String candidateType;
	private String activityType;
	private String RANVendor;
	private String encloser;
	private String generator;
	private String band;
	private String createdBy;
	private Date createdOn;

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

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
}
