package com.po.reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.po.reservation.entity.Market;

public interface MarketRepository extends JpaRepository<Market, Integer> {

}
