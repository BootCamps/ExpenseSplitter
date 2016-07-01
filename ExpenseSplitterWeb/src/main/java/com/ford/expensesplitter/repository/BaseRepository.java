package com.ford.expensesplitter.repository;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BaseRepository implements Serializable{

	private static final long serialVersionUID = 1L;

	public EntityManager createEntityManager() throws Exception{
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("EXPENSE_SPLITTER");
		return factory.createEntityManager();
	}

}
