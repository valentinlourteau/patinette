package patinette.dao;

import javax.ejb.Local;

import patinette.entity.User;

@Local
public interface UserDao extends GenericJpaDao<User> {

	public User findBy(String login);

	public User findBy(String login, String password);

}
