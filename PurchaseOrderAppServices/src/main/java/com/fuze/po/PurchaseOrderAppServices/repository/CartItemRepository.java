package com.fuze.po.PurchaseOrderAppServices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fuze.po.PurchaseOrderAppServices.entity.CartItems;

public interface CartItemRepository extends JpaRepository<CartItems, Integer>{

}
