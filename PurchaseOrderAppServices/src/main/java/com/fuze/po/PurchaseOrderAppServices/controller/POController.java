package com.fuze.po.PurchaseOrderAppServices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fuze.po.PurchaseOrderAppServices.forms.PORequestForm;
import com.fuze.po.PurchaseOrderAppServices.forms.ProjectSearchForm;
import com.fuze.po.PurchaseOrderAppServices.info.PORequestInfo;
import com.fuze.po.PurchaseOrderAppServices.info.ProjectInfo;
import com.fuze.po.PurchaseOrderAppServices.info.ResponseInfo;
import com.fuze.po.PurchaseOrderAppServices.service.POService;

@RestController
@RequestMapping("/RePO")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class POController {

	@Autowired
	private POService poRequestService;

	@PostMapping("/createPORequest")
	public ResponseEntity<ResponseInfo> saveForm(@RequestBody final PORequestForm request) {
		return new ResponseEntity<ResponseInfo>(poRequestService.createPoRequest(request), HttpStatus.OK);}


	@GetMapping("/getPoRequest")
	public ResponseEntity<List<PORequestInfo>> getPOItemListData() {
		return new ResponseEntity<List<PORequestInfo>>(poRequestService.getPOList(), HttpStatus.OK);

	}
	
	/*
	 * @GetMapping("/poItems/{poRequestId}") public ResponseEntity<List<ItemInfo>>
	 * getListOfItemsByPORequestId(@PathVariable int poRequestId) { return new
	 * ResponseEntity<>(poRequestService.getListOfItemsByPORequestId(poRequestId),
	 * HttpStatus.OK); }
	 */

	@PostMapping("/search/project")
	public ResponseEntity<List<ProjectInfo>> searchProjects(@RequestBody final ProjectSearchForm projectSearchForm) {
		return new ResponseEntity<List<ProjectInfo>>(poRequestService.searchProjects(projectSearchForm), HttpStatus.OK);
	}
	
	
	

}
