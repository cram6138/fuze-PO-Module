package com.po.reservation.entity;

import java.util.Date;
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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "container")
public class Container {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "territory")
	private String territory;
	@Column(name = "market")
	private String market;
	@Column(name = "sub_market")
	private String subMarket;
	@Column(name = "local_market")
	private String localMarket;
	@Column(name = "container_code")
	private String containerCode;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User buyer;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "project_id")
	private Project project;
	@Column(name = "is_reserved")
	private boolean reserved;
	@Column(name = "mr_order_code")
	private String mrOrderCode;
	@Column(name = "fue_reservation_id")
	private String fuzeReservationId;
	@Column(name = "reserved_by")
	private String reservedBy;
	@Column(name = "fuze_status")
	private String fuzeStatus;
	@Column(name = "cats_status")
	private String catsStatus;
	@Column(name = "use_by")
	private Date useBy;
	@Column(name = "reservation_creation_date")
	private Date reservationCreationDate;
	@Column(name = "ps_project")
	private String PSProject;
	@Column(name = "pslc")
	private String pslc;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "container_items", joinColumns = @JoinColumn(name = "container_id"), inverseJoinColumns = @JoinColumn(name = "item_id"))
	private Set<Item> items;
	
	

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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getSubMarket() {
		return subMarket;
	}

	public void setSubMarket(String subMarket) {
		this.subMarket = subMarket;
	}

	public String getLocalMarket() {
		return localMarket;
	}

	public void setLocalMarket(String localMarket) {
		this.localMarket = localMarket;
	}

	public String getFuzeReservationId() {
		return fuzeReservationId;
	}

	public void setFuzeReservationId(String fuzeReservationId) {
		this.fuzeReservationId = fuzeReservationId;
	}

	public String getContainerCode() {
		return containerCode;
	}

	public void setContainerCode(String containerCode) {
		this.containerCode = containerCode;
	}

	public User getBuyer() {
		return buyer;
	}

	public void setBuyer(User buyer) {
		this.buyer = buyer;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public boolean isReserved() {
		return reserved;
	}

	public void setReserved(boolean reserved) {
		this.reserved = reserved;
	}

	public String getMrOrderCode() {
		return mrOrderCode;
	}

	public void setMrOrderCode(String mrOrderCode) {
		this.mrOrderCode = mrOrderCode;
	}

	public String getReservedBy() {
		return reservedBy;
	}

	public void setReservedBy(String reservedBy) {
		this.reservedBy = reservedBy;
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

	public Date getUseBy() {
		return useBy;
	}

	public void setUseBy(Date useBy) {
		this.useBy = useBy;
	}

	public Date getReservationCreationDate() {
		return reservationCreationDate;
	}

	public void setReservationCreationDate(Date reservationCreationDate) {
		this.reservationCreationDate = reservationCreationDate;
	}

	public Set<Item> getItems() {
		return items;
	}

	public void setItems(Set<Item> items) {
		this.items = items;
	}

}
