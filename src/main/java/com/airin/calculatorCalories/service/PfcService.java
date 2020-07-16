package com.airin.calculatorCalories.service;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airin.calculatorCalories.calculators.CalculatorPFC;
import com.airin.calculatorCalories.converter.PfcConverter;
import com.airin.calculatorCalories.entity.PfcEntity;
import com.airin.calculatorCalories.entity.UserEntity;
import com.airin.calculatorCalories.pfc.Pfc;
import com.airin.calculatorCalories.repository.PfcRepository;

@Service
public class PfcService implements IPfcService {
	
	@Autowired
	private CalculatorPFC calculatorPFC;
	
	@Autowired
	private PfcConverter pfcConverter;
	
	@Autowired
	private PfcRepository pfcRepository;
	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public Pfc norm(Integer calories, Long id) {
		savePE(calories, id);
		return calculatorPFC.calculate(calories);
	}

	@Override
	public Pfc hypo(Integer calories, Long id) {
		savePE(calories, id);
		return calculatorPFC.calculate(calories);
	}

	@Override
	public void savePE(Integer calories, Long id) {
		Pfc pfc = calculatorPFC.calculate(calories);
		PfcEntity pfcEntity = pfcConverter.pfcToPfcEntity(pfc);
		UserEntity userEntity = entityManager.getReference(UserEntity.class, id);
		pfcEntity.setUser(userEntity);
		pfcRepository.save(pfcEntity);
	}
}
