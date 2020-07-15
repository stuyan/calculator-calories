package com.airin.calculatorCalories.converter;

import org.springframework.stereotype.Component;
import com.airin.calculatorCalories.entity.UserEntity;
import com.airin.calculatorCalories.user.User;

@Component
public class UserConverter {
	
	public UserEntity userToUserEntity(User user) {
		UserEntity userEntity = new UserEntity();
		userEntity.setName(user.getName());
		userEntity.setSex(user.getSex());
		userEntity.setAge(user.getAge());
		userEntity.setHeight(user.getHeight());
		userEntity.setWeight(user.getWeight());
		userEntity.setActivity(user.getActivity());
		return userEntity;
	}
	
	public User userEntityToUser(UserEntity userEntity) {
		User user = new User();
		user.setName(userEntity.getName());
		user.setAge(userEntity.getAge());
		user.setSex(userEntity.getSex());
		user.setHeight(userEntity.getHeight());
		user.setWeight(userEntity.getWeight());
		user.setActivity(userEntity.getActivity());
		return user;
	}

}
