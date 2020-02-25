package com.fuze.po.PurchaseOrderAppServices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fuze.po.PurchaseOrderAppServices.entity.Item;
@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {

}
