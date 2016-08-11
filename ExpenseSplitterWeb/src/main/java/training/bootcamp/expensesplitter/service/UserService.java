package training.bootcamp.expensesplitter.service;

import javax.enterprise.context.ApplicationScoped;

import training.bootcamp.expensesplitter.modal.User;
import training.bootcamp.expensesplitter.repository.UserRepository;

@ApplicationScoped
public class UserService {
	
	private UserRepository userRepository = new UserRepository();
	
	public User register(User user) throws Exception {
		if(!user.getUserName().isEmpty() && !user.getPassword().isEmpty()){
			if(userNameAvailable(user.getUserName())){
				return this.userRepository.register(user);
			}else{ 
				return user;
			}
		}
		return null;
	}
 
	public boolean userNameAvailable(String userName) {
		return this.userRepository.findUserByUserName(userName).isEmpty();
	}
	
}
