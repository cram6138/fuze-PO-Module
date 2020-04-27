package com.fuze.po.PurchaseOrderAppServices.auth;

import java.io.UncheckedIOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.JwsHeader;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.DefaultJwsHeader;
import io.jsonwebtoken.impl.TextCodec;

public class JwtProperties {

	private String secretKey;
	private SignatureAlgorithm signatureAlgorithm;
	
	public String getSecretKey() {
		return secretKey;
	}
	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}
	public SignatureAlgorithm getSignatureAlgorithm() {
		return signatureAlgorithm;
	}
	public void setSignatureAlgorithm(SignatureAlgorithm signatureAlgorithm) {
		this.signatureAlgorithm = signatureAlgorithm;
	} 
	
	public String getBase64UrlEncodedHeader() {
		
		@SuppressWarnings("rawtypes")
		JwsHeader header = new DefaultJwsHeader();
		header.setAlgorithm(getSignatureAlgorithm().getValue());
		
		ObjectMapper objectMapper = new ObjectMapper();
		byte[] bytes;
		try {
			bytes = objectMapper.writeValueAsBytes(header);
			return TextCodec.BASE64URL.encode(bytes);
		} catch (JsonProcessingException e) {
			throw new UncheckedIOException(e);
		}
	}
	
}
