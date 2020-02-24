package com.fuze.po.PurchaseOrderAppServices.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fuze.po.PurchaseOrderAppServices.entity.TemplateItem;

public interface TemplateItemepository extends JpaRepository<TemplateItem, Integer> {

	@Query("select ti from TemplateItem ti where ti.template.id =:tempId")
	public List<TemplateItem> findAllByTemplateId(@Param("tempId") int tempId);

}
