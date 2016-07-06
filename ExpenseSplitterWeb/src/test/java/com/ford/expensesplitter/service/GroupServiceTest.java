package com.ford.expensesplitter.service;

import static org.junit.Assert.assertEquals;

import java.sql.Timestamp;

import org.junit.Test;
import org.mockito.InjectMocks;

import com.ford.expensesplitter.modal.Group;
import com.ford.expensesplitter.repository.GroupRepository;

public class GroupServiceTest {
	GroupRepository groupRepository = new GroupRepository();

	@InjectMocks
	GroupService groupService = new GroupService();

	@Test
	public void shouldCreateGroup() throws Exception {
		Group group = new Group();
		group.setGroupName("Test");
		group.setCreatedBy("testuser");
		group.setCreatedDate(new Timestamp(1111));
		Group result = groupService.insertGroup(group);
		assertEquals(group.getGroupName(), result.getGroupName());
	}

}
