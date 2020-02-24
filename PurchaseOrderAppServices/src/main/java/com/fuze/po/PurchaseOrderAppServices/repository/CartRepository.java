package com.fuze.po.PurchaseOrderAppServices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fuze.po.PurchaseOrderAppServices.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer> {

}
