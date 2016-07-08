package com.ford.expensesplitter.controller;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ford.expensesplitter.modal.User;
import com.ford.expensesplitter.service.UserService;

@Path("/user")
@ApplicationScoped
public class UserRegisterController {
	
	private UserService userService = new UserService();
	
	@POST
	@Path("/register")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public User registerUser(User user) throws Exception {
		return this.userService.register(user);
	}

}
