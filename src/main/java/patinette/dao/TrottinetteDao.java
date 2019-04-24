package patinette.dao;

import java.util.List;

import javax.ejb.Local;

import patinette.entity.Trottinette;

@Local
public interface TrottinetteDao {

	List<Trottinette> findAllAvailableTrottinettes();

}
