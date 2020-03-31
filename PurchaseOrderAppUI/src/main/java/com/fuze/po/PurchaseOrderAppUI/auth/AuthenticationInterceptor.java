package com.fuze.po.PurchaseOrderAppUI.auth;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
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

		final String authHandler = request.getHeader(Constants.HEADER_NAME);
		if (request.getSession().getAttribute("currentUserInfo") == null) {
			throw new AuthenticationException();
		}
		return super.preHandle(request, response, handler);
		// return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		super.postHandle(request, response, handler, modelAndView);
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
		super.afterCompletion(request, response, handler, ex);
	}
	/** Configure what to apply interceptor to **/

	@Configuration
	public static class Config extends WebMvcConfigurerAdapter {

		@Override
		public void addInterceptors(InterceptorRegistry registry) {
			registry.addInterceptor(new AuthenticationInterceptor()).addPathPatterns("/**")
			.excludePathPatterns("/", "/static/**",
					"/PurchaseOrderAppUI-0.0.1-SNAPSHOT/", "/vendor/**",
					"/PurchaseOrderAppUI-0.0.1-SNAPSHOT/login", "/login"); //
			// WebMvcConfigurer.super.addInterceptors(registry);
		}
	}

}
