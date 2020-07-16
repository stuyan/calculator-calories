package com.airin.calculatorCalories.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.airin.calculatorCalories.calculators.CalculatorCalor;
import com.airin.calculatorCalories.pfc.Pfc;
import com.airin.calculatorCalories.service.IPfcService;
import com.airin.calculatorCalories.service.IUserService;

@RestController
@RequestMapping("/calculate")
public class CalculatorController {
	
	@Autowired
	private CalculatorCalor calculator;
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private IPfcService pfcService;
	
	@GetMapping("/normCalories")
	public String getNormCalor(@RequestParam Long id) {
		int result = calculator.normCalor(userService.get(id));
		if (result != 0) {
			return "Для поддержания веса Вам необходимо употреблять " + result + " ккал в сутки"; 
		} 
		return "Проверьте правильность введенных данных";
	}
	
	@GetMapping("/hyppoCalories")
	public String getHypoCalor(@RequestParam Long id) {
		int result = calculator.hypoCalor(userService.get(id));
		if (result != 0) {
			return "Для снижения веса Вам необходимо употреблять " + result + " ккал в сутки"; 
		} 
		return "Проверьте правильность введенных данных";
	}
	
	@GetMapping("/normCalories/plc")
	public Pfc getNormPLC(@RequestParam Long id) {
		var calories = calculator.normCalor(userService.get(id));
		return pfcService.norm(calories, id);
	}
	
	@GetMapping("/hyppoCalories/plc")
	public Pfc getHypoPLC(@RequestParam Long id) {
		var hypoCalories = calculator.hypoCalor(userService.get(id));
		return pfcService.hypo(hypoCalories, id);
	}
}
