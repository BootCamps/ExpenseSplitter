package com.ford.expensesplitter.service;

import com.ford.expensesplitter.modal.Group;
import com.ford.expensesplitter.repository.GroupRepository;


public class GroupService {
	
	public GroupService(){
		
	}

	GroupRepository repository = new GroupRepository();
	
	public Group insertGroup(Group group) throws Exception {
		Group newGroup = repository.insertGroup(group);
		System.out.println("ID IS :::: "+newGroup.getId());
		return newGroup;
	}

}
