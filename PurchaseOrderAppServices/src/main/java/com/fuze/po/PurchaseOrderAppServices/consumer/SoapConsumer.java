package com.fuze.po.PurchaseOrderAppServices.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

import com.fuze.po.PurchaseOrderAppServices.bean.AddPODetailsRequest;
import com.fuze.po.PurchaseOrderAppServices.bean.AddPODetailsResponse;
import com.fuze.po.PurchaseOrderAppServices.bean.CartDetailsRequest;
import com.fuze.po.PurchaseOrderAppServices.bean.CartItemsDetailsResponse;
import com.fuze.po.PurchaseOrderAppServices.bean.POListRequest;

@Service
@PropertySource("classpath:global.properties")
public class SoapConsumer {

	@Autowired
	private Jaxb2Marshaller jaxb2Marshaller;

	@Value("${PO_CART_BASE_URL}")
	private String cartItemsUrl;

	

	private WebServiceTemplate webServiceTemplate;

	public CartItemsDetailsResponse getCartItemsDetails(CartDetailsRequest request) {
		webServiceTemplate = new WebServiceTemplate(jaxb2Marshaller);
		CartItemsDetailsResponse cartItemsDetailsResponse = (CartItemsDetailsResponse) webServiceTemplate
				.marshalSendAndReceive(cartItemsUrl+"/getCartDetails", request);
		return cartItemsDetailsResponse;
	}

	public AddPODetailsResponse addPORequest(AddPODetailsRequest request) {
		webServiceTemplate = new WebServiceTemplate(jaxb2Marshaller);
		AddPODetailsResponse addPODetailsResponse = (AddPODetailsResponse) webServiceTemplate
				.marshalSendAndReceive(cartItemsUrl+"/createPO", request);
		return addPODetailsResponse;
	}

	public AddPODetailsResponse getPOItemsList(POListRequest request) {
		webServiceTemplate = new WebServiceTemplate(jaxb2Marshaller);
		AddPODetailsResponse addPODetailsResponse = (AddPODetailsResponse) webServiceTemplate
				.marshalSendAndReceive(cartItemsUrl+"/poList", request);
		return addPODetailsResponse;
	}

}
