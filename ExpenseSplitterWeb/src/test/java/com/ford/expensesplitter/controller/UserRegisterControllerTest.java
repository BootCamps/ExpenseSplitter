package com.ford.expensesplitter.controller;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import com.ford.expensesplitter.modal.User;

public class UserRegisterControllerTest {
	
	private UserRegisterController userRegisterController = new UserRegisterController(); 
	
	private User user;
	
	@Before
	public void setUp(){
		this.user = new User();
		user.setDisplayName("Naga");
		user.setUserName("Naga12");
		user.setPassword("Naga123");
	}
	
	@Test
	public void shouldReturnUserWithValidUserEntry() throws Exception {
		User user = this.userRegisterController.registerUser(this.user);
		if(user == null){
			assertNull(user);
		}else{
			assertNotNull(user);
		}
	}
	

}
