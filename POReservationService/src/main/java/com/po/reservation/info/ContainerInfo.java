package com.po.reservation.info;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;

public class ContainerInfo {

	private int id;
	private String containerCode;
	private String MROrderCode;
	private String MRSource;
	private String territory;
	private String fuzeReservationId;
	private Integer fuzeProjectId;
	private String projectName;
	private String PSProject;
	private String pslc;
	private String reservedUsername;
	private Date useByDate;
	private String useBy;
	private String reservationCreationDate;
	private String fuzeStatus;
	private String catsStatus;
	private String market;
	private String localMarket;
	private String subMarket;
	private int buyerId;
	private String buyerName;
	private List<ItemInfo> itemsInfo;
	private String reservationNotes;
	private String message;
	private boolean reserved;
	private Integer poRequestId;
	private String poName;

	public List<ItemInfo> getItemsInfo() {
		return itemsInfo;
	}

	public void setItemsInfo(List<ItemInfo> itemsInfo) {
		this.itemsInfo = itemsInfo;
	}

	public String getTerritory() {
		return territory;
	}

	public void setTerritory(String territory) {
		this.territory = territory;
	}

	public String getMarket() {
		return market;
	}

	public void setMarket(String market) {
		this.market = market;
	}

	public String getLocalMarket() {
		return localMarket;
	}

	public void setLocalMarket(String localMarket) {
		this.localMarket = localMarket;
	}

	public String getSubMarket() {
		return subMarket;
	}

	public void setSubMarket(String subMarket) {
		this.subMarket = subMarket;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContainerCode() {
		return containerCode;
	}

	public void setContainerCode(String containerCode) {
		this.containerCode = containerCode;
	}

	public String getMROrderCode() {
		return MROrderCode;
	}

	public void setMROrderCode(String mROrderCode) {
		MROrderCode = mROrderCode;
	}

	public String getMRSource() {
		return MRSource;
	}

	public void setMRSource(String mRSource) {
		MRSource = mRSource;
	}

	public String getFuzeReservationId() {
		return fuzeReservationId;
	}

	public void setFuzeReservationId(String fuzeReservationId) {
		this.fuzeReservationId = fuzeReservationId;
	}

	public String getPSProject() {
		return PSProject;
	}

	public void setPSProject(String pSProject) {
		PSProject = pSProject;
	}

	public String getPslc() {
		return pslc;
	}

	public void setPslc(String pslc) {
		this.pslc = pslc;
	}

	public String getReservedUsername() {
		return reservedUsername;
	}

	public Integer getFuzeProjectId() {
		return fuzeProjectId;
	}

	public void setFuzeProjectId(Integer fuzeProjectId) {
		this.fuzeProjectId = fuzeProjectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public int getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(int buyerId) {
		this.buyerId = buyerId;
	}

	public String getBuyerName() {
		return buyerName;
	}

	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}

	public void setReservedUsername(String reservedUsername) {
		this.reservedUsername = reservedUsername;
	}

	public Date getUseByDate() {
		return useByDate;
	}

	public void setUseByDate(Date useByDate) {
		this.useByDate = useByDate;
	}

	public String getReservationCreationDate() {
		return reservationCreationDate;
	}

	public void setReservationCreationDate(String reservationCreationDate) {
		this.reservationCreationDate = reservationCreationDate;
	}

	public String getFuzeStatus() {
		return fuzeStatus;
	}

	public void setFuzeStatus(String fuzeStatus) {
		this.fuzeStatus = fuzeStatus;
	}

	public String getCatsStatus() {
		return catsStatus;
	}

	public void setCatsStatus(String catsStatus) {
		this.catsStatus = catsStatus;
	}

	public String getReservationNotes() {
		return reservationNotes;
	}

	public void setReservationNotes(String reservationNotes) {
		this.reservationNotes = reservationNotes;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isReserved() {
		return reserved;
	}

	public void setReserved(boolean reserved) {
		this.reserved = reserved;
	}

	public String getUseBy() {
		return useBy;
	}

	public void setUseBy(String useBy) {
		this.useBy = useBy;
	}

	public Integer getPoRequestId() {
		return poRequestId;
	}

	public void setPoRequestId(Integer poRequestId) {
		this.poRequestId = poRequestId;
	}

	public String getPoName() {
		return poName;
	}

	public void setPoName(String poName) {
		this.poName = poName;
	}
}
