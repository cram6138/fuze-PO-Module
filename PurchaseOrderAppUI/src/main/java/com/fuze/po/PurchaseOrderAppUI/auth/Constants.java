package com.fuze.po.PurchaseOrderAppUI.auth;

import java.util.concurrent.TimeUnit;

public class Constants {
	
	public static final String HEADER_NAME = "Authorization";
	public static final String JWT_SECRET = "secretKey";
	public static final String BEARER = "Bearer";
	public static final Long JWT_TOKEN_DURATION = TimeUnit.HOURS.toMillis(5);
}
