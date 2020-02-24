package com.fuze.po.PurchaseOrderAppServices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fuze.po.PurchaseOrderAppServices.entity.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer> {

}
