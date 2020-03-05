package com.fuze.po.PurchaseOrderAppServices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fuze.po.PurchaseOrderAppServices.info.ItemInfo;
import com.fuze.po.PurchaseOrderAppServices.info.PORequestInfo;
import com.fuze.po.PurchaseOrderAppServices.service.ItemService;

@RestController
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
	
	@PostMapping("/searchItems")
	public ResponseEntity<List<ItemInfo>>searchItemsList(@RequestBody ItemInfo itemInfo) {
		return new ResponseEntity<List<ItemInfo>>(itemService.searchItemsList(itemInfo), HttpStatus.OK);
	}

}
