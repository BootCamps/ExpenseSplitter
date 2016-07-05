package com.ford.expensesplitter.repository;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class BaseRepository implements Serializable {

	private static final String DB_CONFIG = "EXPENSE_SPLITTER";
	private static final long serialVersionUID = 1L;

	private EntityManager em;
	
	public void persist(Object entity) {
		beginTransaction();
		getEntityManager().persist(entity);
		commitTransaction();
	}
	
	public <T> TypedQuery<T> createNamedQuery(String name, Class<T> resultClass) {
		return getEntityManager().createNamedQuery(name, resultClass);
	}

	public EntityManager getEntityManager() {
		if (em == null) {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory(DB_CONFIG);
			em = factory.createEntityManager();
		}
		return em;
	}
	
	private void beginTransaction() {
		getEntityManager().getTransaction().begin();
	}
	
	private void commitTransaction() {
		getEntityManager().getTransaction().commit();
	}

}
