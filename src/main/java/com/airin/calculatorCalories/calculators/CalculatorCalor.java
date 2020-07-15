package com.airin.calculatorCalories.calculators;

import org.springframework.stereotype.Service;

import com.airin.calculatorCalories.user.User;

@Service
public class CalculatorCalor {
	
	public Integer normCalor(User user) {
		var calorDay = 0d;
		if (user.getSex().equals("ж")) {
			 if (user.getAge() >= 18 && user.getAge() <= 30) {
				 calorDay = ((0.06 * user.getWeight()) + 2.037) * 240;
			 } else if (user.getAge() > 30 && user.getAge() <= 60) {
				 calorDay = ((0.034 * user.getWeight()) + 3.54) * 240;
			} else if (user.getAge() > 60) {
				calorDay = ((0.04 * user.getWeight()) + 2.76) * 240;
			} 
		} else if (user.getSex().equals("м")) {
			if (user.getAge() >= 18 && user.getAge() <= 30) {
				 calorDay = ((0.06 * user.getWeight()) + 2.90) * 240;
			 } else if (user.getAge() > 30 && user.getAge() <= 60) {
				 calorDay = ((0.05 * user.getWeight()) + 3.65) * 240;
			} else if (user.getAge() > 60) {
				calorDay = ((0.05 * user.getWeight()) + 2.46) * 240;
			} 
		}
		
		if (user.getActivity() == 1) {
			calorDay *= 1.1;
		} else if (user.getActivity() == 2) {
			calorDay *= 1.3;
		} else if (user.getActivity() == 3) {
			calorDay *= 1.5;
		}
		
		return Math.round((float)calorDay);
	}
	
	public Integer hypoCalor(User user) {
        var calorHippo = normCalor(user) * 0.8;
		
		if (user.getSex().equals("ж") && calorHippo < 1200 && calorHippo != 0) {
			return 1200;
		} else if (user.getSex().equals("м") && calorHippo < 1500 && calorHippo != 0) {
			return 1500;
		} else {
			return Math.round((float)calorHippo);
		}
	}

}
