package com.fuze.po.PurchaseOrderAppServices.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(HttpStatus.NOT_FOUND)
public class PurchaseOrderResourceNotFoundException extends RuntimeException {
	public PurchaseOrderResourceNotFoundException(String message){
		super(message);
}
}
