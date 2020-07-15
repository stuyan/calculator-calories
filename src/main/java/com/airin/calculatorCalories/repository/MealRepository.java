package com.airin.calculatorCalories.repository;

import org.springframework.data.repository.CrudRepository;

import com.airin.calculatorCalories.entity.MealEntity;

public interface MealRepository extends CrudRepository<MealEntity, Long>{

}
