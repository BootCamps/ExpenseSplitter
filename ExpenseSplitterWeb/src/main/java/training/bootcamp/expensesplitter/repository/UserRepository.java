package training.bootcamp.expensesplitter.repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.TypedQuery;

import training.bootcamp.expensesplitter.modal.User;

@ApplicationScoped
public class UserRepository {
	
	BaseRepository base = new BaseRepository();

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
