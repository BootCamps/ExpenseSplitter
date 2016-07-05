package com.ford.expensesplitter.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.ford.expensesplitter.modal.User;
import com.ford.expensesplitter.repository.UserRepository;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

	@InjectMocks
	private UserService userService;
	
	@Mock
	private UserRepository userRepository;
	
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
		User actualUser = this.userService.register(this.user);
		assertNull(actualUser);
		verify(this.userRepository, never()).register(this.user);
		
		
	}
	
	@Test
	public void shouldReturnNullIfUserEnteredEmptyPassword() throws Exception {
		this.user.setPassword("");
		User user = this.userService.register(this.user);
		assertNull(user);
	}
	
	@Test
	public void shouldReturnUserWithValidUserEntry() throws Exception {
		User expectedUser = new User();
		when(this.userRepository.register(this.user)).thenReturn(expectedUser);
		User user = this.userService.register(this.user);
		assertSame(expectedUser, user);
	}
	
	
	@Test
	public void userNameAvailableReturnsFalseWhenUserIsReturned() throws Exception {
		String userName = "ilango13";
		when(userRepository.findUserByUserName(userName)).thenReturn(Arrays.asList(new User()));
		assertFalse(userService.userNameAvailable(userName));
	}
	
	@Test
	public void userNameAvailableReturnsTrueWhenUserNotReturned() throws Exception {
		String userName = "ilango13";
		when(userRepository.findUserByUserName(userName)).thenReturn(new ArrayList<User>());
		assertTrue(userService.userNameAvailable(userName));
	}
	
}
