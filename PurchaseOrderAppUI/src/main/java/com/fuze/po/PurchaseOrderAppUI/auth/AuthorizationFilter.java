package com.fuze.po.PurchaseOrderAppUI.auth;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

public class AuthorizationFilter implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		UserInfo user = (UserInfo)request.getSession().getAttribute("currentUserInfo");
		switch (request.getRequestURI()) {
		case "/reports":
			if(!user.getUserRole().contains("ADMIN")) {
				throw new AuthorizationException();
			}
			break;
		default:
			break;
		}
		
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}
}
