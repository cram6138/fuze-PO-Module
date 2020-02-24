package com.fuze.po.PurchaseOrderAppServices.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fuze.po.PurchaseOrderAppServices.entity.Cart;
import com.fuze.po.PurchaseOrderAppServices.info.CartInfo;
import com.fuze.po.PurchaseOrderAppServices.repository.CartRepository;

@Service
public class CartService {

	@Autowired
	private CartRepository cartRepository;

	public List<CartInfo> getCartList() {
		List<CartInfo> cartInfoList = new ArrayList<CartInfo>();
		List<Cart> catList = cartRepository.findAll();
		
		if (catList != null && !catList.isEmpty()) {
			for (Cart cart : catList) {
				CartInfo cartInfo=new CartInfo();
				BeanUtils.copyProperties(cart, cartInfo);
				cartInfoList.add(cartInfo);
			}
			
			
		}
		return cartInfoList;
		
		
		

	}
	
	public Optional<Cart> getCartById(int cartId) {
		Optional<Cart> catList = cartRepository.findById(cartId);
		return catList;
	}
		
		
}
