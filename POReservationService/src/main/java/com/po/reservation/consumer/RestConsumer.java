package com.po.reservation.consumer;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.po.reservation.bean.AddContainerDetailsRequest;
import com.po.reservation.bean.AddContainerDetailsResponse;

@RestController
@ComponentScan(basePackages = { "com.fuze.*" })
@CrossOrigin(origins = "*", allowedHeaders = "*")

/**
 * @author Sreelekha
 *
 */
public class RestConsumer {

	@Autowired
	private SoapConsumer client;

	// for adding container details

	@PostMapping("/addContainerDetails")
	public AddContainerDetailsResponse addContainerDetails(@RequestBody AddContainerDetailsRequest request) {
		return client.addContainerDetails(request);
	}

}
