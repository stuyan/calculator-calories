package com.airin.calculatorCalories.service;

import com.airin.calculatorCalories.user.User;

public interface IUserService {

	void create(User user);
	
	void delete(Long id);
	
	User get(Long id);
}
