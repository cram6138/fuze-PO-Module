package com.po.reservation.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Bhajuram.c
 *
 */
@Entity
@Table(name = "item")
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "contract_id")
	private String contractId;

	@Column(name = "due_date")
	private Date dueDate;

	@Column(name = "ship_to_id")
	private String shipToId;

	@Column(name = "activity")
	private String activity;

	@Column(name = "comments")
	private String comments;

	@Column(name = "model")
	private String model;

	@Column(name = "description")
	private String description;

	@Column(name = "price")
	private String price;

	@Column(name = "in_stock")
	private boolean inStock;
	
	@Column(name = "vendor")
	private String vendor;

	@Column(name = "vendor_id")
	private String vendorId;
	
	@ManyToMany(mappedBy = "items")
	@JsonIgnore
	private Set<Container> containers;

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

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public boolean isInStock() {
		return inStock;
	}

	public void setInStock(boolean inStock) {
		this.inStock = inStock;
	}

	public String getContractId() {
		return contractId;
	}

	public void setContractId(String contractId) {
		this.contractId = contractId;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public String getShipToId() {
		return shipToId;
	}

	public void setShipToId(String shipToId) {
		this.shipToId = shipToId;
	}

	public String getActivity() {
		return activity;
	}


	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public String getVendorId() {
		return vendorId;
	}

	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", contractId=" + contractId + ", dueDate=" + dueDate
				+ ", shipToId=" + shipToId + ", activity=" + activity + ", comments=" + comments + ", model=" + model
				+ ", description=" + description + ", price=" + price + ", inStock=" + inStock + "]";
	}

}
