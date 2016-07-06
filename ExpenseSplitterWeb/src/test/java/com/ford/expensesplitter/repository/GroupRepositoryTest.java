package com.ford.expensesplitter.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.Timestamp;

import org.junit.Test;

import com.ford.expensesplitter.modal.Group;

public class GroupRepositoryTest {
	GroupRepository groupRepository = new GroupRepository();

	@Test
	public void shouldInsertGroup() throws Exception {
		Group group = new Group();
		group.setGroupName("Test");
		group.setCreatedBy("testuser");
		group.setCreatedDate(new Timestamp(1111));
		Group result = groupRepository.insertGroup(group);
		assertTrue(result.getId() > 0);
		assertEquals(group.getGroupName(), result.getGroupName());

	}
}
