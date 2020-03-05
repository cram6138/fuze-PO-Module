package com.fuze.po.PurchaseOrderAppServices.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fuze.po.PurchaseOrderAppServices.info.ItemInfo;
import com.fuze.po.PurchaseOrderAppServices.info.PORequestInfo;
import com.fuze.po.PurchaseOrderAppServices.entity.Item;
import com.fuze.po.PurchaseOrderAppServices.repository.ItemRepository;

@Service
public class ItemService {
	@Autowired
	private ItemRepository itemRepository;

	public ItemInfo getItemById(int itemId) {
		// TODO Auto-generated method stub
		return null;
	}

	public PORequestInfo getItems(ItemInfo itemInfo) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<ItemInfo> searchItemsList(ItemInfo itemInfo) {
		 List<Item> itemData=itemRepository.searchByAllItems(itemInfo.getId(), itemInfo.getName(), itemInfo.getVendor(), itemInfo.getVendorId(), itemInfo.getDescription());
		 List<ItemInfo> itemInfoList = new ArrayList<ItemInfo>();
		 if (itemData != null && !itemData.isEmpty()) {
				for (Item item : itemData) {
					ItemInfo itemsInfo = new ItemInfo();
					BeanUtils.copyProperties(item, itemsInfo);
					itemInfoList.add(itemsInfo);
				}
			}
		 return itemInfoList;
	}

}
