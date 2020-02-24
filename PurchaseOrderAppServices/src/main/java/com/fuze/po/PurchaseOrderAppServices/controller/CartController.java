package com.fuze.po.PurchaseOrderAppServices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fuze.po.PurchaseOrderAppServices.entity.Cart;
import com.fuze.po.PurchaseOrderAppServices.info.CartInfo;
import com.fuze.po.PurchaseOrderAppServices.service.CartService;

@RestController
@RequestMapping(produces = "application/json")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CartController {

	@Autowired
	private CartService cartService;


	@GetMapping("/getCart")
	public ResponseEntity<List<CartInfo>> getCartListData() {
		return new ResponseEntity<List<CartInfo>>(cartService.getCartList(), HttpStatus.OK);

	}

	@GetMapping("/getCart/{cartId}")
	public ResponseEntity<List<Cart>> getCartById(@PathVariable int cartId) {
		return new ResponseEntity(cartService.getCartById(cartId), HttpStatus.OK);

	}

	

}
