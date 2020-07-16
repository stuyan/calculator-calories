package com.airin.calculatorCalories.service;

import com.airin.calculatorCalories.pfc.Pfc;

public interface IPfcService {
	
	Pfc norm(Integer calories, Long id);
	
	Pfc hypo(Integer calories, Long id);
	
	void savePE(Integer calories, Long id);

}
