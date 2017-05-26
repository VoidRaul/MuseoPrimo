package repository;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import javax.persistence.TypedQuery;

import model.Galleria;

public class CrudRepositoryJPA<T> implements CrudRepository<T> {

	private EntityManager em;
	private Class<T> entityClass;

	public CrudRepositoryJPA(EntityManager em, Class<T> entityClass) {
		this.em = em;
		this.entityClass = entityClass;
	}

	private String getClassName() {
//		String fullClassName = this.entityClass.getCanonicalName();
		String className = this.entityClass.getSimpleName();
		return className;
	}

	@Override
	public T save(T entity) {
		Method getId = null;
		T persistentEntity = null;
		EntityTransaction tx=em.getTransaction();
		try {
			getId = this.entityClass.getMethod("getId");
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}

		try {
			if(getId.invoke(entity) == null) {
				tx.begin();
				em.persist(entity);
				persistentEntity = entity; 
				tx.commit();
			}
			else{
				tx.begin();
				persistentEntity = em.merge(entity);
				tx.commit();
				}
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return persistentEntity;
	}

	@Override
	public T findOne(Long id) {
		return em.find(this.entityClass, id);
	}

	@Override
	public List<T> findAll() {
		List<T> listR;
		TypedQuery<T> query = em.createQuery("SELECT e FROM " + this.getClassName() + " e", this.entityClass);
		listR = query.getResultList();
		return listR;
	}

	@Override
	public void delete(T entity) {
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		em.remove(entity);
		tx.commit();
	}

	@Override
	public void deleteAll() {
		Query query = em.createQuery("DELETE FROM " + this.getClassName());
		query.executeUpdate();
	}

	protected EntityManager getEm() {
		return this.em;
	}
	
}