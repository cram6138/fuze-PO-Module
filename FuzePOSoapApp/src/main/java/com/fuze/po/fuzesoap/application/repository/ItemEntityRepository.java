package com.fuze.po.fuzesoap.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fuze.po.fuzesoap.application.entity.ItemEntity;

public interface ItemEntityRepository extends JpaRepository<ItemEntity, Integer> {

}
