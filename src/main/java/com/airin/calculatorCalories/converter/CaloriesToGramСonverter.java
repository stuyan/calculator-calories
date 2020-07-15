package com.airin.calculatorCalories.converter;

import org.springframework.stereotype.Service;

@Service
public class CaloriesToGramСonverter {
	
	public int convertToGram(int calories, String type) {
		if (type.equals("f")) {
			return calories / 9;
		}
		return calories / 4;
	}
}
