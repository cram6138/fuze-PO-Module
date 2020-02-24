package com.fuze.po.PurchaseOrderAppServices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fuze.po.PurchaseOrderAppServices.info.EQuoteInfo;
import com.fuze.po.PurchaseOrderAppServices.info.TemplateInfo;
import com.fuze.po.PurchaseOrderAppServices.info.TemplateItemInfo;
import com.fuze.po.PurchaseOrderAppServices.service.TemplateService;

@RestController
@RequestMapping(path = "/template", produces = "application/json")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TemplateController {

	@Autowired
	private TemplateService templateService;
	
	@PostMapping("/tempList")
	public ResponseEntity<List<TemplateInfo>> getTemplateList() {
		return new ResponseEntity<List<TemplateInfo>>(templateService.templateList(), HttpStatus.OK);
	}
	
	@PostMapping("/tempImport/{tempId}")
	public ResponseEntity<List<TemplateItemInfo>> importTemplateItems(@PathVariable final int tempId) {
		return new ResponseEntity<List<TemplateItemInfo>>(templateService.getTemplateItems(tempId), HttpStatus.OK);
	}
	
	@GetMapping("/eQuotes")
	public ResponseEntity<List<EQuoteInfo>> getEQuoteList() {
		return new ResponseEntity<List<EQuoteInfo>>(templateService.getEQuoteList(), HttpStatus.OK);
	}
	
	@GetMapping("/eQuoteImport/{eQuoteId}")
	public ResponseEntity<List<TemplateItemInfo>> importEQuoteItems(@PathVariable final int tempId) {
		return new ResponseEntity<List<TemplateItemInfo>>(templateService.getTemplateItems(tempId), HttpStatus.OK);
	}
}
