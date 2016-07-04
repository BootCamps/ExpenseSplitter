package com.ford.expensesplitter.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import com.ford.expensesplitter.modal.User;

public class UserServiceTest {

	private UserService userService = new UserService();
	
	private User user;
	
	@Before
	public void setUp(){
		this.user = new User();
		user.setDisplayName("Ilangovan");
		user.setUserName("ilango");
		user.setPassword("Ilango123");
	}
	
	@Test
	public void shouldReturnNullIfUserEnteredEmptyUserName() throws Exception {
		this.user.setUserName("");
		User user = this.userService.register(this.user);
		assertNull(user);
	}
	
	@Test
	public void shouldReturnNullIfUserEnteredEmptyPassword() throws Exception {
		this.user.setPassword("");
		User user = this.userService.register(this.user);
		assertNull(user);
	}
	
	@Test
	public void shouldReturnUserWithValidUserEntry() throws Exception {
		User user = this.userService.register(this.user);
		assertNotNull(user);
	}
	
}
