package training.bootcamp.expensesplitter.repository;

import javax.inject.Inject;

import training.bootcamp.expensesplitter.modal.Group;

public class GroupRepository {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private BaseRepository base;
	
	public Group insertGroup(Group group) throws Exception {
		base.persist(group);
		return group;
	}
	
}
