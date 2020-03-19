package com.po.reservation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.po.reservation.entity.Container;

public interface ContainerRepository extends JpaRepository<Container, Integer> {

	List<Container> findByCatsStatusAndMrOrderCodeIsNull(String catsStatus);

	List<Container> findByCatsStatusAndMrOrderCodeIsNotNull(String catsStatus);

	List<Container> findByCatsStatus(String catsStatus);
	
	@Query("select container from Container container where container.territory =:territory and container.market =:market"
			+ " and container.catsStatus = 'ER' and container.buyer.id =:userId")
	public List<Container> findAllReservedContainerByUser(
			@Param("territory") String territory, 
			@Param("market") String market,
			@Param("userId") int userId);

}
