package patinette.dao;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Local;

import com.querydsl.jpa.impl.JPAQuery;

/**
 * Contrat du generic dao via jpa.
 * @author valentin
 *
 * @param <T> une entité
 */
@Local
public interface GenericJpaDao<T extends Serializable> extends QueryDslEntities {
	
	public JPAQuery<T> queryFactory();
	
	public void persist(T entity);
	
	public void merge(T entity);
	
	public void remove(T entity);
	
	public T findById(Long id);
	
	public List<T> findAll();
	
	public void flush();

}
