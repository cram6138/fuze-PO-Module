package com.fuze.po.PurchaseOrderAppServices.controller;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.fuze.po.PurchaseOrderAppServices.exception.PurchaseOrderResourceNotFoundException;
import com.fuze.po.PurchaseOrderAppServices.exception.ResourceExceptionResponse;
@ControllerAdvice
@RestController
public class CustomisedResourceExceptionHandler extends ResponseEntityExceptionHandler{
    
	//method to handle all types of exception
	 @ExceptionHandler(Exception.class) public final ResponseEntity<Object>
	 handleAllExceptions(Exception ex, WebRequest request) throws Exception {
	  ResourceExceptionResponse resourceExceptionResponse=new
	  ResourceExceptionResponse(new
	  Date(),ex.getMessage(),request.getDescription(false)); return new
	  ResponseEntity(resourceExceptionResponse,HttpStatus.INTERNAL_SERVER_ERROR); }
	 
	/*@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
				MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
			ResourceExceptionResponse resourceExceptionResponse=new ResourceExceptionResponse(new Date(),"Input validation failed.",ex.getBindingResult().getFieldError().toString());
			   return  new ResponseEntity(resourceExceptionResponse,HttpStatus.BAD_REQUEST);
		}*/	
	//method to handle container not found.
	@ExceptionHandler(PurchaseOrderResourceNotFoundException.class)
	public final ResponseEntity<Object> handleContainerResourceNotFoundException(PurchaseOrderResourceNotFoundException ex, WebRequest request) throws Exception {
		ResourceExceptionResponse resourceExceptionResponse=new ResourceExceptionResponse(new Date(),ex.getMessage(),request.getDescription(false));
	   return  new ResponseEntity(resourceExceptionResponse,HttpStatus.NOT_FOUND);	
	 }
	
}
