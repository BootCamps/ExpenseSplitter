package com.ford.expensesplitter.repository;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.TypedQuery;

import com.ford.expensesplitter.modal.User;

public class UserRepository {
	
	@Inject
	BaseRepository base;

	public User register(User user) throws Exception {
		base.persist(user);
		return user;
	}

	public List<User> findUserByUserName(String userName) {
		TypedQuery<User> query = base.createNamedQuery("User.findByUserName", User.class);
		query.setParameter("userName", userName);
		return query.getResultList(); 
	}
	

}
