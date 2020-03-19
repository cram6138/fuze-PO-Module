package com.po.reservation.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

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
	
	public Map<String, Object> getContainerDetails() {
		Map<String, Object> response = new HashMap<>();
		Map<String, Object> map = new HashMap<>();
		Map<String, Object> userInfoMap = new HashMap<>();
		Map<String, Object> projectInfoMap = new HashMap<>();
		List<Map<String, Object>> mapList = new ArrayList<>();
		try {
			List<Container> dbContainersList = containerRepository.findAll();
			System.out.println(dbContainersList);
			if (!CollectionUtils.isEmpty(dbContainersList)) {
				for (Container row : dbContainersList) {
					map.put("id", row.getId());
					map.put("territory", row.getTerritory());
					map.put("market", row.getMarket());
					map.put("subMarket", row.getSubMarket());
					map.put("localMarket", row.getLocalMarket());
					map.put("containerCode", row.getContainerCode());
					map.put("isReserved", row.isReserved());
					map.put("mrOrderCode", row.getMrOrderCode());
					map.put("fuzeReservationId", row.getFuzeReservationId());
					map.put("reserverdBy", row.getReservedBy());
					map.put("fuzeStatus", row.getFuzeStatus());
					map.put("catsStatus", row.getCatsStatus());
					map.put("useBy", row.getUseBy());
					map.put("reservationCreationDate", row.getReservationCreationDate());

					userInfoMap.put("id", row.getBuyer().getId());
					userInfoMap.put("userName", row.getBuyer().getUsername());
					userInfoMap.put("isActive", row.getBuyer().isActive());
					userInfoMap.put("userRole", row.getBuyer().getUserRoles());
					userInfoMap.put("firstName", row.getBuyer().getFirstName());
					userInfoMap.put("lastName", row.getBuyer().getLastName());

					projectInfoMap.put("id", row.getProject().getId());
					projectInfoMap.put("siteName", row.getProject().getSiteName());
					projectInfoMap.put("projectName", row.getProject().getProjectName());
					projectInfoMap.put("pslc", row.getProject().getPslc());
					projectInfoMap.put("fuzeProject", row.getProject().getFuzeProject());
					projectInfoMap.put("projectStatus", row.getProject().getProjectStatus());
					projectInfoMap.put("poRequestInfo", row.getProject().getPorequests());

					map.put("userInfo", userInfoMap);
					map.put("projectInfo", projectInfoMap);
					map.put("itemInfo", row.getItems());
					mapList.add(map);
				}
				response.put("status", 1);
				response.put("containersDetails", mapList);
				return response;
			} else {
				response.put("status", 0);
				response.put("status", "Containers details are empty.");
				return response;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

}
