package com.airin.calculatorCalories.calculators;

import org.junit.Test;
import com.airin.calculatorCalories.user.User;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorCalorTest {

	@Test
	public void normCalorTest() {
		CalculatorCalor calculatorCalor = new CalculatorCalor();
		User userF = new User("Aririn", "ж", 28, 180, 64, 1);
		Integer normCalorF = calculatorCalor.normCalor(userF);
		assertEquals(normCalorF, 1552);
		User userM = new User("Baton", "м", 19, 165, 56, 3);
		Integer normCalorM = calculatorCalor.normCalor(userM);
		assertEquals(normCalorM, 2254);
	}
	
	@Test
	public void hypoCalorTest() {
		CalculatorCalor calculatorCalor = new CalculatorCalor();
		User userF = new User("Aririn", "ж", 28, 180, 64, 1);
		Integer hypoCalorF = calculatorCalor.hypoCalor(userF);
		assertEquals(hypoCalorF, 1242);
		User userM = new User("Baton", "м", 19, 165, 56, 3);
		Integer hypoCalorM = calculatorCalor.hypoCalor(userM);
		assertEquals(hypoCalorM, 1803);
	}
}
