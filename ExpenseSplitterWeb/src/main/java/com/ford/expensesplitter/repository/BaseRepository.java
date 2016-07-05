package com.ford.expensesplitter.repository;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BaseRepository implements Serializable{

	private static final String DB_CONFIG = "EXPENSE_SPLITTER";
	private static final long serialVersionUID = 1L;
	
	protected static EntityManager em;
	
	public BaseRepository() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory(DB_CONFIG);
		this.em = factory.createEntityManager(); 
	}	
	
	
}
