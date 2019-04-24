package patinette.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import patinette.entity.Trottinette;

@LocalBean
@Stateless
public class TrottinetteDaoImpl extends GenericJpaDaoImpl<Trottinette> implements TrottinetteDao {

	@Override
	public List<Trottinette> findAllAvailableTrottinettes() {
		return queryFactory()
				.select(TROTTINETTE)
				.from(TROTTINETTE)
				.where(TROTTINETTE.bAvailable.eq(Boolean.TRUE))
				.fetch();
	}

}
