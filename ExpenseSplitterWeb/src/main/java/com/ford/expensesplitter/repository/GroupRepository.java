package com.ford.expensesplitter.repository;

import com.ford.expensesplitter.modal.Group;

public class GroupRepository extends BaseRepository{

	private static final long serialVersionUID = 1L;
	
	public Group insertGroup(Group group) throws Exception {
		em.getTransaction().begin();
		em.persist(group);
		em.getTransaction().commit();
		return group;
	}
	
}
