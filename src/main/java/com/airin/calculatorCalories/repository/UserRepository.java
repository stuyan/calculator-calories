package com.airin.calculatorCalories.repository;

import org.springframework.data.repository.CrudRepository;

import com.airin.calculatorCalories.entity.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Long> {

}
