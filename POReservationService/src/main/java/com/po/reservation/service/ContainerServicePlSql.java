package com.po.reservation.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.po.reservation.entity.Container;
import com.po.reservation.entity.Item;
import com.po.reservation.form.ContainerForm;
import com.po.reservation.info.ContainerInfo;
import com.po.reservation.info.ItemInfo;
import com.po.reservation.info.UserInfo;
import com.po.reservation.repository.ContainerRepositoryPlSql;

@Service
public class ContainerServicePlSql {
	
	private static Logger logger = LoggerFactory.getLogger(ContainerServicePlSql.class);
	
	@Autowired
	private ContainerRepositoryPlSql containerRepositoryProcedure;
	
	public Map<String, Object> containersByUserInfo(UserInfo request) {
		Map<String, Object> response = new HashMap<>();
		List<ContainerInfo> containerInfoList = new ArrayList<>();
		try {
			List<Container> dbContainersList = containerRepositoryProcedure.callProcedure(request);
			if (!CollectionUtils.isEmpty(dbContainersList) && dbContainersList != null) {
				for (Container row : dbContainersList) {
					ContainerInfo containerInfo = getContainerInfo(row);
					containerInfoList.add(containerInfo);
				}
				response.put("status", 1);
				response.put("containerInfoDetails", containerInfoList);
				return response;
			} else {
				response.put("status", 0);
				response.put("status", "Containers are empty.");
				return response;
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("method :: containersByUserInfo ::: Something went wrong" + e);
		}
		return response;
	}

	private ContainerInfo getContainerInfo(Container container) {
		ContainerInfo containerInfo = new ContainerInfo();
		BeanUtils.copyProperties(container, containerInfo);
		containerInfo.setUseByDate(container.getUseBy());
		containerInfo.setFuzeProjectId(container.getProject().getId());
		containerInfo.setProjectName(container.getProject().getProjectName());
		containerInfo.setBuyerId(container.getBuyer().getId());
		containerInfo.setBuyerName(container.getBuyer().getFirstName() + " " + container.getBuyer().getLastName());
		containerInfo.setMROrderCode(container.getMrOrderCode());

		containerInfo.setItemsInfo(getItemsInfo(container.getItems()));

		return containerInfo;
	}

	private List<ItemInfo> getItemsInfo(Set<Item> items) {
		List<ItemInfo> itemsInfoList = new ArrayList<ItemInfo>();
		Iterator<Item> it = items.iterator();
		while (it.hasNext()) {
			ItemInfo itemInfo = new ItemInfo();
			Item item = it.next();
			BeanUtils.copyProperties(item, itemInfo);
			itemsInfoList.add(itemInfo);
		}
		return itemsInfoList;
	}
	public List<ContainerInfo> searchContainers(@Valid ContainerForm containerForm) {
		List<ContainerInfo> ContainerInfoList = new ArrayList<>();
		  List<Container> containerList =
		  containerRepositoryProcedure.callProcedureForSearchContainer(containerForm);
		  
		  if (!containerList.isEmpty()) { for (Container container : containerList) {
		  ContainerInfo containerInfo = new ContainerInfo();
		  BeanUtils.copyProperties(container, containerInfo);
		  containerInfo.setPslc(container.getPslc());
		  containerInfo.setPSProject(container.getProject().getProjectName());
		  if(container.getReservationCreationDate()!=null) {
		  containerInfo.setReservationCreationDate(new
		  SimpleDateFormat("yyyy-MM-dd").format(container.getReservationCreationDate())
		  ); } if(container.getUseBy()!=null) { containerInfo.setUseBy(new
		  SimpleDateFormat("dd-MMM-yy").format(container.getUseBy())); }
		  ContainerInfoList.add(containerInfo); } }
		 
		return ContainerInfoList;
	}
}
