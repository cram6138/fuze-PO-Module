package com.fuze.po.PurchaseOrderAppServices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fuze.po.PurchaseOrderAppServices.entity.PORequest;
import com.fuze.po.PurchaseOrderAppServices.forms.PORequestForm;

@Repository
public interface PORequestRepository extends JpaRepository<PORequest, Integer>{

	void save(PORequestForm request);

}
