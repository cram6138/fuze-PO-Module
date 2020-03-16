package com.po.reservation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.po.reservation.entity.Container;

public interface ContainerRepository extends JpaRepository<Container, Integer>{

	List<Container> findByCatsStatusAndMrOrderCodeIsNull(String catsStatus);

	List<Container> findByCatsStatusAndMrOrderCodeIsNotNull(String catsStatus);

	List<Container> findByCatsStatus(String catsStatus);

}
