package com.fuze.po.fuzesoap.application.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "po_items")
public class POItemsEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name = "item_id")
	private ItemEntity itemEntity;

	@ManyToOne
	@JoinColumn(name = "po_request_id")
	private PORequestEntity poRequestEntity;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ItemEntity getItemEntity() {
		return itemEntity;
	}

	public void setItemEntity(ItemEntity itemEntity) {
		this.itemEntity = itemEntity;
	}

	public PORequestEntity getPoRequestEntity() {
		return poRequestEntity;
	}

	public void setPoRequestEntity(PORequestEntity poRequestEntity) {
		this.poRequestEntity = poRequestEntity;
	}

}
