package com.fuze.po.PurchaseOrderAppServices.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fuze.po.PurchaseOrderAppServices.bean.AddPODetailsRequest;
import com.fuze.po.PurchaseOrderAppServices.bean.AddPODetailsResponse;
import com.fuze.po.PurchaseOrderAppServices.bean.CartDetailsRequest;
import com.fuze.po.PurchaseOrderAppServices.bean.CartItemsDetailsResponse;
import com.fuze.po.PurchaseOrderAppServices.bean.POListRequest;

@RestController
@ComponentScan(basePackages = { "com.fuze.*" })
public class CartRestConsumer {
	
	@Autowired
	private SoapConsumer client;

	
	@PostMapping("/getCartItemsDetails")
	public CartItemsDetailsResponse invokeSoapClientToGetCartItemsDetails(@RequestBody CartDetailsRequest request) {
		return client.getCartItemsDetails(request);
	}

	@PostMapping("/createPO")
	public AddPODetailsResponse addPORequestSoapClientDetails(@RequestBody AddPODetailsRequest request) {
		return client.addPORequest(request);
	}
	
	@GetMapping("/poList")
	public AddPODetailsResponse addPORequestSoapClientDetails(@RequestBody POListRequest poListRequest) {
		return client.getPOItemsList(poListRequest);
	}

}
