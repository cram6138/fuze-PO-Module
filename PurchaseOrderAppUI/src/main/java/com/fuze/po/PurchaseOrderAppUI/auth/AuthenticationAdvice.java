package com.fuze.po.PurchaseOrderAppUI.auth;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuthenticationAdvice {
	private static final Logger LOGGER = LogManager.getLogger(AuthenticationAdvice.class);
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	private Environment env;

	@Before("execution(* com.fuze.po.PurchaseOrderAppUI.controller..*(..)))")
	public void validateUserSession() {
		String uri = request.getRequestURI();
		LOGGER.info(":::::::::::::: URI ::::::: " + uri);
		boolean condition = env.getProperty("mode").equals("prod")? uri.equals("/PurchaseOrderAppUI-0.0.1-SNAPSHOT/") : uri.equals("/");
		if (!condition && request.getSession().getAttribute("currentUserInfo") == null) {
			throw new AuthenticationException();
		}
	}

}
