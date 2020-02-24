package com.fuze.po.PurchaseOrderAppServices.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fuze.po.PurchaseOrderAppServices.entity.POItems;

@Repository
public interface POItemsRepository extends JpaRepository<POItems, Integer> {

	@Query(value = "select pi from POItems pi where pi.poRequest.id = :requestId")
	List<POItems> findAllByRequestId(@Param(value = "requestId") Integer requestId);

}
