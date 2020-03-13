package com.fuze.po.PurchaseOrderAppUI.auth;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuthenticationAdvice {
	
	@Autowired
	HttpServletRequest request;

	@Before("execution(* com.fuze.po.PurchaseOrderAppUI.controller..*(..)))")
	public void validateUserSession() {
		String uri = request.getRequestURI();
		if(!uri.equals("/") && request.getSession().getAttribute("currentUserInfo") == null) {
			throw new AuthenticationException();
		}
	}
	
}
