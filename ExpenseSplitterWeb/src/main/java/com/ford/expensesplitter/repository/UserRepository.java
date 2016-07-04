package com.ford.expensesplitter.repository;

import com.ford.expensesplitter.modal.User;

public class UserRepository extends BaseRepository {

	private static final long serialVersionUID = 1L;

	public User register(User user) throws Exception {
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
		return user;
	}

}
