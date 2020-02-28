package com.fuze.po.fuzesoap.application.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fuze.po.fuzesoap.application.entity.PORequestEntity;

public interface PORequestEntityRepository extends JpaRepository<PORequestEntity, Integer> {

	@Query(value = "select pre from PORequestEntity pre where pre.id =:id")
	public Optional<PORequestEntity> findByIdAndStatus(@Param(value = "id") Integer id);

}
