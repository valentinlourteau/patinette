package patinette.dao;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import patinette.entity.Location;
import patinette.entity.User;

@LocalBean
@Stateless
public class LocationDaoImpl extends GenericJpaDaoImpl<Location> implements LocationDao {

	@Override
	public Location findRunningLocationByUser(User user) {
		return queryFactory().select(LOCATION)
				.from(LOCATION)
				.where(LOCATION.user.id.eq(user.getId()),
						LOCATION.bRunning.eq(Boolean.TRUE)).fetchOne();
	}

}
