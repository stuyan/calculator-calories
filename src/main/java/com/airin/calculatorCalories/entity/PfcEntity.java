package com.airin.calculatorCalories.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Entity(name = "pfc")
@Getter
@Setter
public class PfcEntity {
	
	@Id
	@GeneratedValue
	private long id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "breakfast_ID")
	private MealEntity breakfast;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "noon_ID")
	private MealEntity noon;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "dinner_ID")
	private MealEntity dinner;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "snack_ID")
	private MealEntity snack;
	
	@ManyToOne
	@JoinColumn(name = "user_ID")
	private UserEntity user;
	
}
