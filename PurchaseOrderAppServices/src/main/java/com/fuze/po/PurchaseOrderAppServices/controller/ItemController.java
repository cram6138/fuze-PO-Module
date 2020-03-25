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
import org.springframework.web.bind.annotation.RestController;

import com.fuze.po.PurchaseOrderAppServices.forms.ItemForm;
import com.fuze.po.PurchaseOrderAppServices.info.ItemInfo;
import com.fuze.po.PurchaseOrderAppServices.info.PORequestInfo;
import com.fuze.po.PurchaseOrderAppServices.info.ResponseInfo;
import com.fuze.po.PurchaseOrderAppServices.service.ItemService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ItemController {
	
	@Autowired
	private ItemService itemService;

	@GetMapping("/getItem/{itemId}")
	public ResponseEntity<ItemInfo> getItemById(@PathVariable int itemId) {
		return new ResponseEntity<ItemInfo>(itemService.getItemById(itemId), HttpStatus.OK);
	}

	@GetMapping("/getItems")
	public ResponseEntity<PORequestInfo> getItems(ItemInfo itemInfo) {
		return new ResponseEntity<PORequestInfo>(itemService.getItems(itemInfo), HttpStatus.OK);
	}
	
	/**
	 * For Getting Item info for a particular search
	 * 
	 * @param Id,name,description,vendor,vendorId
	 * @return List<Item> itemInfo
	 */
	@PostMapping("/searchItems")
	public ResponseEntity<List<ItemInfo>>searchItemsList(@RequestBody ItemInfo itemInfo) {
		return new ResponseEntity<List<ItemInfo>>(itemService.searchItemsList(itemInfo), HttpStatus.OK);
	}
	
	/**
	 * For creating new createItem  
	 * 
	 * @Request  itemForm
	 * @return ResponseInfo 
	 */
	@PostMapping("/createItem")
	public ResponseEntity<ResponseInfo> createItem(@RequestBody ItemForm itemForm) {
		ResponseInfo responseInfo = itemService.createItem(itemForm);
		return new ResponseEntity<ResponseInfo>(responseInfo, HttpStatus.CREATED);
	}

}
