package com.po.reservation.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.po.reservation.info.MarketInfo;
import com.po.reservation.info.SubMarketInfo;
import com.po.reservation.info.TerritoryInfo;
import com.po.reservation.service.CommonServicePlsql;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CommonControllerPlsql {

	private static Logger logger = LoggerFactory.getLogger(CommonController.class);

	@Autowired
	private CommonServicePlsql commonServicePlsql;

	@GetMapping("/territories/v2")
	public ResponseEntity<List<TerritoryInfo>> getTerritoriesV2() {
		List<TerritoryInfo> territoryInfoList = new ArrayList<TerritoryInfo>(0);
		territoryInfoList = commonServicePlsql.getTerritoriesv2();
		return new ResponseEntity<List<TerritoryInfo>>(territoryInfoList, HttpStatus.OK);
	}

	@GetMapping("/markets/v2")
	public ResponseEntity<List<MarketInfo>> getMarketsv2() {
		List<MarketInfo> marketInfoList = new ArrayList<MarketInfo>(0);
		marketInfoList = commonServicePlsql.getMarketsv2();
		return new ResponseEntity<List<MarketInfo>>(marketInfoList, HttpStatus.OK);
	}

	@GetMapping("/subMarkets/v2")
	public ResponseEntity<List<SubMarketInfo>> getSubMarketsv2() {
		List<SubMarketInfo> subMarketInfoList = new ArrayList<SubMarketInfo>(0);
		subMarketInfoList = commonServicePlsql.getSubMarketsv2();
		return new ResponseEntity<List<SubMarketInfo>>(subMarketInfoList, HttpStatus.OK);
	}

	@GetMapping("/territory/v2/{territoryId}")
	public ResponseEntity<TerritoryInfo> getTerritoryByIdv2(@PathVariable("territoryId") final int territoryId) {
		TerritoryInfo territoryInfo = null;
		territoryInfo = commonServicePlsql.getTerritoryByIdv2(territoryId);
		return new ResponseEntity<TerritoryInfo>(territoryInfo, HttpStatus.OK);
	}

	@GetMapping("/market/v2/{marketId}")
	public ResponseEntity<MarketInfo> getMarketByIdv2(@PathVariable("marketId") final int marketId) {
		MarketInfo marketInfo = null;
		marketInfo = commonServicePlsql.getMarketByIdv2(marketId);
		return new ResponseEntity<MarketInfo>(marketInfo, HttpStatus.OK);
	}

	@GetMapping("/subMarket/v2/{subMarketId}")
	public ResponseEntity<SubMarketInfo> getSubMarketByIdv2(@PathVariable("subMarketId") final int subMarketId) {
		SubMarketInfo subMarketInfo = null;
		subMarketInfo = commonServicePlsql.getSubMarketByIdv2(subMarketId);
		return new ResponseEntity<SubMarketInfo>(subMarketInfo, HttpStatus.OK);
	}

}
