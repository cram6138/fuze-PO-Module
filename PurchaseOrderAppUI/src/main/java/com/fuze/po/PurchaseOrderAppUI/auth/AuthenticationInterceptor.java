package com.fuze.po.PurchaseOrderAppUI.auth;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class AuthenticationInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	private ServletContext servletContext;
	//private static ThreadLocal<String> currentUser = new ThreadLocal<String>();

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//request.getSe
		//if (request.getRequestURI().contains("/index/") && !request.getRequestURI().contains("static/")) {
		if (request.getRequestURI().contains("/")) {
			servletContext = request.getServletContext();
			String sessionId = request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/") +1);
			if (sessionId.length() == 32) {
				HttpSession session = (HttpSession)servletContext.getAttribute(sessionId);
				request.getSession().setAttribute("currentUserInfo", session.getAttribute("currentUserInfo"));
			}
		}
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
			.excludePathPatterns("/", "/static/**", "/ang/login",
					"/PurchaseOrderAppUI-0.0.1-SNAPSHOT/", "/vendor/**",
					"/PurchaseOrderAppUI-0.0.1-SNAPSHOT/login", "/login"); 
			registry.addInterceptor(new AuthorizationFilter());
			// WebMvcConfigurer.super.addInterceptors(registry);
		}
		
		/*
		 * @Override public void addCorsMappings(CorsRegistry registry) {
		 * registry.addMapping("/**").allowedOrigins("http://localhost:4200").
		 * allowedHeaders("*"); super.addCorsMappings(registry); }
		 */
	
	}

}
