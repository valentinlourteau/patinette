package patinette.service;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import patinette.dao.UserDao;
import patinette.entity.User;

@LocalBean
@Stateless
public class UserServiceImpl implements UserService {
	
	@Inject
	private UserDao userDao;

	@Override
	public boolean authenticateUser(String login, String password) {
		if (login == null) return false;
		if (password == null) return false;
		
		return userDao.findBy(login.trim(), password.trim()) != null;
	}

	@Override
	public boolean createUser(String login, String password) {
		if (login == null) return false;
		if (password == null) return false;
		if (userDao.findBy(login) != null) return false;
		
		User user = new User();
		user.setLogin(login);
		user.setPassword(password);
		userDao.persist(user);
		return true;
	}

	@Override
	public void updateUser(User user) {
		userDao.merge(user);
	}

}
