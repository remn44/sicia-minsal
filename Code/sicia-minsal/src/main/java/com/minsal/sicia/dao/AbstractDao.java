package com.minsal.sicia.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;

import com.minsal.sicia.resolver.SiciaResolver;

public abstract class AbstractDao<T> {
	protected Class<T> entityClass;
	
//	private EntityManager em = SiciaResolver.getInstance().getEntityManagerFactory().createEntityManager();
	
	public AbstractDao(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	protected EntityManager getEntityManager() {
		return SiciaResolver.getInstance().getEntityManagerFactory().createEntityManager();
	}
	
	public void create(T entity) {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
		em.close();
	}

	public void update(T entity) {
		EntityManager em = getEntityManager();
		em.merge(entity);
		em.close();
	}

	public void remove(Integer entityId) {
		T entity = find(entityId);

		if (entity != null)
			remove(entity);
	}

	public void remove(T entity) {
		EntityManager em = getEntityManager();
		em.remove(getEntityManager().merge(entity));
		em.close();
	}

	public T find(Integer id) {
		EntityManager em = getEntityManager();
		T object = em.find(entityClass, id);
		em.close();
		return object;
	}

	public List<T> findAll() {
		EntityManager em = getEntityManager();
		CriteriaQuery<T> cq = em.getCriteriaBuilder()
		        .createQuery(entityClass);
		cq.select(cq.from(entityClass));
		List<T> list = em.createQuery(cq).getResultList();
		em.close();
		return list;
	}


}
