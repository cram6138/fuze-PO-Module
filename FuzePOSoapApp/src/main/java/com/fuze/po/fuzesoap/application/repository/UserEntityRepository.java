package com.fuze.po.fuzesoap.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fuze.po.fuzesoap.application.entity.UserEntity;

public interface UserEntityRepository extends JpaRepository<UserEntity, Integer> {

}
