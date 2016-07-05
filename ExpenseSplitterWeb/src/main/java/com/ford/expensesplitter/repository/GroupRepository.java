package com.ford.expensesplitter.repository;

import javax.inject.Inject;

import com.ford.expensesplitter.modal.Group;

public class GroupRepository {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private BaseRepository base;
	
	public Group insertGroup(Group group) throws Exception {
		base.persist(group);
		return group;
	}
	
}
