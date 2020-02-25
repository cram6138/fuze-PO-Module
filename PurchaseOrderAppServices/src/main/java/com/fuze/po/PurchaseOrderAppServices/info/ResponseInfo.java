package com.fuze.po.PurchaseOrderAppServices.info;

import java.util.Map;

public class ResponseInfo {
	
	private boolean status;
	private String responseType;
	private Map<String, String> errorMsg;
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getResponseType() {
		return responseType;
	}
	public void setResponseType(String responseType) {
		this.responseType = responseType;
	}
	public Map<String, String> getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(Map<String, String> errorMsg) {
		this.errorMsg = errorMsg;
	}

}
