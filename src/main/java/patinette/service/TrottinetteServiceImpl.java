package patinette.service;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import patinette.dao.LocationDao;
import patinette.dao.TrottinetteDao;
import patinette.entity.Location;
import patinette.entity.Trottinette;

@LocalBean
@Stateless
public class TrottinetteServiceImpl implements TrottinetteService {
	
	@Inject
	private TrottinetteDao trottinetteDao;
	
	@Inject
	private LocationDao locationDao;

	@Override
	public List<Trottinette> findAllAvailableTrottinettes() {
		return trottinetteDao.findAllAvailableTrottinettes();
	}

	@Override
	public Location startLocation(Location location) {
		location.setDateReservation(new Date());
		location.setBRunning(true);
		location.setDateRendu(null);
		locationDao.persist(location);
		return location;
	}

}
