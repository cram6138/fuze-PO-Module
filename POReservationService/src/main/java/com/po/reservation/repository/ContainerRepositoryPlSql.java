package com.po.reservation.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import javax.validation.Valid;

import org.springframework.stereotype.Repository;

import com.po.reservation.common.service.CatsStatus;
import com.po.reservation.entity.Container;
import com.po.reservation.form.ContainerForm;
import com.po.reservation.info.UserInfo;

@Repository
public class ContainerRepositoryPlSql {

	@PersistenceContext
	private EntityManager entityManager;

	public List<Container> callProcedure(UserInfo request) {
		List<Container> containerInfoList = new ArrayList<>();
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("getContainerDetails",Container.class);
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(3, Integer.class, ParameterMode.IN);
		query.setParameter(1, request.getTerritory());
		query.setParameter(2, request.getMarket());
		query.setParameter(3, request.getId());
		query.execute();
		containerInfoList = query.getResultList();
		return containerInfoList;
	}

	public List<Container> callProcedureForSearchContainer(@Valid ContainerForm containerForm) {
		List<Container> containerInfoList = new ArrayList<>();
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("searchContainer",Container.class);
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(6, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(7, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(8, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(9, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(10, String.class, ParameterMode.OUT);
		query.setParameter(1, containerForm.getTerritory());
		query.setParameter(2, containerForm.getMarket());
		query.setParameter(3, containerForm.getSubMarket());
		query.setParameter(4,containerForm.getLocalMarket());
		query.setParameter(5,containerForm.getContainerCode());
		query.setParameter(6,containerForm.getBuyer());
		query.setParameter(7,(containerForm.getProjectId()==0)?null:Integer.toString(containerForm.getProjectId()));
		query.setParameter(8,containerForm.getUserInfo().getTerritory());
		query.setParameter(9,containerForm.getUserInfo().getMarket());
		//query.setParameter(10,containerForm.getSearchKey());
		query.execute();
		containerInfoList = query.getResultList();
		if (containerForm.getSearchKey() != null) {
			containerInfoList = getContainerListBasedOnSearchKey(containerForm.getSearchKey(), containerInfoList);
		}
		return containerInfoList;
	}
	
	
	private List<Container> getContainerListBasedOnSearchKey(String searchKey, List<Container> containerList) {

		List<Container> searchKeylist = new ArrayList<Container>();
		for (Container c : containerList) {
			if (c.getContainerCode().contains(searchKey)) {
				searchKeylist = containerList.stream()
						.filter(container -> container.getCatsStatus().equals(CatsStatus.AVAILABLE_ACCESS.getValue())
								&& container.getContainerCode().equals(searchKey))
						.collect(Collectors.toList());
			} else if (String.valueOf(c.getProject().getId()).equals(searchKey)) {
				searchKeylist = containerList.stream()
						.filter(container -> container.getCatsStatus().equals(CatsStatus.AVAILABLE_ACCESS.getValue())
								&& container.getProject().getId() == (Integer.valueOf(searchKey)))
						.collect(Collectors.toList());
			} else if (c.getProject().getPslc().contains(searchKey)) {
				searchKeylist = containerList.stream()
						.filter(container -> container.getCatsStatus().equals(CatsStatus.AVAILABLE_ACCESS.getValue())
								&& container.getProject().getPslc().equals(searchKey))
						.collect(Collectors.toList());
			} else if (String.valueOf(c.getBuyer().getId()).equals(searchKey)) {
				searchKeylist = containerList.stream()
						.filter(container -> container.getCatsStatus().equals(CatsStatus.AVAILABLE_ACCESS.getValue())
								&& container.getBuyer().getId() == Integer.valueOf(searchKey))
						.collect(Collectors.toList());
			}
			if (!searchKeylist.isEmpty() && searchKeylist != null) {
				break;
			} else {
				continue;
			}
		}
		return searchKeylist;
	}
}
