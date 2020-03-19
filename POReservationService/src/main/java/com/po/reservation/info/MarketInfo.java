package com.po.reservation.info;

import java.util.List;

public class MarketInfo {

	private int id;
	private String name;
	private String code;
	private List<SubMarketInfo> subMarkets;
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
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public List<SubMarketInfo> getSubMarkets() {
		return subMarkets;
	}
	public void setSubMarkets(List<SubMarketInfo> subMarkets) {
		this.subMarkets = subMarkets;
	}

	
}
