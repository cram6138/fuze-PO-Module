package com.fuze.po.PurchaseOrderAppServices.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fuze.po.PurchaseOrderAppServices.entity.Item;
@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
	
	@Query("select it from Item it where it.id=:id or it.name=:name or it.vendor =:vendor or it.vendorId =:vendorId or it.description=:description")
	public List<Item> searchByAllItems(@Param("id") int id, @Param("name") String name, @Param("vendor")  String vendor,@Param("vendorId") String vendorId,@Param("description") String description);

}
