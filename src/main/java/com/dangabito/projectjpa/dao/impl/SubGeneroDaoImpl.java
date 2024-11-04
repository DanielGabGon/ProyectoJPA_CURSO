package com.dangabito.projectjpa.dao.impl;

import java.util.List;

import com.dangabito.projectjpa.dao.SubgeneroDAO;
import com.dangabito.projectjpa.entity.SubGenero;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class SubGeneroDaoImpl implements SubgeneroDAO {

	private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
			.createEntityManagerFactory("persistenceDangabito");

	public SubGeneroDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void guardar(SubGenero subGenero) {
		EntityManager eManager=ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction eTransaction=eManager.getTransaction();
		eTransaction.begin();
		try {
			eManager.persist(subGenero);
			eTransaction.commit();
		} catch (Exception e) {
			if(eTransaction!=null) {
				eTransaction.rollback();
			}
		}finally {
			eManager.close();
		}
	}

	@Override
	public void actualizar(SubGenero subGenero) {
		EntityManager eManager=ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction eTransaction=eManager.getTransaction();
		eTransaction.begin();
		try {
			eManager.merge(subGenero);
			eTransaction.commit();
		} catch (Exception e) {
			if(eTransaction!=null) {
				eTransaction.rollback();
			}
		}finally {
			eManager.close();
		}
	}

	@Override
	public void eliminar(Long id) {
		EntityManager eManager=ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction eTransaction=eManager.getTransaction();
		SubGenero subGenero= eManager.find(SubGenero.class, id);
		eTransaction.begin();
		try {
			eManager.remove(subGenero);
			eTransaction.commit();
		} catch (Exception e) {
			if(eTransaction!=null) {
				eTransaction.rollback();
			}
		}finally {
			eManager.close();
		}

	}

	@Override
	public SubGenero consultarById(Long id) {
		EntityManager entityManager=ENTITY_MANAGER_FACTORY.createEntityManager();
		return entityManager.find(SubGenero.class, id);
	}

	@Override
	public List<SubGenero> consultarGeneros() {
		TypedQuery<SubGenero> queryTypedQuery = null ;
		try {
			EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
			queryTypedQuery = (TypedQuery<SubGenero>) em
					.createQuery("FROM SubGenero ORDER BY descripcion");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return queryTypedQuery.getResultList();
	}

}
