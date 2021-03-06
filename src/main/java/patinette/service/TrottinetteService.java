package patinette.service;

import java.util.List;

import javax.ejb.Local;

import patinette.entity.Location;
import patinette.entity.Trottinette;
import patinette.entity.User;

@Local
public interface TrottinetteService {

	List<Trottinette> findAllAvailableTrottinettes();

	Location startLocation(Location location);

	/**
	 * 
	 * @param location
	 * @return le prix total
	 */
	Location endLocation(Location location);

	Location getRunningLocationByUser(User user);

}
