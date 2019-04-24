package patinette.service;

import javax.ejb.Local;

import patinette.entity.User;

@Local
public interface UserService {

	public boolean authenticateUser(String login, String password);
	
	public boolean createUser(String login, String password);
	
	public void updateUser(User user);

	public User findUserByLogin(String login);
	
}
