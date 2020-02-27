package com.fuze.po.PurchaseOrderAppServices.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fuze.po.PurchaseOrderAppServices.entity.EquoteItems;

/**
 * @author Bhajuram.c
 *
 */
public interface EQuoteItemsRepository extends JpaRepository<EquoteItems, Integer> {

	@Query("select ei from EquoteItems ei where ei.equote.id =:eQuoteId")
	List<EquoteItems> findAllByEQuoteId(@Param("eQuoteId") int eQuoteId);

}
