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

import com.fuze.po.PurchaseOrderAppServices.forms.TemplateForm;
import com.fuze.po.PurchaseOrderAppServices.info.EQuoteInfo;
import com.fuze.po.PurchaseOrderAppServices.info.EQuoteItemsInfo;
import com.fuze.po.PurchaseOrderAppServices.info.ResponseInfo;
import com.fuze.po.PurchaseOrderAppServices.info.TemplateInfo;
import com.fuze.po.PurchaseOrderAppServices.info.TemplateItemInfo;
import com.fuze.po.PurchaseOrderAppServices.service.TemplateService;

/**
 * @author Bhajuram.c
 *
 */
@RestController
@RequestMapping(path = "/template", produces = "application/json")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TemplateController {

	@Autowired
	private TemplateService templateService;

	/**
	 * for Getting list of template
	 * 
	 * @return List<TemplateInfo> templateInfoList
	 */
	@PostMapping("/tempList")
	public ResponseEntity<List<TemplateInfo>> getTemplateList() {
		return new ResponseEntity<List<TemplateInfo>>(templateService.templateList(), HttpStatus.OK);
	}

	/**
	 * For Getting template Item info for a particular template
	 * 
	 * @param tempId
	 * @return List<TemplateItemInfo> templateItemInfo
	 */
	@PostMapping("/tempImport/{tempId}")
	public ResponseEntity<List<TemplateItemInfo>> importTemplateItems(@PathVariable final int tempId) {
		return new ResponseEntity<List<TemplateItemInfo>>(templateService.getTemplateItems(tempId), HttpStatus.OK);
	}

	/**
	 * for getting list of eQuoteInfo
	 * 
	 * @return List<EQuoteInfo> eQuoteInfoList
	 */
	@GetMapping("/eQuotes")
	public ResponseEntity<List<EQuoteInfo>> getEQuoteList() {
		return new ResponseEntity<List<EQuoteInfo>>(templateService.getEQuoteList(), HttpStatus.OK);
	}

	/**
	 * for getting eQuoteItemsInfo for a particular eQuote
	 * 
	 * @param eQuoteId
	 * @return List<EQuoteItemsInfo> eQuoteItemInfo
	 */
	@PostMapping("/eQuoteImport/{eQuoteId}")
	public ResponseEntity<List<EQuoteItemsInfo>> importEQuoteItems(@PathVariable final int eQuoteId) {
		return new ResponseEntity<List<EQuoteItemsInfo>>(templateService.geteQuoteItems(eQuoteId), HttpStatus.OK);
	}
	/**
	 * For creating createTemplate templateForm 
	 * 
	 * @Request  templateForm
	 * @return ResponseInfo 
	 */
	@PostMapping("/createTemplate")
	public ResponseEntity<ResponseInfo> createTemplate(@RequestBody TemplateForm templateForm) {
			ResponseInfo responseData = templateService.createTemplate(templateForm);
			return new ResponseEntity<ResponseInfo>(responseData, HttpStatus.CREATED);
	}
}
