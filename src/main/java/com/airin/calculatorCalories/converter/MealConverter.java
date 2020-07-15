package com.airin.calculatorCalories.converter;

import org.springframework.stereotype.Component;
import com.airin.calculatorCalories.entity.MealEntity;
import com.airin.calculatorCalories.pfc.Meal;

@Component
public class MealConverter {
	
	public MealEntity mealToMealEntity(Meal meal) {
		MealEntity mealEntity = new MealEntity();
		mealEntity.setCalories(meal.getAllCalories());
		mealEntity.setCarbohydrateCalories(meal.getCarbohydratCalories());
		mealEntity.setCarbohydrateGram(meal.getCarbohydratGram());
		mealEntity.setFatCalories(meal.getFatCalories());
		mealEntity.setFatGram(meal.getFatGram());
		mealEntity.setProteinCalories(meal.getProteinCalories());
		mealEntity.setProteinGram(meal.getProteinGram());
		return mealEntity;
	}
	
	public Meal mealEntityToMeal(MealEntity mealEntity) {
		Meal meal = new Meal();
		meal.setAllCalories(mealEntity.getCalories());
		meal.setCarbohydratCalories(mealEntity.getCarbohydrateCalories());
		meal.setCarbohydratGram(mealEntity.getCarbohydrateGram());
		meal.setFatCalories(mealEntity.getFatCalories());
		meal.setFatGram(mealEntity.getFatGram());
		meal.setProteinCalories(mealEntity.getProteinCalories());
		meal.setProteinGram(mealEntity.getProteinGram());
		return meal;
	}
}
