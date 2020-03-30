package com.fuze.po.fuzesoap.application.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fuze.po.fuzesoap.application.entity.ProjectEntity;

public interface ProjectEntityRepository extends JpaRepository<ProjectEntity, Integer> {
	


	
	
	@Query("select pe from ProjectEntity pe where pe.projectName=:pslcOrPname  or pe.pslc=:pslcOrPname ")
	Optional<ProjectEntity> findByPslcOrProjectName(@Param(value = "pslcOrPname") String pslcOrPname);
	
	

}
