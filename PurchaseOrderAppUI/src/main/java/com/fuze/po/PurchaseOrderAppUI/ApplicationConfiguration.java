package com.fuze.po.PurchaseOrderAppUI;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SuppressWarnings("deprecation")
@Configuration
public class ApplicationConfiguration extends WebMvcConfigurerAdapter{
	 @Override
	    public void addResourceHandlers(ResourceHandlerRegistry registry) {
	        // when static resources are inside resources folder under WEB-INF
	        // registry.addResourceHandler("/resources/**").addResourceLocations("/WEB-INF/resources/");

	        // when static resources are inside static folder under webapp
	        registry.addResourceHandler("/static/**").addResourceLocations("/static/");
	    }
	 
	 @Bean
	 public MessageSource messageSource() {
		 ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		 messageSource.setBasenames("classpath:config");
		 messageSource.setCacheSeconds(10);
		 return messageSource;
	 }

}
