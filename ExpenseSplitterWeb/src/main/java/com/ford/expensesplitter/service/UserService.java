package com.ford.expensesplitter.service;

import javax.inject.Inject;

import com.ford.expensesplitter.modal.User;
import com.ford.expensesplitter.repository.UserRepository;

public class UserService {
	
	@Inject
	private UserRepository userRepository;

	public User register(User user) throws Exception {
		if(!user.getUserName().isEmpty() && !user.getPassword().isEmpty()){
			return this.userRepository.register(user);
		}
		return null;
	}
	

}
