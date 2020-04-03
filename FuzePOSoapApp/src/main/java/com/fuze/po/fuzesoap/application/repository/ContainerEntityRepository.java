package com.fuze.po.fuzesoap.application.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fuze.po.fuzesoap.application.entity.ContainerEntity;

public interface ContainerEntityRepository extends JpaRepository<ContainerEntity, Integer> {

	public Optional<ContainerEntity> findByPslc(String pslc);

}
