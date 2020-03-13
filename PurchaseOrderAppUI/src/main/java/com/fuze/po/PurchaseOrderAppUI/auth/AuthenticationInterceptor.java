package com.fuze.po.PurchaseOrderAppUI.auth;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Component
public class AuthenticationInterceptor extends HandlerInterceptorAdapter {

	private static ThreadLocal<String> currentUser = new ThreadLocal<String>();

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		/*
		 * final String authHandler = request.getHeader(Constants.HEADER_NAME); if
		 * (!request.getRequestURL().equals("/auth/login")) { if (authHandler == null ||
		 * !authHandler.startsWith(Constants.BEARER)) { throw new
		 * ForbiddenException("Unauthorized access"); }
		 * 
		 *//** Extract JWT token from header **/
		/*
		 * final String token = authHandler.substring(7);
		 * 
		 * if (token.split("\\.").length < 3) { throw new ForbiddenException(); }
		 * 
		 * Claims claims = null; try { claims =
		 * Jwts.parser().setSigningKey(Constants.JWT_SECRET).parseClaimsJws(token).
		 * getBody(); } catch (Exception e) { throw new Exception(e); }
		 * 
		 * UserClaims user = new UserClaims(claims); currentUser.set(user.username);
		 * request.setAttribute("claims", user); }
		 * 
		 */ //return super.preHandle(request, response, handler);
		return true;
	}

	/** Configure what to apply interceptor to **/
	/*
	 * @Configuration public static class Config extends WebMvcConfigurerAdapter {
	 * 
	 * @Override public void addInterceptors(InterceptorRegistry registry) {
	 * registry.addInterceptor(new
	 * AuthenticationInterceptor()).addPathPatterns("/**")
	 * .excludePathPatterns("/static/**", "/vendor/**", "/auth/login", "/login"); //
	 * WebMvcConfigurer.super.addInterceptors(registry); } }
	 */
}
