package com.fuze.po.PurchaseOrderAppServices.controller;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fuze.po.PurchaseOrderAppServices.forms.PORequestForm;
import com.fuze.po.PurchaseOrderAppServices.forms.ProjectForm;
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

	@GetMapping("/generatePORequestExcel")
	public ResponseEntity<InputStreamResource> generatePORequestExcel() {
		try {  
			String filename = "FuzePOExcel.xlsx";
			byte[] stream = poRequestService.generatePoRequestExcel();
			if (stream.length != 0) {
				MediaType mediaType = MediaType.parseMediaType("application/vnd.ms-excel");
				File file = new File(filename);
				FileUtils.writeByteArrayToFile(file, stream);
				InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

				return ResponseEntity.ok() .header(HttpHeaders.CONTENT_DISPOSITION,
						"attachment;filename=" + file.getName()) .contentType(mediaType)
						.contentLength(file.length()) .body(resource);

			}else{
				return ResponseEntity.noContent().build();
			}
		} catch (Exception e) {
			return ResponseEntity.noContent().build();
		}
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

	@PostMapping("/createProject")
	public ResponseEntity<ResponseInfo> createProject(@RequestBody ProjectForm projectForm) {
		ResponseInfo responseData = poRequestService.createProject(projectForm);
		return new ResponseEntity<ResponseInfo>(responseData, HttpStatus.CREATED);
	}


}
