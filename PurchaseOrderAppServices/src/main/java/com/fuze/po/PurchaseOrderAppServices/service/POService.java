package com.fuze.po.PurchaseOrderAppServices.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fuze.po.PurchaseOrderAppServices.bean.AddContainerDetailsRequest;
import com.fuze.po.PurchaseOrderAppServices.config.GenerateExcel;
import com.fuze.po.PurchaseOrderAppServices.consumer.SoapConsumer;
import com.fuze.po.PurchaseOrderAppServices.entity.POItems;
import com.fuze.po.PurchaseOrderAppServices.entity.PORequest;
import com.fuze.po.PurchaseOrderAppServices.entity.Project;
import com.fuze.po.PurchaseOrderAppServices.exception.PurchaseOrderResourceNotFoundException;
import com.fuze.po.PurchaseOrderAppServices.forms.PORequestForm;
import com.fuze.po.PurchaseOrderAppServices.forms.ProjectForm;
import com.fuze.po.PurchaseOrderAppServices.forms.ProjectSearchForm;
import com.fuze.po.PurchaseOrderAppServices.info.ItemInfo;
import com.fuze.po.PurchaseOrderAppServices.info.PORequestInfo;
import com.fuze.po.PurchaseOrderAppServices.info.ProjectInfo;
import com.fuze.po.PurchaseOrderAppServices.info.ResponseInfo;
import com.fuze.po.PurchaseOrderAppServices.repository.CartItemRepository;
import com.fuze.po.PurchaseOrderAppServices.repository.ItemRepository;
import com.fuze.po.PurchaseOrderAppServices.repository.POItemsRepository;
import com.fuze.po.PurchaseOrderAppServices.repository.PORequestRepository;
import com.fuze.po.PurchaseOrderAppServices.repository.ProjectRepository;

/**
 * @author Bhajuram.c
 *
 */
@Service
public class POService {

	@Autowired
	private PORequestRepository poRequestRepo;
	
	@Autowired
	private ItemRepository itemRepository;

	@Autowired
	POItemsRepository poItemRepository;
	
	@Autowired
	private ProjectRepository projectRepository;
	
	@Autowired
    private CartItemRepository cartItemRepository;
	
	@Autowired
    private SoapConsumer soapConsumer;

	public ResponseInfo createPoRequest(PORequestForm requestForm) {
		ResponseInfo response = new ResponseInfo();
		try {
			PORequest poRequest = populatePORequestEntity(requestForm);
			Set<Project> projects = new HashSet<Project>();
			for (Integer projectId: requestForm.getProjectIds()) {
				/* projects.add(projectRepository.getOne(projectId)); */
				
				Optional<Project> dbProject = projectRepository.findById(projectId);
				projects.add(dbProject.get());
				
				
			}
			poRequest.setProjects(projects);
			// save po
			poRequest = poRequestRepo.save(poRequest);
			
			for (Integer itemid: requestForm.getPoitems()) {
				POItems poItems = new POItems();
				poItems.setItem(itemRepository.getOne(itemid));
				poItems.setPoRequest(poRequest);
				poItemRepository.save(poItems);
			}
			cartItemRepository.deleteAllItemsByCartId();
			
			AddContainerDetailsRequest containerReq = new AddContainerDetailsRequest();
			containerReq.setPoRequestId(poRequest.getId());
			containerReq.setUserId(requestForm.getUserId());
			soapConsumer.addContainerDetails(containerReq);
			
		} catch (Exception e) {
			response.setStatus(false);
		}
		response.setResponseType("PO has been created successfuly");
		response.setStatus(true);
		return response;
	}

	private PORequest populatePORequestEntity(PORequestForm requestForm) {
		PORequest poRequest = new PORequest();
		poRequest.setMarket(requestForm.getMarket());
		poRequest.setPslc(requestForm.getPslc());
		poRequest.setPoStatus(requestForm.getPoStatus());
		poRequest.setSiteTracker(requestForm.getSiteTracker());
		poRequest.setTeritory(requestForm.getTeritory());
		poRequest.setPoName(requestForm.getPoName());
		return poRequest;
	}

