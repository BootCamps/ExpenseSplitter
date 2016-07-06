package com.ford.expensesplitter.repository;

import java.util.List;

import javax.persistence.TypedQuery;

import com.ford.expensesplitter.modal.User;

public class UserRepository extends BaseRepository {

	private static final long serialVersionUID = 1L;

	public User register(User user) throws Exception {
		persist(user);
		return user;
	}

	public List<User> findUserByUserName(String userName) {
		TypedQuery<User> query = getEntityManager().createNamedQuery("User.findByUserName", User.class);
		query.setParameter("userName", userName);
		return query.getResultList();
	}
	

}
