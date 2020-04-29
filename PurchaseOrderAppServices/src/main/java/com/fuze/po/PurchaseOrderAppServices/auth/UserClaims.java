package com.fuze.po.PurchaseOrderAppServices.auth;

import java.util.List;

import io.jsonwebtoken.Claims;

public class UserClaims {

	public final int id;
	public final String username;
	public final String territory;
	public final String market;
	public final String subMarket;
	public final List<String> roles;
	
	@SuppressWarnings("unchecked")
	public UserClaims(Claims claims) {
		this.id = (int)claims.get("id");
		this.username = (String) claims.get("username");
		this.territory = (String) claims.get("territory");
		this.market = (String) claims.get("market");
		this.subMarket = (String) claims.get("subMarket");
		this.roles = (List<String>) claims.get("roles");
	}
	
	
}
