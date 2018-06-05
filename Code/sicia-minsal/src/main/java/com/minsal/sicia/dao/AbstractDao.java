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
	
	private EntityManager em = SiciaResolver.getInstance().getEntityManagerFactory().createEntityManager();
	
	public AbstractDao(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	protected EntityManager getEntityManager() {
		return this.em;
	}
	
	public void create(T entity) {
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
	}

	public void update(T entity) {
		getEntityManager().merge(entity);
	}

	public void remove(Integer entityId) {
		T entity = find(entityId);

		if (entity != null)
			remove(entity);
	}

	public void remove(T entity) {
		getEntityManager().remove(getEntityManager().merge(entity));
	}

	public T find(Integer id) {
		return getEntityManager().find(entityClass, id);
	}

	public List<T> findAll() {
		CriteriaQuery<T> cq = getEntityManager().getCriteriaBuilder()
		        .createQuery(entityClass);
		cq.select(cq.from(entityClass));

		return getEntityManager().createQuery(cq).getResultList();
	}


}
