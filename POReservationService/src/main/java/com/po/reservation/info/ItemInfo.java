package com.po.reservation.info;

import java.util.Date;

/**
 * @author Bhajuram.c
 *
 */
public class ItemInfo {

	private int id;
	private String name;
	private String contractId;
	private Date dueDate;
	private String model;
	private String description;
	private String price;
	private boolean inStock;
	private String vendor;
	private String vendorId;

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


	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", contractId=" + contractId + ", dueDate=" + dueDate
				+ ", model=" + model + ", description=" + description + ", price=" + price + ", inStock=" + inStock + "]";
	}

}
