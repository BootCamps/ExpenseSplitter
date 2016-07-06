package com.ford.expensesplitter.repository;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class BaseRepositoryTest {

	@Test
	public void checkConnection() throws Exception {
		BaseRepository baseRepository = new BaseRepository();
		assertNotNull(baseRepository.getEntityManager());
	}
}
