package com.fuze.po.PurchaseOrderAppServices.forms;

import java.util.List;

public class PORequestForm {

	private int poId;
	private List<ItemForm> poitems;

	public List<ItemForm> getPoitems() {
		return poitems;
	}

	public void setPoitems(List<ItemForm> poitems) {
		this.poitems = poitems;
	}

	public int getPoId() {
		return poId;
	}

	public void setPoId(int poId) {
		this.poId = poId;
	}

}
