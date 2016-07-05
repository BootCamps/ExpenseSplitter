package com.ford.expensesplitter.repository;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.ford.expensesplitter.modal.User;

@RunWith(MockitoJUnitRunner.class)
public class UserRepositoryTest {

	@InjectMocks
	private UserRepository userRepository;
	
	@Mock
	private BaseRepository base;

	@Mock
	private TypedQuery<User> query;

	@Test
	public void shouldReturnUserWithValidEntry() throws Exception {
		User userToPersist = new User();
		User user = this.userRepository.register(userToPersist);
		assertSame(userToPersist, user);
		verify(base).persist(userToPersist);
	}
	
	@Test
	public void shouldReturnUserListWithFindByUserName() throws Exception {
		List<User> expected = new ArrayList<User>();
		String userName = "ilango13";
		when(base.createNamedQuery("User.findByUserName", User.class)).thenReturn(query);
		when(query.getResultList()).thenReturn(expected);
		List<User> actualUsers = this.userRepository.findUserByUserName(userName);
		assertSame(expected, actualUsers);
		verify(query).setParameter("userName", userName);
	}

}
