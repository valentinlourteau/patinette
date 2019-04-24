package patinette.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import com.querydsl.jpa.impl.JPAQuery;

/**
 * Implémentation ESS pour le generic dao jpa
 * @author valentin
 *
 * @param <T>
 */
@LocalBean
@Stateless
public class GenericJpaDaoImpl<T extends Serializable> implements GenericJpaDao<T> {
	
	@PersistenceContext(unitName = "PATINETTE", type = PersistenceContextType.TRANSACTION)
    private EntityManager entityManager;

	@Override
	public JPAQuery<T> queryFactory() {
		return new JPAQuery<T>(entityManager);
	}

	@Override
	public void persist(T entity) {
		entityManager.persist(entity);
	}

	@Override
	public void merge(T entity) {
		entityManager.merge(entity);
	}

	@Override
	public void remove(T entity) {
		entityManager.remove(entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T findById(Long id) {
		Class<T> genericType = ((Class<T>) ((ParameterizedType) getClass()
		        .getGenericSuperclass()).getActualTypeArguments()[0]);
		return entityManager.find(genericType, id);
	}

	@Override
	public List<T> findAll() {
		return null;
	}

	@Override
	public void flush() {
		entityManager.flush();
	}

}
