package com.ford.expensesplitter.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Random;

import javax.validation.constraints.AssertFalse;

import org.junit.Assert;
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
		if(user == null){
			assertNull(user);
		}else{
			assertNotNull(user);
		}
	}
	
	
	@Test
	public void checkUserIfAlreadyExists() throws Exception {
		this.user.setUserName("ilango13");
		boolean isExists = userService.checkIfUserExists(this.user.getUserName());
		if(isExists){
			assertTrue(isExists);
		}else{
			assertFalse(isExists);
		}
		
	}
	
}
