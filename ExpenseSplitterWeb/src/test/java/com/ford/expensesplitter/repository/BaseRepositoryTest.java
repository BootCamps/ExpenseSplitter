package com.ford.expensesplitter.repository;

import static org.junit.Assert.assertNotNull;

import javax.persistence.EntityManager;

import org.junit.Test;

public class BaseRepositoryTest {

	@Test
	public void checkConnection() throws Exception {
		BaseRepository baseRepository = new BaseRepository();
		EntityManager em = baseRepository.createEntityManager();
		assertNotNull(em);
	}
}
