package com.fuze.po.PurchaseOrderAppUI.auth;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer>{

	public User findByUsernameAndPassword(String username, String sha256);

}
