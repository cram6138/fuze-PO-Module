package com.po.reservation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ContainerResourceNotFoundException extends RuntimeException {
	public ContainerResourceNotFoundException(String message){
		super(message);
}
}
