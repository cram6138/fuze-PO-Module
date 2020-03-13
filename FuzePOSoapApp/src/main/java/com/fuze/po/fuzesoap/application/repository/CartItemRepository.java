package com.fuze.po.fuzesoap.application.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fuze.po.fuzesoap.application.entity.CartItemsEntity;

public interface CartItemRepository extends JpaRepository<CartItemsEntity, Integer> {

	@Query(value = "select ci from CartItemsEntity ci where ci.cart.id =:id")
	public List<CartItemsEntity> findByCartId(@Param(value = "id") int id);

	@Transactional
	@Modifying
	@Query(value = "delete from CartItemsEntity cie where cie.cart.id = 1")
	public void deleteAllCartItemsByCartId();
	
}
