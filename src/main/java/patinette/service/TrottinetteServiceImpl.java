package patinette.service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
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
	
	public static final double minutePrice = 0.15d;
	public static final double locationPrice = 1d;
	
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
		location.setDateReservation(LocalDateTime.now());
		location.setBRunning(true);
		location.setDateRendu(null);
		locationDao.persist(location);
		Trottinette trottinette = trottinetteDao.findById(location.getTrottinette().getId());
		trottinette.setBAvailable(false);
		trottinetteDao.merge(trottinette);
		return location;
	}

	@Override
	public Location endLocation(Location location) {
		location = locationDao.findById(location.getId());
		location.setDateRendu(LocalDateTime.now());
		location.setBRunning(false);
		location.setPrice(calculatePriceToPay(location));
		locationDao.merge(location);

		Trottinette trottinette = trottinetteDao.findById(location.getTrottinette().getId());
		trottinette.setBAvailable(true);
		trottinetteDao.merge(trottinette);
		
		return location;
	}

	private double calculatePriceToPay(Location location) {
		return calculatePriceToPay(location.getDateReservation(), location.getDateRendu());
	}

	private double calculatePriceToPay(LocalDateTime dateReservation, LocalDateTime dateRendu) {
		long minutes = ChronoUnit.MINUTES.between(dateReservation, dateRendu);
		double priceForMinutes = (double)minutes * minutePrice;
		Double overallPrice = priceForMinutes + locationPrice;
		return overallPrice;
	}

}
