package com.airin.calculatorCalories.calculators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airin.calculatorCalories.converter.CaloriesToGramСonverter;
import com.airin.calculatorCalories.pfc.Meal;
import com.airin.calculatorCalories.pfc.Pfc;

@Service
public class CalculatorPFC {
	
	@Autowired
	private CaloriesToGramСonverter converter;
	
	public Pfc calculate(int allCalories) {
		var pfc = new Pfc();
		var bdCalor = breakfastOrDinnerCalor(allCalories);
		pfc.setBreakfast(makeMeal(bdCalor));
		pfc.setDinner(makeMeal(bdCalor));
		var nCalor = noonCalor(allCalories);
		pfc.setNoon(makeMeal(nCalor));
		var sCalor = snackCalorint(allCalories);
		pfc.setSnack(makeMeal(sCalor));
		return pfc;
	}
	
	public Meal makeMeal(int calor) {
		var meal = new Meal();
		meal.setAllCalories(calor);
		meal.setCarbohydratCalories(carbohydrate(calor));
		meal.setCarbohydratGram(converter.convertToGram(meal.getCarbohydratCalories(), "c"));
		meal.setProteinCalories(protein(calor));
		meal.setProteinGram(converter.convertToGram(meal.getProteinCalories(), "p"));
		meal.setFatCalories(fat(calor));
		meal.setFatGram(converter.convertToGram(meal.getFatCalories(), "f"));
		return meal;
	}
	
	public int breakfastOrDinnerCalor(int allCalories) {
		return (int) (allCalories * 0.25);
	}
	
	public int noonCalor(int allCalories) {
		return (int) (allCalories * 0.3);
	}
	
	public int snackCalorint(int allCalories) {
		return (int) (allCalories * 0.2);
	}
	
	public int protein(int localCalor) {
		return (int) (localCalor * 0.35);
	}
	
	public int fat(int localCalor) {
		return (int) (localCalor * 0.25);
	}
	
	public int carbohydrate(int localCalor) {
		return (int) (localCalor * 0.4);
	}
}
