package com.po.reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.po.reservation.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findById(int id);
}