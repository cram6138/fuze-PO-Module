package com.fuze.po.PurchaseOrderAppUI;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Test {

	public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		byte[] sha256;
		String password = "Welcome2020";
		sha256 = MessageDigest.getInstance("SHA-256").digest(password.getBytes("UTF-8"));
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < sha256.length; i++) {
			sb.append(Integer.toString((sha256[i] & 0xff) + 0x100, 16).substring(1));
		}
		System.out.println(sb.toString());
	}

}
