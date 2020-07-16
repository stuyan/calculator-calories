package com.airin.calculatorCalories.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.airin.calculatorCalories.service.IUserService;
import com.airin.calculatorCalories.user.User;

@RestController
public class UserController {
	
	@Autowired
	private IUserService iUserServise;
	
	@PostMapping("/createUser")
	public String createUser(@RequestBody User user) {
		iUserServise.create(user);
		return "Пользователь " + user.getName() + " успешно создан."; 
	}
	
	@DeleteMapping("/deleteUser")
	public String deleteUser(@RequestParam Long id) {
		iUserServise.delete(id);
		return "Пользователь успешно удалён.";
	}
	
	@GetMapping("/getUser")
	public User getUser(@RequestParam Long id) {		
		return iUserServise.get(id);
	}
}
