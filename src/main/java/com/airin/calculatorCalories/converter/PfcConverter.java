package com.airin.calculatorCalories.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.airin.calculatorCalories.entity.PfcEntity;
import com.airin.calculatorCalories.pfc.Pfc;

@Component
public class PfcConverter {
	
	@Autowired
	private MealConverter mealConverter;
		
	public PfcEntity pfcToPfcEntity(Pfc pfc) {
		PfcEntity pfcEntity = new PfcEntity();
		pfcEntity.setBreakfast(mealConverter.mealToMealEntity(pfc.getBreakfast()));
		pfcEntity.setDinner(mealConverter.mealToMealEntity(pfc.getDinner()));
		pfcEntity.setNoon(mealConverter.mealToMealEntity(pfc.getNoon()));
		pfcEntity.setSnack(mealConverter.mealToMealEntity(pfc.getSnack()));
		return pfcEntity;
	}
	
	public Pfc pfcEntityToPfc(PfcEntity pfcEntity) {
		Pfc pfc = new Pfc();
		pfc.setBreakfast(mealConverter.mealEntityToMeal(pfcEntity.getBreakfast()));
		pfc.setDinner(mealConverter.mealEntityToMeal(pfcEntity.getDinner()));
		pfc.setNoon(mealConverter.mealEntityToMeal(pfcEntity.getNoon()));
		pfc.setSnack(mealConverter.mealEntityToMeal(pfcEntity.getSnack()));
		return pfc;
	}
}
