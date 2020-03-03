package com.fuze.po.PurchaseOrderAppServices.info;

import java.util.Date;

/**
 * @author Bhajuram.c
 *
 */
public class EQuoteInfo {

	private int id;
	private String name;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	@Override
	public String toString() {
		return "EQuoteInfo [id=" + id + ", name=" + name + ", subMarket=" + subMarket + ", siteType=" + siteType
				+ ", siteSubType=" + siteSubType + ", vendorName=" + vendorName + ", projectType=" + projectType
				+ ", candidateType=" + candidateType + ", activityType=" + activityType + ", RANVendor=" + RANVendor
				+ ", encloser=" + encloser + ", generator=" + generator + ", band=" + band + ", createdBy=" + createdBy
				+ ", createdOn=" + createdOn + "]";
	}

}
