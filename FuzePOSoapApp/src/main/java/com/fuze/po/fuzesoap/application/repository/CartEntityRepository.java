package com.fuze.po.fuzesoap.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fuze.po.fuzesoap.application.entity.CartEntity;

public interface CartEntityRepository extends JpaRepository<CartEntity, Integer> {

}
