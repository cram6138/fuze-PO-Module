package com.fuze.po.PurchaseOrderAppServices.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Bhajuram.c
 *
 */
/**
 * @author Bhajuram.c
 *
 */
@Entity
@Table(name = "equote_item")
public class EquoteItems {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "equote_id")
	private EQuotes equote;
	
	@ManyToOne
	@JoinColumn(name = "item_id")
	private Item item;
	
	@Column(name = "quantity")
	private int quantity;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public EQuotes getEquote() {
		return equote;
	}

	public void setEquote(EQuotes equote) {
		this.equote = equote;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "EquoteItems [id=" + id + ", equote=" + equote + ", item=" + item + ", quantity=" + quantity + "]";
	}

}
