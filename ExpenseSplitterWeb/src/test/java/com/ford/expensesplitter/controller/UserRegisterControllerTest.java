package com.ford.expensesplitter.controller;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.ford.expensesplitter.modal.User;
import com.ford.expensesplitter.service.UserService;


@RunWith(MockitoJUnitRunner.class)
public class UserRegisterControllerTest {
	
	@InjectMocks
	private UserRegisterController userRegisterController; 
 	
	@Mock
	private UserService userService;
	
	private User userToRegister;
	private User expectedUser;
	
	@Before
	public void setUp(){
		this.expectedUser  = new User();
		this.userToRegister = new User();
	}
	
	@Test
	public void shouldReturnUserWithValidUserEntry() throws Exception {
		when(this.userService.register(userToRegister)).thenReturn(expectedUser);
		User registerdUser = this.userRegisterController.registerUser(this.userToRegister);
		assertSame(expectedUser, registerdUser);
	}
	

}
