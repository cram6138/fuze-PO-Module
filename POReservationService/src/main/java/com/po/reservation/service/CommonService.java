package com.po.reservation.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.po.reservation.entity.Market;
import com.po.reservation.entity.SubMarket;
import com.po.reservation.entity.Territory;
import com.po.reservation.info.MarketInfo;
import com.po.reservation.info.SubMarketInfo;
import com.po.reservation.info.TerritoryInfo;
import com.po.reservation.repository.MarketRepository;
import com.po.reservation.repository.SubMarketRepository;
import com.po.reservation.repository.TerritoryRepository;

@Service
public class CommonService {

	@Autowired
	private TerritoryRepository territoryRepository;
	@Autowired
	private MarketRepository marketRepository;
	@Autowired
	private SubMarketRepository subMarketRepository;
	
	public List<TerritoryInfo> getTerritories() {
		List<Territory> territoryList = territoryRepository.findAll();
		List<TerritoryInfo> territoriesInfo = new ArrayList<TerritoryInfo>();
		if(territoryList != null && !territoryList.isEmpty()) {
			for (Territory territory : territoryList) {
				territoriesInfo.add(getTerritoryInfo(territory));
			}
		}
		return territoriesInfo;
	}

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
		if(markets != null && !markets.isEmpty()) {
			for(Market market : markets) {
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
		if (subMarkets != null && subMarkets.isEmpty()) {
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
	
	public List<MarketInfo> getMarkets() {
		List<Market> markets = marketRepository.findAll();
		return getMarketInfoList(markets);
	}
	
	public List<SubMarketInfo> getSubMarkets() {
		List<SubMarket> subMarkets = subMarketRepository.findAll();
		return getSubMarketInfoList(subMarkets);
	}
	
	public TerritoryInfo getTerritoryById(int territoryId) {
		Territory territory = territoryRepository.getOne(territoryId);
		return getTerritoryInfo(territory);
	}
	
	public MarketInfo getMarketById(int marketId) {
		Market market = marketRepository.getOne(marketId);
		return getMarketInfo(market);
	}
	
	public SubMarketInfo getSubMarketById(int subMarketId) {
		SubMarket subMarket = subMarketRepository.getOne(subMarketId);
		return getSubMarketInfo(subMarket);
	}
}
