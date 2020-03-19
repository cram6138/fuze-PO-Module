package com.po.reservation.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "market")
public class Market {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "code")
	private String code;


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "territory_id")
	private Territory territory;
	
	@OneToMany(mappedBy = "market")
	private List<SubMarket> subMarkets;


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

	public Territory getTerritory() {
		return territory;
	}

	public void setTerritory(Territory territory) {
		this.territory = territory;
	}

	public List<SubMarket> getSubMarkets() {
		return subMarkets;
	}

	public void setSubMarkets(List<SubMarket> subMarkets) {
		this.subMarkets = subMarkets;
	}
	
}
