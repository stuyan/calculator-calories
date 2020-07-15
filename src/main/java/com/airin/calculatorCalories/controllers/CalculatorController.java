package com.airin.calculatorCalories.controllers;

import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.airin.calculatorCalories.calculators.CalculatorCalor;
import com.airin.calculatorCalories.calculators.CalculatorPFC;
import com.airin.calculatorCalories.converter.PfcConverter;
import com.airin.calculatorCalories.converter.UserConverter;
import com.airin.calculatorCalories.entity.PfcEntity;
import com.airin.calculatorCalories.entity.UserEntity;
import com.airin.calculatorCalories.pfc.Pfc;
import com.airin.calculatorCalories.repository.PfcRepository;
import com.airin.calculatorCalories.repository.UserRepository;
import com.airin.calculatorCalories.user.User;

@RestController
@RequestMapping("/calculate")
public class CalculatorController {
	@Autowired
	private CalculatorCalor calculator;
	
	@Autowired
	private CalculatorPFC calculatorPFC;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserConverter userConverter;
	
	@Autowired
	private PfcConverter pfcConverter;
	
	@Autowired
	private PfcRepository pfcRepository;
	
	@Autowired
	private EntityManager entityManager;
	
	@GetMapping("/normCalories")
	public String getNormCalor(@RequestParam Long id) {
		int result = calculator.normCalor(userById(id));
		if (result != 0) {
			return "Для поддержания веса Вам необходимо употреблять " + result + " ккал в сутки"; 
		} 
		return "Проверьте правильность введенных данных";
	}
	
	@GetMapping("/hyppoCalories")
	public String getHypoCalor(@RequestParam Long id) {
		int result = calculator.hypoCalor(userById(id));
		if (result != 0) {
			return "Для снижения веса Вам необходимо употреблять " + result + " ккал в сутки"; 
		} 
		return "Проверьте правильность введенных данных";
	}
	
	@GetMapping("/normCalories/plc")
	public Pfc getNormPLC(@RequestParam Long id) {
		var calories = calculator.normCalor(userById(id));
		savePfcEntity(calories, id);
		return calculatorPFC.calculate(calories);
	}
	
	@GetMapping("/hyppoCalories/plc")
	public Pfc getHypoPLC(@RequestParam Long id) {
		var hypoCalories = calculator.hypoCalor(userById(id));
		savePfcEntity(hypoCalories, id);
		return calculatorPFC.calculate(hypoCalories);
	}
	
	private void savePfcEntity(Integer calories, Long id) {
		Pfc pfc = calculatorPFC.calculate(calories);
		PfcEntity pfcEntity = pfcConverter.pfcToPfcEntity(pfc);
		UserEntity userEntity = entityManager.getReference(UserEntity.class, id);
		pfcEntity.setUser(userEntity);
		pfcRepository.save(pfcEntity);
	}
	
	private User userById(Long id) {
		return userConverter.userEntityToUser(userEntityById(id));
	}
	
	private UserEntity userEntityById(Long id) {
		return userRepository.findById(id).get();
	}
}
