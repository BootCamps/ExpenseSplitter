package com.ford.expensesplitter.controller;

import javax.inject.Inject;
import javax.ws.rs.Path;

import com.ford.expensesplitter.modal.User;
import com.ford.expensesplitter.service.UserService;

@Path("/user")
public class UserRegisterController {
	
	@Inject
	private UserService userService;
	
	public UserRegisterController() {
		this.userService = new UserService();
	}
	
	@Path("/register")
	public User registerUser(User user) throws Exception {
		return this.userService.register(user);
	}

}
