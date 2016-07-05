package com.ford.expensesplitter.repository;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BaseRepositoryTest {

	@InjectMocks
	private BaseRepository baseRepository; 
	
	@Mock
	EntityManager entityManager;
	
	@Mock
	EntityTransaction transaction;
	
	@Test
	public void persistUsesTransaction() throws Exception { 
		when(entityManager.getTransaction()).thenReturn(transaction);
		baseRepository.persist(new Object());
		verify(transaction).begin();
		verify(transaction).commit();
	}
	
}
