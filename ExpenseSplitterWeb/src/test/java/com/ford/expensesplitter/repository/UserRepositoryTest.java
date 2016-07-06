package com.ford.expensesplitter.repository;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.ford.expensesplitter.modal.User;

public class UserRepositoryTest {

	private UserRepository userRepository =  new UserRepository();
	
	private User user;
	
	@Before
	public void setUp(){
		this.user = new User();
		user.setDisplayName("Kamalanathan R");
		user.setUserName("Kamal");
		user.setPassword("Kamal123");
	}
	
//	@Test
//	public void shouldReturnUserWithValidEntry() throws Exception {
//		User user = this.userRepository.register(this.user);
//		assertNotNull(user);
//	}
	

}
