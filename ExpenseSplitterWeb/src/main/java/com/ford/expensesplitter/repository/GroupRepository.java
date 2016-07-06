package com.ford.expensesplitter.repository;

import com.ford.expensesplitter.modal.Group;

public class GroupRepository{

	private static final long serialVersionUID = 1L;
	
	BaseRepository baseRepository = new BaseRepository();
	
	public Group insertGroup(Group group) throws Exception {
		baseRepository.persist(group);
		return group;
	}
	
}
