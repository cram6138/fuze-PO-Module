package com.fuze.po.PurchaseOrderAppServices.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

import com.fuze.po.PurchaseOrderAppServices.bean.AddCartItemsRequest;
import com.fuze.po.PurchaseOrderAppServices.bean.AddCartItemsResponse;
import com.fuze.po.PurchaseOrderAppServices.bean.AddPODetailsRequest;
import com.fuze.po.PurchaseOrderAppServices.bean.AddPODetailsResponse;
import com.fuze.po.PurchaseOrderAppServices.bean.CartDetailsRequest;
import com.fuze.po.PurchaseOrderAppServices.bean.CartItemsDetailsResponse;
import com.fuze.po.PurchaseOrderAppServices.bean.POListRequest;
import com.fuze.po.PurchaseOrderAppServices.bean.POListResponse;
import com.fuze.po.PurchaseOrderAppServices.bean.POReqEditRequest;
import com.fuze.po.PurchaseOrderAppServices.bean.POReqEditResponse;
import com.fuze.po.PurchaseOrderAppServices.bean.POReqStatusRequest;
import com.fuze.po.PurchaseOrderAppServices.bean.POReqStatusResponse;

/**
 * @author Gobinda Majhi
 *
 */
@Service
@PropertySource("classpath:global.properties")
public class SoapConsumer {

	private static Logger logger = LoggerFactory.getLogger(SoapConsumer.class);

	@Autowired
	private Jaxb2Marshaller jaxb2Marshaller;

	@Value("${PO_CART_BASE_URL}")
	private String cartItemsUrl;

	private WebServiceTemplate webServiceTemplate;

	public CartItemsDetailsResponse getCartItemsDetails(CartDetailsRequest request) {
		logger.info("Entering in SoapConsumer class in getCartItemsDetails method");
		webServiceTemplate = new WebServiceTemplate(jaxb2Marshaller);
		CartItemsDetailsResponse cartItemsDetailsResponse = null;
		try {
			cartItemsDetailsResponse = (CartItemsDetailsResponse) webServiceTemplate
					.marshalSendAndReceive(cartItemsUrl + "/getCartDetails", request);

		} catch (Exception e) {
			logger.error("Exception in getCartItemsDetails method" + e.getMessage());
		}
		return cartItemsDetailsResponse;
	}

	public AddPODetailsResponse addPORequest(AddPODetailsRequest request) {
		webServiceTemplate = new WebServiceTemplate(jaxb2Marshaller);
		logger.info("Entering in SoapConsumer class in addPORequest method");
		AddPODetailsResponse addPODetailsResponse = null;
		try {
			addPODetailsResponse = (AddPODetailsResponse) webServiceTemplate
					.marshalSendAndReceive(cartItemsUrl + "/createPO", request);
		} catch (Exception e) {
			logger.error("Exception in addPORequest method" + e.getMessage());
		}
		return addPODetailsResponse;
	}

	public POListResponse getPOItemsList(POListRequest request) {
		logger.info("Entering in SoapConsumer class in getPOItemsList method");
		webServiceTemplate = new WebServiceTemplate(jaxb2Marshaller);
		POListResponse poListResponse = null;
		try {
			poListResponse = (POListResponse) webServiceTemplate
					.marshalSendAndReceive(cartItemsUrl + "/poList",request);
		} catch (Exception e) {
			logger.info("Exception  in getPOItemsList method" + e.getMessage());
		}
		return poListResponse;
	}

	public POReqStatusResponse getPOStatus(POReqStatusRequest PORequest) {
		logger.info("Entering in SoapConsumer class in getPOStatus method");
		webServiceTemplate = new WebServiceTemplate(jaxb2Marshaller);
		POReqStatusResponse poReqStatusResponse = null;
		try {
			poReqStatusResponse = (POReqStatusResponse) webServiceTemplate
					.marshalSendAndReceive(cartItemsUrl + "/poReqStatus", PORequest);
		} catch (Exception e) {
			logger.info("Exception  in getPOStatus method" + e.getMessage());
		}
		return poReqStatusResponse;
	}

	public POReqEditResponse poRequestEdit(POReqEditRequest poReqEditRequest) {
		logger.info("Entering in SoapConsumer class in poRequestEdit method");
		webServiceTemplate = new WebServiceTemplate(jaxb2Marshaller);
		POReqEditResponse poReqEditResponse = null;
		try {
			poReqEditResponse = (POReqEditResponse) webServiceTemplate
					.marshalSendAndReceive(cartItemsUrl + "/poReqEdit", poReqEditRequest);
		} catch (Exception e) {
			logger.info("Exception  in poRequestEdit method" + e.getMessage());
		}
		return poReqEditResponse;
	}
	
	public AddCartItemsResponse addCartItems(AddCartItemsRequest addCartItemsRequest) {
		logger.info("Entering in SoapConsumer class in addCartItemsResponse method");
		webServiceTemplate = new WebServiceTemplate(jaxb2Marshaller);
		AddCartItemsResponse addCartItemsResponse = null;
		try {
			addCartItemsResponse = (AddCartItemsResponse) webServiceTemplate
					.marshalSendAndReceive(cartItemsUrl + "/addCartItems", addCartItemsRequest);
		} catch (Exception e) {
			logger.info("Exception  in addCartItemsResponse method" + e.getMessage());
		}
		return addCartItemsResponse;
	}

}
