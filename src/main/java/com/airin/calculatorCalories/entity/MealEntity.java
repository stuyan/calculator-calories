package com.airin.calculatorCalories.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity(name = "meal")
@Getter
@Setter
public class MealEntity {
	
	@Id
	@GeneratedValue
	private long id;
	
	@Column(name = "calories")
	private int calories;
	
	@Column(name = "proteinCalories")
	private int proteinCalories;
	
	@Column(name = "proteinGram")
	private int proteinGram;
	
	@Column(name = "carbohydrateCalories")
	private int carbohydrateCalories;
	
	@Column(name = "carbohydrateGram")
	private int carbohydrateGram;
	
	@Column(name = "fatCalories")
	private int fatCalories;
	
	@Column(name = "fatGram")
	private int fatGram;
}
