package com.fuze.po.fuzesoap.application;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;
import org.springframework.xml.xsd.XsdSchemaCollection;
import org.springframework.xml.xsd.commons.CommonsXsdSchemaCollection;

@EnableWs
@Configuration
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SoapWSConfiguration extends WsConfigurerAdapter {

	@Bean
	public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(
			ApplicationContext applicationContext) {
		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(applicationContext);
		servlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean(servlet, "/soapWs/*");
	}

	@Bean(name = "cartDetails")
	public DefaultWsdl11Definition getCartDetails(XsdSchema cartDetailsXsdSchema) {
		DefaultWsdl11Definition cartDetailsWsdl = new DefaultWsdl11Definition();
		cartDetailsWsdl.setPortTypeName("CartDetailsPort");
		cartDetailsWsdl.setLocationUri("/soapWs/getCartDetails");
		cartDetailsWsdl.setTargetNamespace("http://www.cartproduceritem.com/cartdetails");
		cartDetailsWsdl.setSchema(cartDetailsXsdSchema);
		return cartDetailsWsdl;
	}

	@Bean(name = "createPO")
	public DefaultWsdl11Definition createPO() throws Exception {
		DefaultWsdl11Definition createPOWsdl = new DefaultWsdl11Definition();
		createPOWsdl.setPortTypeName("createPOPort");
		createPOWsdl.setLocationUri("/soapWs/createPO");
		createPOWsdl.setTargetNamespace("http://www.createpocartproducer.com/createpo");
		createPOWsdl.setSchemaCollection(getCreatePOXsdFile());
		return createPOWsdl;
	}

	@Bean(name = "poList")
	public DefaultWsdl11Definition poList() throws Exception {
		DefaultWsdl11Definition poListWsdl = new DefaultWsdl11Definition();
		poListWsdl.setPortTypeName("poListPort");
		poListWsdl.setLocationUri("/soapWs/poList");
		poListWsdl.setTargetNamespace("http://www.polistproduceritem.com/polist");
		poListWsdl.setSchemaCollection(poListXsdFile());
		return poListWsdl;
	}

	@Bean(name = "poReqStatus")
	public DefaultWsdl11Definition poReqStatus() throws Exception {
		DefaultWsdl11Definition poReqStatusWsdl = new DefaultWsdl11Definition();
		poReqStatusWsdl.setPortTypeName("poReqStatusPort");
		poReqStatusWsdl.setLocationUri("/soapWs/poReqStatus");
		poReqStatusWsdl.setTargetNamespace("http://www.poreqstatusproducer.com/poreqstatus");
		poReqStatusWsdl.setSchemaCollection(poReqStatusXsdFile());
		return poReqStatusWsdl;
	}

	@Bean(name = "poReqEdit")
	public DefaultWsdl11Definition poReqEdit() throws Exception {
		DefaultWsdl11Definition poReqEditWsdl = new DefaultWsdl11Definition();
		poReqEditWsdl.setPortTypeName("poReqEditPort");
		poReqEditWsdl.setLocationUri("/soapWs/poReqEdit");
		poReqEditWsdl.setTargetNamespace("http://www.poreqeditproducer.com/poreqedit");
		poReqEditWsdl.setSchemaCollection(poReqEditXsdFile());
		return poReqEditWsdl;
	}

	@Bean
	public XsdSchema cartDetailsXsdSchema() {
		return new SimpleXsdSchema(new ClassPathResource("cartdetails.xsd"));
	}

	@Bean
	public XsdSchemaCollection getCreatePOXsdFile() throws Exception {
		CommonsXsdSchemaCollection xsds = new CommonsXsdSchemaCollection(new ClassPathResource("createpo.xsd"));
		xsds.setInline(true);
		return xsds;
	}

	@Bean
	public XsdSchemaCollection poListXsdFile() throws Exception {
		CommonsXsdSchemaCollection xsds = new CommonsXsdSchemaCollection(new ClassPathResource("polist.xsd"));
		xsds.setInline(true);
		return xsds;
	}

	@Bean
	public XsdSchemaCollection poReqStatusXsdFile() throws Exception {
		CommonsXsdSchemaCollection xsds = new CommonsXsdSchemaCollection(new ClassPathResource("poreqstatus.xsd"));
		xsds.setInline(true);
		return xsds;
	}

	@Bean
	public XsdSchemaCollection poReqEditXsdFile() throws Exception {
		CommonsXsdSchemaCollection xsds = new CommonsXsdSchemaCollection(new ClassPathResource("poreqedit.xsd"));
		xsds.setInline(true);
		return xsds;
	}

}