	public List<PORequestInfo> getPOList() {
		  List<PORequest> poRequestList = poRequestRepo.findAll();
	      List<PORequestInfo> poRequestInfoList = new ArrayList<PORequestInfo>();
		if(poRequestList ==null || poRequestList.isEmpty()) {
	    	throw new PurchaseOrderResourceNotFoundException("PurchaseOrders NotFound.");
	      }
		if (poRequestList != null && !poRequestList.isEmpty()) {
			for (PORequest po : poRequestList) {
				PORequestInfo poRequestInfo = populatePOInfo(po);

				Set<ItemInfo> itemInfoList = new HashSet<ItemInfo>();
				populateItemsInfo(itemInfoList, poItemRepository.findAllByRequestId(po.getId()));
				poRequestInfo.setItems(itemInfoList);
				
				Set<ProjectInfo> projectInfos = new HashSet<ProjectInfo>();
				populateProjectInfo(projectInfos, po.getProjects());
				poRequestInfo.setProjects(projectInfos);
				poRequestInfoList.add(poRequestInfo);
			}
		}
    	return poRequestInfoList;
	}

	public byte[] generatePoRequestExcel() {
		List<PORequestInfo> poRequestInfoList = getPOList();
		return GenerateExcel.generatePOItemsExcel(poRequestInfoList);
	}
	
	private PORequestInfo populatePOInfo(PORequest po) {
		PORequestInfo poRequestInfo = new PORequestInfo();
		poRequestInfo.setId(po.getId());
		poRequestInfo.setMarket(po.getMarket());
		poRequestInfo.setPoName(po.getPoName());
		poRequestInfo.setPoStatus(po.getPoStatus());
		poRequestInfo.setPslc(po.getPslc());
		poRequestInfo.setTeritory(po.getTeritory());
		poRequestInfo.setSiteTracker(po.getSiteTracker());
		return poRequestInfo;
	}

	private void populateProjectInfo(Set<ProjectInfo> projectInfos, Set<Project> projects) {
		if(projects != null && !projects.isEmpty()) {
			Iterator<Project> it = projects.iterator();
			while (it.hasNext()) {
				ProjectInfo projectInfo = new ProjectInfo();
				BeanUtils.copyProperties(it.next(), projectInfo);
				projectInfos.add(projectInfo);
			}
		}
	}

	private void populateItemsInfo(Set<ItemInfo> itemInfoList, Set<POItems> poItems) {
		if(poItems != null && !poItems.isEmpty()) {
			Iterator<POItems> it = poItems.iterator();
			while (it.hasNext()) {
				ItemInfo itemInfo = new ItemInfo();
				BeanUtils.copyProperties(it.next().getItem(), itemInfo);
				itemInfoList.add(itemInfo);
			}
		}
	}

	/*
	 * public List<ItemInfo> getListOfItemsByPORequestId(Integer poRequestId) {
	 * 
	 * List<POItems> poItems = poItemRepository.findAllByRequestId(poRequestId);
	 * List<ItemInfo> itemList = new ArrayList<ItemInfo>(); if (poItems != null &&
	 * !poItems.isEmpty()) { for (POItems poitem : poItems) { ItemInfo itemInfo =
	 * new ItemInfo(); itemInfo.setId(poitem.getItem().getId());
	 * itemInfo.setDescription(poitem.getItem().getDescription());
	 * itemInfo.setInStock(poitem.getItem().isInStock());
	 * itemInfo.setModel(poitem.getItem().getModel());
	 * itemInfo.setName(poitem.getItem().getName());
	 * itemInfo.setPrice(poitem.getItem().getPrice()); itemList.add(itemInfo); }
	 * 
	 * }
	 */
		//return itemList;

	//}
	
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
	
	public ResponseInfo createProject(ProjectForm projectForm) {
		ResponseInfo responseInfo = new ResponseInfo();
		try {
			Project project = papulateProjectFormEntity(projectForm);
			project = projectRepository.save(project);
		} catch (Exception e) {
			responseInfo.setStatus(false);
		}
		responseInfo.setResponseType("Project has been created successfuly");
		responseInfo.setStatus(true);
		return responseInfo;
	}
	
	
	private Project papulateProjectFormEntity(ProjectForm projectForm) {
		Project project = new Project();
		BeanUtils.copyProperties(projectForm, project);
		return project;
	}


}
