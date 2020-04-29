package com.po.reservation.entity;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.Table;



@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(name = "getSubmarketDetailsBasedonMarketId", procedureName = "getSubmarketDetailsBasedonMarketId", resultClasses = SubMarket.class),
	@NamedStoredProcedureQuery(name = "getSubMarketDetails", procedureName = "getSubMarketDetails", resultClasses = SubMarket.class),
	@NamedStoredProcedureQuery(name = "searchOnSubmarket", procedureName = "searchOnSubmarket", resultClasses = SubMarket.class)
	
})


@Entity
@Table(name = "sub_market")
public class SubMarket {
	
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "market_id")
	private Market market;

	public Market getMarket() {
		return market;
	}

	public void setMarket(Market market) {
		this.market = market;
	}

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

	
}
