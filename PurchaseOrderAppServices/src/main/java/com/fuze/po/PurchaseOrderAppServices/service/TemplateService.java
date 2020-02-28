package com.fuze.po.PurchaseOrderAppServices.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fuze.po.PurchaseOrderAppServices.entity.EQuotes;
import com.fuze.po.PurchaseOrderAppServices.entity.EquoteItems;
import com.fuze.po.PurchaseOrderAppServices.entity.Template;
import com.fuze.po.PurchaseOrderAppServices.entity.TemplateItem;
import com.fuze.po.PurchaseOrderAppServices.info.EQuoteInfo;
import com.fuze.po.PurchaseOrderAppServices.info.EQuoteItemsInfo;
import com.fuze.po.PurchaseOrderAppServices.info.ItemInfo;
import com.fuze.po.PurchaseOrderAppServices.info.TemplateInfo;
import com.fuze.po.PurchaseOrderAppServices.info.TemplateItemInfo;
import com.fuze.po.PurchaseOrderAppServices.repository.EQuoteItemsRepository;
import com.fuze.po.PurchaseOrderAppServices.repository.EQuoteRepository;
import com.fuze.po.PurchaseOrderAppServices.repository.TemplateItemepository;
import com.fuze.po.PurchaseOrderAppServices.repository.TemplateRepository;

/**
 * @author Bhajuram.c
 * 
 * Template Service
 *
 */
@Service
public class TemplateService {

	@Autowired
	private TemplateRepository templateRepository;

	@Autowired
	private EQuoteItemsRepository eQuoteItemsRepository;

	@Autowired
	private EQuoteRepository eQuoteRepository;

	@Autowired
	private TemplateItemepository templateItemRepository;

	/**
	 * @return List<TemplateInfo>
	 */
	public List<TemplateInfo> templateList() {
		List<Template> templateList = templateRepository.findAll();
		List<TemplateInfo> templateInfoList = new ArrayList<TemplateInfo>();

		if (templateList != null && !templateList.isEmpty()) {
			for (Template temp : templateList) {
				TemplateInfo tempInfo = new TemplateInfo();
				BeanUtils.copyProperties(temp, tempInfo);
				templateInfoList.add(tempInfo);
			}
		}
		return templateInfoList;
	}

	/**
	 * @param tempId
	 * @return List<TemplateItemInfo>
	 */
	public List<TemplateItemInfo> getTemplateItems(int tempId) {
		List<TemplateItem> templateItems = templateItemRepository.findAllByTemplateId(tempId);
		List<TemplateItemInfo> templateItemsInfoList = new ArrayList<TemplateItemInfo>();
		if (templateItems != null && !templateItems.isEmpty()) {
			for (TemplateItem item : templateItems) {
				ItemInfo itemInfo = new ItemInfo();
				itemInfo.setId(item.getItem().getId());
				itemInfo.setName(item.getItem().getName());
				itemInfo.setModel(item.getItem().getModel());
				itemInfo.setDescription(item.getItem().getDescription());
				itemInfo.setPrice(item.getItem().getPrice());
				itemInfo.setInStock(item.getItem().isInStock());
				TemplateItemInfo tempItemInfo = new TemplateItemInfo();
				tempItemInfo.setItems(itemInfo);
				tempItemInfo.setQuantity(item.getQuantity());
				templateItemsInfoList.add(tempItemInfo);
			}
		}
		return templateItemsInfoList;
	}

	/**
	 * @return List<EQuoteInfo>
	 */
	public List<EQuoteInfo> getEQuoteList() {
		List<EQuotes> eQuoteList = eQuoteRepository.findAll();
		List<EQuoteInfo> eQuoteInfoList = new ArrayList<EQuoteInfo>();
		if (eQuoteList != null && !eQuoteList.isEmpty()) {
			for (EQuotes eQuote : eQuoteList) {
				EQuoteInfo eQuoteInfo = new EQuoteInfo();
				BeanUtils.copyProperties(eQuote, eQuoteInfo);
				eQuoteInfoList.add(eQuoteInfo);
			}
		}
		return eQuoteInfoList;
	}

	/**
	 * @param eQuoteId
	 * @return List<EQuoteItemsInfo>
	 */
	public List<EQuoteItemsInfo> geteQuoteItems(int eQuoteId) {
		List<EquoteItems> templateItems = eQuoteItemsRepository.findAllByEQuoteId(eQuoteId);
		List<EQuoteItemsInfo> EQuoteItemsInfoList = new ArrayList<EQuoteItemsInfo>();
		if (templateItems != null && !templateItems.isEmpty()) {
			for (EquoteItems item : templateItems) {
				ItemInfo itemInfo = new ItemInfo();
				itemInfo.setId(item.getItem().getId());
				itemInfo.setName(item.getItem().getName());
				itemInfo.setModel(item.getItem().getModel());
				itemInfo.setDescription(item.getItem().getDescription());
				itemInfo.setPrice(item.getItem().getPrice());
				itemInfo.setInStock(item.getItem().isInStock());

				EQuoteItemsInfo EQuoteItemsInfo = new EQuoteItemsInfo();
				EQuoteItemsInfo.setItems(itemInfo);
				EQuoteItemsInfo.setQuantity(item.getQuantity());
				EQuoteItemsInfoList.add(EQuoteItemsInfo);
			}
		}
		return EQuoteItemsInfoList;
	}
}