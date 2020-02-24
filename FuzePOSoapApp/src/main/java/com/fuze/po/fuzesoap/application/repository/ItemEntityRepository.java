package com.fuze.po.fuzesoap.application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fuze.po.fuzesoap.application.entity.ItemEntity;

public interface ItemEntityRepository extends JpaRepository<ItemEntity, Integer> {

	public List<ItemEntity> findById(int id);
}
