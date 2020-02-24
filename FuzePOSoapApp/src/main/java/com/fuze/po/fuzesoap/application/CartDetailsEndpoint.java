package com.fuze.po.fuzesoap.application;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.cartproduceritem.cartdetails.CartDetailsRequest;
import com.cartproduceritem.cartdetails.CartItemsDetailsResponse;
import com.cartproduceritem.cartdetails.Cartitems;
import com.cartproduceritem.cartdetails.Item;
import com.createpocartproducer.createpo.AddPODetailsRequest;
import com.createpocartproducer.createpo.AddPODetailsResponse;
import com.createpocartproducer.createpo.Itempojo;
import com.createpocartproducer.createpo.Pores;
import com.fuze.po.fuzesoap.application.entity.CartItemsEntity;
import com.fuze.po.fuzesoap.application.entity.POItemsEntity;
import com.fuze.po.fuzesoap.application.entity.PORequestEntity;
import com.fuze.po.fuzesoap.application.repository.CartItemRepository;
import com.fuze.po.fuzesoap.application.repository.ItemEntityRepository;
import com.fuze.po.fuzesoap.application.repository.POItemsEntityRepository;
import com.fuze.po.fuzesoap.application.repository.PORequestEntityRepository;

@Endpoint
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CartDetailsEndpoint {

	private static final String NAMESPACE_URI_CART_DETAILS = "http://www.cartproduceritem.com/cartdetails";

	private static final String NAMESPACE_URI_CREATE_PO = "http://www.createpocartproducer.com/createpo";

	@Autowired
	private CartItemRepository cartItemRepository;

	@Autowired
	private PORequestEntityRepository poRequestEntityRepository;

	@Autowired
	private POItemsEntityRepository poItemsEntityRepo;

	@Autowired
	private ItemEntityRepository itemRepo;

	@ResponsePayload
	@PayloadRoot(namespace = NAMESPACE_URI_CART_DETAILS, localPart = "CartDetailsRequest")
	public CartItemsDetailsResponse getCarts(@RequestPayload CartDetailsRequest request) {
		CartItemsDetailsResponse cartItemsDetailsResponse = new CartItemsDetailsResponse();
		List<Cartitems> cartItemsList = new ArrayList<Cartitems>();
		try {
			List<CartItemsEntity> cartItems = cartItemRepository.findByCartId(request.getId());
			for (CartItemsEntity loopci : cartItems) {
				XMLGregorianCalendar xmlDate = null;
				GregorianCalendar gc = new GregorianCalendar();
				gc.setTime(new Date());
				xmlDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);

				Item item = new Item();
				item.setId(loopci.getItem().getId());
				item.setName(loopci.getItem().getName());
				item.setContractId(loopci.getItem().getContractId());
				item.setDueDate(xmlDate);
				item.setShipToId(loopci.getItem().getShipToId());
				item.setActivity(loopci.getItem().getActivity());
				item.setComments(loopci.getItem().getComments());
				item.setModel(loopci.getItem().getModel());
				item.setPrice(loopci.getItem().getPrice());
				item.setDescription(loopci.getItem().getDescription());
				item.setInStock(loopci.getItem().isInStock());

				Cartitems cartItemsRes = new Cartitems();
				cartItemsRes.setItem(item);
				cartItemsRes.setQuantity(loopci.getQuantity());
				cartItemsList.add(cartItemsRes);
			}
			cartItemsDetailsResponse.setCartitems(cartItemsList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cartItemsDetailsResponse;
	}

	@ResponsePayload
	@PayloadRoot(namespace = NAMESPACE_URI_CREATE_PO, localPart = "AddPODetailsRequest")
	public AddPODetailsResponse createPO(@RequestPayload AddPODetailsRequest request) {
		AddPODetailsResponse cartItemsDetailsResponse = new AddPODetailsResponse();
		Pores poRes = new Pores();
		try {
			Optional<PORequestEntity> dbPORequestEntity = poRequestEntityRepository
					.findById(request.getPoreq().getId());
			if (dbPORequestEntity.isPresent()) {
				POItemsEntity poItemsEntity = new POItemsEntity();
				poItemsEntity.setPoRequestEntity(dbPORequestEntity.get());

				for (Itempojo row : request.getPoreq().getItempojo()) {
					POItemsEntity poItemsEntityrow = new POItemsEntity();
					poItemsEntityrow.setItemEntity(itemRepo.getOne(row.getId()));
					poItemsEntityrow
							.setPoRequestEntity(poRequestEntityRepository.findById(request.getPoreq().getId()).get());
					poItemsEntityRepo.save(poItemsEntityrow);
				}
				poRes.setMessage("PO Created Successfully.");
				poRes.setStatus(true);
				cartItemsDetailsResponse.setPores(poRes);
			} else {
				poRes.setMessage("PO's not available.");
				poRes.setStatus(false);
				cartItemsDetailsResponse.setPores(poRes);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cartItemsDetailsResponse;
	}

}
