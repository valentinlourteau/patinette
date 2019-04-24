package patinette.dao;

import patinette.entity.QTrottinette;
import patinette.entity.QUser;

public interface QueryDslEntities {
	
	public final QUser USER = QUser.user;
	public final QTrottinette TROTTINETTE = QTrottinette.trottinette;

}
