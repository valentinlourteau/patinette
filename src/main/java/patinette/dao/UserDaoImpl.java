package patinette.dao;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import patinette.entity.User;

@LocalBean
@Stateless
public class UserDaoImpl extends GenericJpaDaoImpl<User> implements UserDao {

	@Override
	public User findBy(String login, String password) {
		return queryFactory().select(USER)
		.from(USER)
		.where(USER.login.equalsIgnoreCase(login), USER.password.eq(password))
		.fetchOne();
	}

	@Override
	public User findBy(String login) {
		return queryFactory().select(USER)
		.from(USER)
		.where(USER.login.equalsIgnoreCase(login))
		.fetchOne();
	}

}
