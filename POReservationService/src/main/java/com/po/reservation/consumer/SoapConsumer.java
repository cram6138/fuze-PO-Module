package com.po.reservation.consumer;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

import com.po.reservation.bean.AddContainerDetailsRequest;
import com.po.reservation.bean.AddContainerDetailsResponse;

/**
 * @author Sreelekha
 *
 */

@Service
@PropertySource("classpath:global.properties")
public class SoapConsumer {
	private static Logger logger = LoggerFactory.getLogger(SoapConsumer.class);

	@Autowired
	private Jaxb2Marshaller jaxb2Marshaller;

	@Value("${SOAP_BASE_URL}")
	private String soapBaseUrl;

	private WebServiceTemplate webServiceTemplate;

	// consume the addContainerDetails From soap application

	public AddContainerDetailsResponse addContainerDetails(AddContainerDetailsRequest addContainerDetailsRequest) {
		logger.info("Entering in SoapConsumer class in AddContainerDetails method");
		webServiceTemplate = new WebServiceTemplate(jaxb2Marshaller);
		AddContainerDetailsResponse addContainerDetailsResponse = null;
		try {
			addContainerDetailsResponse = (AddContainerDetailsResponse) webServiceTemplate
					.marshalSendAndReceive(soapBaseUrl + "/addContainerDetails", addContainerDetailsRequest);
		} catch (Exception e) {
			logger.info("Exception  in AddContainerDetails  method" + e.getMessage());
		}
		return addContainerDetailsResponse;
	}

}
