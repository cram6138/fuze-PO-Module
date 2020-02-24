package com.fuze.po.PurchaseOrderAppServices.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fuze.po.PurchaseOrderAppServices.entity.Item;
import com.fuze.po.PurchaseOrderAppServices.entity.POItems;
import com.fuze.po.PurchaseOrderAppServices.entity.PORequest;
import com.fuze.po.PurchaseOrderAppServices.entity.Project;
import com.fuze.po.PurchaseOrderAppServices.forms.PORequestForm;
import com.fuze.po.PurchaseOrderAppServices.forms.ProjectSearchForm;
import com.fuze.po.PurchaseOrderAppServices.info.ItemInfo;
import com.fuze.po.PurchaseOrderAppServices.info.PORequestInfo;
import com.fuze.po.PurchaseOrderAppServices.info.ProjectInfo;
import com.fuze.po.PurchaseOrderAppServices.repository.POItemsRepository;
import com.fuze.po.PurchaseOrderAppServices.repository.PORequestRepository;
import com.fuze.po.PurchaseOrderAppServices.repository.ProjectRepository;

@Service
public class POService {

	@Autowired
	private PORequestRepository poRequestRepo;

	@Autowired
	POItemsRepository poItemRepository;
	
	@Autowired
	private ProjectRepository projectRepository;

	public PORequest savePORequest(PORequest request) {

		return poRequestRepo.save(request);

	}

	public List<PORequestInfo> getPOList() {
		List<PORequest> poRequestList = poRequestRepo.findAll();
		List<PORequestInfo> poRequestInfoList = new ArrayList<PORequestInfo>();
		if (poRequestList != null && !poRequestList.isEmpty()) {
			for (PORequest po : poRequestList) {
				PORequestInfo poRequestInfo = new PORequestInfo();
				BeanUtils.copyProperties(po, poRequestInfo);
				poRequestInfoList.add(poRequestInfo);
			}

		}
		return poRequestInfoList;
	}

	public List<ItemInfo> getListOfItemsByPORequestId(Integer poRequestId) {

		List<POItems> poItems = poItemRepository.findAllByRequestId(poRequestId);
		List<ItemInfo> itemList = new ArrayList<ItemInfo>();
		if (poItems != null && !poItems.isEmpty()) {
			for (POItems poitem : poItems) {
				ItemInfo itemInfo = new ItemInfo();
				itemInfo.setId(poitem.getItem().getId());
				itemInfo.setDescription(poitem.getItem().getDescription());
				itemInfo.setInStock(poitem.getItem().isInStock());
				itemInfo.setModel(poitem.getItem().getModel());
				itemInfo.setName(poitem.getItem().getName());
				itemInfo.setPrice(poitem.getItem().getPrice());
				itemList.add(itemInfo);
			}

		}
		return itemList;

	}
	
	public List<ProjectInfo> searchProjects(ProjectSearchForm projectSearchForm) {
		List<Project> projectList = projectRepository.findAll();
		List<ProjectInfo> projectInfoList = new ArrayList<ProjectInfo>();
		if (projectList != null && !projectList.isEmpty()) {
			if(projectSearchForm.getProjectName() != null) {
				projectList = projectList.stream().filter(project-> project.getProjectName()
						.equals(projectSearchForm.getProjectName())).collect(Collectors.toList());
			} else if (projectSearchForm.getMarket() != null) {
				projectList = projectList.stream().filter(project-> project.getMarket()
						.equals(projectSearchForm.getMarket())).collect(Collectors.toList());
			} else if (projectSearchForm.getSiteName() != null) {
				projectList = projectList.stream().filter(project-> project.getSiteName()
						.equals(projectSearchForm.getSiteName())).collect(Collectors.toList());
			} else if (projectSearchForm.getTeritory() != null) {
				projectList = projectList.stream().filter(project-> project.getTeritory()
						.equals(projectSearchForm.getTeritory())).collect(Collectors.toList());
			} else if (projectSearchForm.getSubMarket() != null) {
				projectList = projectList.stream().filter(project-> project.getSubMarket()
						.equals(projectSearchForm.getSubMarket())).collect(Collectors.toList());
			} else if (projectSearchForm.getProjectType() != null) {
				projectList = projectList.stream().filter(project-> project.getProjectType()
						.equals(projectSearchForm.getProjectType())).collect(Collectors.toList());
			}
			
			if (!projectList.isEmpty()) {
				for (Project project: projectList) {
					ProjectInfo projectInfo = new ProjectInfo();
					BeanUtils.copyProperties(project, projectInfo);
					projectInfoList.add(projectInfo);
				}
			}
		}
		
		return projectInfoList;
	}

}
