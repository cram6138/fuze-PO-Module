package com.fuze.po.fuzesoap.application.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fuze.po.fuzesoap.application.entity.ProjectEntity;

public interface ProjectEntityRepository extends JpaRepository<ProjectEntity, Integer> {

	
	Optional<ProjectEntity> findByPslc(String pslc);

	Optional<ProjectEntity> findByProjectName(String projectName);

}
