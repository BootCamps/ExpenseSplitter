package com.ford.expensesplitter.controller;

import java.sql.Timestamp;
import java.util.Date;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ford.expensesplitter.modal.Group;
import com.ford.expensesplitter.service.GroupService;

@Path("/group")
@ApplicationScoped
public class GroupController {

	@POST
	@Path(value = "/createGroup")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Group createGroup(String groupName) throws Exception {
		GroupService groupService = new GroupService();
		Date date = new Date();
		Group group = new Group();
		if (groupName == null || groupName.equals(""))
			throw new Exception();
		else {
			group.setGroupName(groupName);
			group.setCreatedBy("Test user");
			group.setCreatedDate(new Timestamp(date.getTime()));
			group = groupService.insertGroup(group);
		}

		return group;
	}

}
