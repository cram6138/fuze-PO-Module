package com.po.reservation.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.po.reservation.entity.Container;
import com.po.reservation.form.ContainerForm;
import com.po.reservation.info.ContainerInfo;
import com.po.reservation.repository.ContainerRepository;

@Service
public class ContainerService {
	
	@Autowired
	private ContainerRepository containerRepository;

	public List<ContainerInfo> searchContainers(ContainerForm containerForm) {
		
		List<Container> containerList = containerRepository.findAll();
		List<ContainerInfo> ContainerInfoList = new ArrayList<>();
		if(!containerList.isEmpty() && containerList!= null) {
			if(containerForm.getTerritory()!= null) {
				containerList = containerList.stream().filter(container->container.getTerritory()
						.equalsIgnoreCase(containerForm.getTerritory())).collect(Collectors.toList());
			}else if(containerForm.getMarket()!= null) {
				containerList = containerList.stream().filter(container->container.getMarket()
						.equalsIgnoreCase(containerForm.getMarket())).collect(Collectors.toList());
			}else if(containerForm.getSubMarket()!= null) {
				containerList = containerList.stream().filter(container->container.getSubMarket()
						.equalsIgnoreCase(containerForm.getSubMarket())).collect(Collectors.toList());
			}else if(containerForm.getLocalMarket()!= null) {
				containerList = containerList.stream().filter(container->container.getLocalMarket()
						.equalsIgnoreCase(containerForm.getLocalMarket())).collect(Collectors.toList());
			}else if(containerForm.getContainerCode()!= null) {
				containerList = containerList.stream().filter(container->container.getContainerCode()
						.equalsIgnoreCase(containerForm.getContainerCode())).collect(Collectors.toList());
			}else if(containerForm.getBuyer()!= null) {
				containerList = containerList.stream().filter(container->container.getBuyer().getUsername()
						.equals(containerForm.getBuyer())).collect(Collectors.toList());
			}else if(containerForm.getBuyer()!= null) {
				containerList = containerList.stream().filter(container->container.getBuyer().getUsername()
						.equals(containerForm.getBuyer())).collect(Collectors.toList());
			}else if(containerForm.getProjectId()!= 0) {
				containerList = containerList.stream().filter(container->container.getProject().getId()
						==(containerForm.getProjectId())).collect(Collectors.toList());
			}else if(containerForm.getSearchKey()!= null) {
			    containerList = containerList.stream().filter(container->container.getContainerCode()
							.equalsIgnoreCase(containerForm.getSearchKey())||
							container.getProject().getId()==(Integer.valueOf(containerForm.getSearchKey()))
							||container.getProject().getPslc().equals(containerForm.getSearchKey())
							||container.getBuyer().getId()==(Integer.valueOf(containerForm.getSearchKey()))).collect(Collectors.toList());
			}
			
			if (!containerList.isEmpty()) {
				for (Container container: containerList) {
					ContainerInfo containerInfo = new ContainerInfo();
					BeanUtils.copyProperties(container, containerInfo);
					ContainerInfoList.add(containerInfo);
				}
			}
		}
		
		return ContainerInfoList;
	}

}
