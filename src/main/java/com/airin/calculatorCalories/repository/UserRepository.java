package com.airin.calculatorCalories.repository;

import org.springframework.data.repository.CrudRepository;

import com.airin.calculatorCalories.entity.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
	
	// Native query - на языке sql
	//@Query(value = "Select * from users where name = 'Airin'", nativeQuery = true)
	//UserEntity findAirin();
}
