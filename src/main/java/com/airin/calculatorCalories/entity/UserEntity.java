package com.airin.calculatorCalories.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity(name = "users")
@Getter
@Setter
public class UserEntity {
	
	@Id
	@GeneratedValue
	private long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "sex")
	private String sex;
	
	@Column(name = "age")
	private int age;
	
	@Column(name = "height")
	private double height;
	
	@Column(name = "weight")
	private int weight;
	
	@Column(name = "activity")
	private int activity;
	
	@OneToMany
	@JoinColumn(name = "user_id")
	private List<PfcEntity> pfc;

}
