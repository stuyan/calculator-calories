package com.airin.calculatorCalories.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.airin.calculatorCalories.converter.UserConverter;
import com.airin.calculatorCalories.entity.UserEntity;
import com.airin.calculatorCalories.repository.UserRepository;
import com.airin.calculatorCalories.user.User;

@RestController
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserConverter userConverter;
	
	@PostMapping("/createUser")
	public String createUser(@RequestBody User user) {
		UserEntity userEntity = userConverter.userToUserEntity(user);
		userRepository.save(userEntity);
		return "Пользователь " + user.getName() + " успешно создан."; 
	}
	
	@DeleteMapping("/deleteUser")
	public String deleteUser(@RequestParam Long id) {
		userRepository.deleteById(id);
		return "Пользователь успешно удалён.";
	}
	
	@GetMapping("/getUser")
	public User getUser(@RequestParam Long id) {
		UserEntity userEntity = userRepository.findById(id).get();
		return userConverter.userEntityToUser(userEntity);
	}
}
