package com.po.reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.po.reservation.entity.Territory;

public interface TerritoryRepository extends JpaRepository<Territory, Integer> {

}
