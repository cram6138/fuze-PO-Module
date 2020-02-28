package com.fuze.po.PurchaseOrderAppServices.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
@RestController
@ComponentScan(basePackages = { "com.fuze.*" })
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CartRestConsumer {
	
	@Autowired
	private SoapConsumer client;

	/**
	 * for getting request Id
	 * 
	 * @return List<Cartitems> cartItems
	 */
	@PostMapping("/getCartItemsDetails")
	public CartItemsDetailsResponse invokeSoapClientToGetCartItemsDetails(@RequestBody CartDetailsRequest request){
		return client.getCartItemsDetails(request);
	}

	@PostMapping("/createPO")
	public AddPODetailsResponse addPORequestSoapClientDetails(@RequestBody AddPODetailsRequest request) {
		return client.addPORequest(request);
	}
	
	@GetMapping("/poList")
	public POListResponse poListDetails(POListRequest poListRequest) {
		return client.getPOItemsList(poListRequest);
	}
	
	@PostMapping("/poStatus")
	public POReqStatusResponse poStatusDetails(@RequestBody POReqStatusRequest poReqStatusRequest) {
		return client.getPOStatus(poReqStatusRequest);
	}
	
	@PostMapping("/poRequestEdit")
	public POReqEditResponse poRequestEdit(@RequestBody POReqEditRequest poReqStatusRequest) {
		return client.poRequestEdit(poReqStatusRequest);
	}

}
