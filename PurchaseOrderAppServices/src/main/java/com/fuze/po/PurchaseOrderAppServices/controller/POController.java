package com.fuze.po.PurchaseOrderAppServices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fuze.po.PurchaseOrderAppServices.entity.PORequest;
import com.fuze.po.PurchaseOrderAppServices.forms.ProjectSearchForm;
import com.fuze.po.PurchaseOrderAppServices.info.ItemInfo;
import com.fuze.po.PurchaseOrderAppServices.info.PORequestInfo;
import com.fuze.po.PurchaseOrderAppServices.info.ProjectInfo;
import com.fuze.po.PurchaseOrderAppServices.service.POService;

@RestController
@RequestMapping("/RePO")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class POController {

	@Autowired
	private POService poRequestService;

	@PostMapping("/save")
	public PORequest saveReq(@RequestBody final PORequest request) {
		return poRequestService.savePORequest(request);
	}

	@GetMapping("/getPoRequest")
	public ResponseEntity<List<PORequestInfo>> getPOItemListData() {
		return new ResponseEntity<List<PORequestInfo>>(poRequestService.getPOList(), HttpStatus.OK);

	}
	
	@GetMapping("/poItems/{poRequestId}")
	public ResponseEntity<List<ItemInfo>> getListOfItemsByPORequestId(@PathVariable int poRequestId) {
		return new ResponseEntity<>(poRequestService.getListOfItemsByPORequestId(poRequestId), HttpStatus.OK);
	}

	@PostMapping("/search/project")
	public ResponseEntity<List<ProjectInfo>> searchProjects(@RequestBody final ProjectSearchForm projectSearchForm) {
		
		return new ResponseEntity<List<ProjectInfo>>(poRequestService.searchProjects(projectSearchForm), HttpStatus.OK);
	}

}
