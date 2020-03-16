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
import com.po.reservation.form.ContainerSearchForm;
import com.po.reservation.info.ContainerInfo;
import com.po.reservation.repository.ContainerRepository;

@Service
public class ContainerService {
	
	@Autowired
	private ContainerRepository containerRepository;

	public List<ContainerInfo> searchContainers(ContainerForm containerForm) {

		List<Container> containerList = containerRepository.findAll();
		List<ContainerInfo> ContainerInfoList = new ArrayList<>();
		if (!containerList.isEmpty() && containerList != null) {
			if (containerForm.getTerritory() != null) {
				containerList = containerList.stream()
						.filter(container -> container.getTerritory().equalsIgnoreCase(containerForm.getTerritory()))
						.collect(Collectors.toList());
			} else if (containerForm.getMarket() != null) {
				containerList = containerList.stream()
						.filter(container -> container.getMarket().equalsIgnoreCase(containerForm.getMarket()))
						.collect(Collectors.toList());
			} else if (containerForm.getSubMarket() != null) {
				containerList = containerList.stream()
						.filter(container -> container.getSubMarket().equalsIgnoreCase(containerForm.getSubMarket()))
						.collect(Collectors.toList());
			} else if (containerForm.getLocalMarket() != null) {
				containerList = containerList.stream().filter(
						container -> container.getLocalMarket().equalsIgnoreCase(containerForm.getLocalMarket()))
						.collect(Collectors.toList());
			} else if (containerForm.getContainerCode() != null) {
				containerList = containerList.stream().filter(
						container -> container.getContainerCode().equalsIgnoreCase(containerForm.getContainerCode()))
						.collect(Collectors.toList());
			} else if (containerForm.getBuyer() != null) {
				containerList = containerList.stream()
						.filter(container -> container.getBuyer().getUsername().equals(containerForm.getBuyer()))
						.collect(Collectors.toList());
			} else if (containerForm.getProjectId() != 0) {
				containerList = containerList.stream()
						.filter(container -> container.getProject().getId() == (containerForm.getProjectId()))
						.collect(Collectors.toList());
			} else if (containerForm.getSearchKey() != null) {
				containerList = getContainerListBasedOnSearchKey(containerForm.getSearchKey(), containerList);
			}
			ContainerInfoList = setContainerInfoList(containerList);
		}
		return ContainerInfoList;
	}

	private List<Container> getContainerListBasedOnSearchKey(String searchKey, List<Container> containerList) {

		List<Container> searchKeylist = new ArrayList<Container>();
		for (Container c : containerList) {
			if (c.getContainerCode().equals(searchKey)) {
				searchKeylist = containerList.stream()
						.filter(container -> container.getContainerCode().equals(searchKey))
						.collect(Collectors.toList());
			} else if (String.valueOf(c.getProject().getId()).equals(searchKey)) {
				searchKeylist = containerList.stream()
						.filter(container -> container.getProject().getId() == (Integer.valueOf(searchKey)))
						.collect(Collectors.toList());
			} else if (c.getProject().getPslc().equals(searchKey)) {
				searchKeylist = containerList.stream()
						.filter(container -> container.getProject().getPslc().equals(searchKey))
						.collect(Collectors.toList());
			} else if (String.valueOf(c.getBuyer().getId()).equals(searchKey)) {
				searchKeylist = containerList.stream()
						.filter(container -> container.getBuyer().getId() == Integer.valueOf(searchKey))
						.collect(Collectors.toList());
			}
			if(!searchKeylist.isEmpty() && searchKeylist!= null) {
				break;
			}else {
				continue;
			}
		}
		return searchKeylist;
	}

	public List<ContainerInfo> searchContainersBasedOnCheckBox(ContainerSearchForm containerSearchForm) {
		
		List<Container> containerList = new ArrayList<>();
		List<ContainerInfo> ContainerInfoList =new ArrayList<>();
		if(containerSearchForm.getIsReserved()!= null && "Y".equals(containerSearchForm.getIsReserved())) {
			containerList = containerRepository.findByCatsStatusAndMrOrderCodeIsNull("RESERVED EXCESS");
		}else if(containerSearchForm.getContainerOnMrOrder()!=null && "Y".equals(containerSearchForm.getContainerOnMrOrder())) {
			containerList = containerRepository.findByCatsStatusAndMrOrderCodeIsNotNull("RESERVED EXCESS");
		}else if(containerSearchForm.getIncludeContainersOnReceived()!=null && "Y".equals(containerSearchForm.getIncludeContainersOnReceived())) {
			containerList = containerRepository.findByCatsStatus("RECEIVED");
		}else if(containerSearchForm.getSearchContainerNationwide()!=null && "Y".equals(containerSearchForm.getSearchContainerNationwide())) {
			containerList = containerRepository.findByCatsStatus("AVAILABLE EXCESS");
		}
		ContainerInfoList = setContainerInfoList(containerList);
		return ContainerInfoList;
	}

	private List<ContainerInfo> setContainerInfoList(List<Container> containerList) {

		List<ContainerInfo> ContainerInfoList = new ArrayList<>();
		if (!containerList.isEmpty()) {
			for (Container container : containerList) {
				ContainerInfo containerInfo = new ContainerInfo();
				BeanUtils.copyProperties(container, containerInfo);
				containerInfo.setFuzeProjectId(container.getProject().getFuzeProject());
				containerInfo.setPslc(container.getProject().getPslc());
				containerInfo.setLocation(container.getProject().getSiteName());
				containerInfo.setPSProject(container.getProject().getProjectName());
				ContainerInfoList.add(containerInfo);
			}
		}
		return ContainerInfoList;
	}

}
