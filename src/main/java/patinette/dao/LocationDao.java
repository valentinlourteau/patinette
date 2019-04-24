package patinette.dao;

import javax.ejb.Local;

import patinette.entity.Location;

@Local
public interface LocationDao extends GenericJpaDao<Location> {

}
