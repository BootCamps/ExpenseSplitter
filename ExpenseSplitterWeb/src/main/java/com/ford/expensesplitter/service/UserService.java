package com.ford.expensesplitter.service;

import javax.inject.Inject;

import com.ford.expensesplitter.modal.User;
import com.ford.expensesplitter.repository.UserRepository;

public class UserService {
	
	@Inject
	private UserRepository userRepository;
	
	public UserService() {
		this.userRepository = new UserRepository();
	}

	public User register(User user) throws Exception {
		if(!user.getUserName().isEmpty() && !user.getPassword().isEmpty()){
			if(checkIfUserExists(user.getUserName())){
				return this.userRepository.register(user);
			}
		}
		return null;
	}
 
	public boolean checkIfUserExists(String userName) {
		return this.userRepository.findUserByUserName(userName).isEmpty();
	}
	
}
