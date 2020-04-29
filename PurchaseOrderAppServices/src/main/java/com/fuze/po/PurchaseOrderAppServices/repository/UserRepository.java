package com.fuze.po.PurchaseOrderAppServices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fuze.po.PurchaseOrderAppServices.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	public User findByUsernameAndPassword(String username, String sha256);

}
