package com.po.reservation.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Service;

import com.po.reservation.entity.Market;
import com.po.reservation.entity.SubMarket;
import com.po.reservation.entity.Territory;
import com.po.reservation.info.MarketInfo;
import com.po.reservation.info.SubMarketInfo;
import com.po.reservation.info.TerritoryInfo;

@Service
public class CommonServicePlsql {

	@PersistenceContext
	private EntityManager entityManager;

	private TerritoryInfo getTerritoryInfo(Territory territory) {
		TerritoryInfo territoryInfo = new TerritoryInfo();
		if (territory != null) {
			territoryInfo.setCode(territory.getCode());
			territoryInfo.setId(territory.getId());
			territoryInfo.setName(territory.getName());
			territoryInfo.setMarkets(getMarketInfoList(territory.getMarkets()));
		}
		return territoryInfo;
	}

	private List<MarketInfo> getMarketInfoList(List<Market> markets) {
		List<MarketInfo> marketInfoList = new ArrayList<MarketInfo>();
		if (markets != null && !markets.isEmpty()) {
			for (Market market : markets) {
				marketInfoList.add(getMarketInfo(market));
			}
		}
		return marketInfoList;
	}

	private MarketInfo getMarketInfo(Market market) {
		MarketInfo marketInfo = new MarketInfo();
		if (market != null) {
			marketInfo.setCode(market.getCode());
			marketInfo.setId(market.getId());
			marketInfo.setName(market.getName());
			marketInfo.setSubMarkets(getSubMarketInfoList(market.getSubMarkets()));
		}
		return marketInfo;
	}

	private List<SubMarketInfo> getSubMarketInfoList(List<SubMarket> subMarkets) {
		List<SubMarketInfo> subMarketInfoList = new ArrayList<SubMarketInfo>();
		if (subMarkets != null && !subMarkets.isEmpty()) {
			for (SubMarket subMarket : subMarkets) {
				subMarketInfoList.add(getSubMarketInfo(subMarket));
			}
		}
		return subMarketInfoList;
	}

	private SubMarketInfo getSubMarketInfo(SubMarket subMarket) {
		SubMarketInfo subMarketInfo = new SubMarketInfo();
		if (subMarket != null) {
			subMarketInfo.setCode(subMarket.getCode());
			subMarketInfo.setName(subMarket.getName());
			subMarketInfo.setId(subMarket.getId());
		}
		return subMarketInfo;
	}

	public List<TerritoryInfo> getTerritoriesv2() {
		StoredProcedureQuery query = entityManager.createNamedStoredProcedureQuery("getTerritoryDetails");
		query.execute();
		List<Territory> territoryList = query.getResultList();
		List<TerritoryInfo> territoriesInfo = new ArrayList<TerritoryInfo>();
		if (territoryList != null && !territoryList.isEmpty()) {
			for (Territory territory : territoryList) {
				territoriesInfo.add(getTerritoryInfo(territory));
			}
		}
		return territoriesInfo;
	}

	public List<MarketInfo> getMarketsv2() {
		StoredProcedureQuery query = entityManager.createNamedStoredProcedureQuery("getMarketDetails");
		query.execute();
		List<Market> markets = query.getResultList();
		return getMarketInfoList(markets);
	}

	public List<SubMarketInfo> getSubMarketsv2() {
		StoredProcedureQuery query = entityManager.createNamedStoredProcedureQuery("getSubMarketDetails");
		query.execute();
		List<SubMarket> subMarkets = query.getResultList();
		return getSubMarketInfoList(subMarkets);
	}

	public TerritoryInfo getTerritoryByIdv2(int territoryId) {
		TerritoryInfo territoryInfo = new TerritoryInfo();
		StoredProcedureQuery query = entityManager.createNamedStoredProcedureQuery("searchOnTerritory")
				.registerStoredProcedureParameter(1, Integer.class, ParameterMode.INOUT)
				.registerStoredProcedureParameter(2, String.class, ParameterMode.OUT)
				.registerStoredProcedureParameter(3, String.class, ParameterMode.OUT)

				.setParameter(1, territoryId);
		territoryInfo.setCode((String) query.getOutputParameterValue(2));
		territoryInfo.setId((int) query.getOutputParameterValue(1));
		territoryInfo.setName((String) query.getOutputParameterValue(3));

		query.execute();
		StoredProcedureQuery query1 = entityManager.createNamedStoredProcedureQuery("getMarketBasedonTerritoryId")
				.registerStoredProcedureParameter(1, Integer.class, ParameterMode.IN).setParameter(1, territoryId);
		List<Market> markets = query1.getResultList();
		territoryInfo.setMarkets(getMarketInfoList(markets));

		return territoryInfo;

	}

	public MarketInfo getMarketByIdv2(int marketId) {
		MarketInfo marketInfo = new MarketInfo();
		StoredProcedureQuery query = entityManager.createNamedStoredProcedureQuery("searchOnMarket")
				.registerStoredProcedureParameter(1, Integer.class, ParameterMode.INOUT)
				.registerStoredProcedureParameter(2, String.class, ParameterMode.OUT)
				.registerStoredProcedureParameter(3, String.class, ParameterMode.OUT)

				.setParameter(1, marketId);
		marketInfo.setCode((String) query.getOutputParameterValue(2));
		marketInfo.setId((int) query.getOutputParameterValue(1));
		marketInfo.setName((String) query.getOutputParameterValue(3));

		query.execute();
		StoredProcedureQuery query1 = entityManager
				.createNamedStoredProcedureQuery("getSubmarketDetailsBasedonMarketId")
				.registerStoredProcedureParameter(1, Integer.class, ParameterMode.IN).setParameter(1, marketId);
		List<SubMarket> subMarkets = query1.getResultList();
		marketInfo.setSubMarkets(getSubMarketInfoList(subMarkets));

		return marketInfo;

	}

	public SubMarketInfo getSubMarketByIdv2(int subMarketId) {

		SubMarketInfo subMarketInfo = new SubMarketInfo();
		StoredProcedureQuery query = entityManager.createNamedStoredProcedureQuery("searchOnSubmarket")
				.registerStoredProcedureParameter(1, Integer.class, ParameterMode.INOUT)
				.registerStoredProcedureParameter(2, String.class, ParameterMode.OUT)
				.registerStoredProcedureParameter(3, String.class, ParameterMode.OUT)

				.setParameter(1, subMarketId);
		subMarketInfo.setCode((String) query.getOutputParameterValue(2));
		subMarketInfo.setId((int) query.getOutputParameterValue(1));
		subMarketInfo.setName((String) query.getOutputParameterValue(3));

		query.execute();
		return subMarketInfo;
	}

}
