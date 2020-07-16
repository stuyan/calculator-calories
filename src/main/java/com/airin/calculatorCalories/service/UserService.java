package com.airin.calculatorCalories.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airin.calculatorCalories.converter.UserConverter;
import com.airin.calculatorCalories.entity.UserEntity;
import com.airin.calculatorCalories.repository.UserRepository;
import com.airin.calculatorCalories.user.User;

@Service
public class UserService implements IUserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserConverter userConverter;

	@Override
	public void create(User user) {
		UserEntity userEntity = userConverter.userToUserEntity(user);
		userRepository.save(userEntity);
	}

	@Override
	public void delete(Long id) {
		userRepository.deleteById(id);
	}

	@Override
	public User get(Long id) {
		UserEntity userEntity = userRepository.findById(id).get();
		return userConverter.userEntityToUser(userEntity);
	}
}
