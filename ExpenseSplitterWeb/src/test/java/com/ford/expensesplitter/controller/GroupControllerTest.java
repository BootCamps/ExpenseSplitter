package com.ford.expensesplitter.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.ford.expensesplitter.modal.Group;
import com.ford.expensesplitter.service.GroupService;

@RunWith(MockitoJUnitRunner.class)
public class GroupControllerTest {

	@InjectMocks
	GroupController controller;
	
	@Test(expected = Exception.class)
	public void shouldValidateGroupNameNotEmpty() throws Exception {		
		controller.createGroup(null);
	}
	
	@Test
	public void shouldInsertValidGroup() throws Exception {
		Group expectedGroup = new Group();
		expectedGroup.setGroupName("Test");
		Group actualGroup = controller.createGroup("Test");
		assertEquals(expectedGroup.getGroupName(),actualGroup.getGroupName());
		assertTrue(actualGroup.getId()>0);
	}

}
