package patinette.dao;

import javax.ejb.Local;

import patinette.entity.Location;
import patinette.entity.User;

@Local
public interface LocationDao extends GenericJpaDao<Location> {

	Location findRunningLocationByUser(User user);

}
