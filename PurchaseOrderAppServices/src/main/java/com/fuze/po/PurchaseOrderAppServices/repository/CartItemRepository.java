package com.fuze.po.PurchaseOrderAppServices.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.fuze.po.PurchaseOrderAppServices.entity.CartItems;

public interface CartItemRepository extends JpaRepository<CartItems, Integer> {

	@Transactional
	@Modifying
	@Query(value = "delete from CartItems ci where ci.cart.id = 1")
	public void deleteAllItemsByCartId();

}
