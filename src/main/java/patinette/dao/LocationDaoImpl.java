package patinette.dao;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import patinette.entity.Location;

@LocalBean
@Stateless
public class LocationDaoImpl extends GenericJpaDaoImpl<Location> implements LocationDao {

}
