package com.fuze.po.PurchaseOrderAppUI.auth;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED, reason = "Un-Authorize Access")
public class AuthorizationException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1125552459848707385L;

	public AuthorizationException() {

	}

	public AuthorizationException(String message) {
		super(message);
	}

}
