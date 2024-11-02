/**
 * 
 */
package com.dangabito.projectjpa.dao.impl;

import java.util.List;

import com.dangabito.projectjpa.dao.DisqueraDAO;
import com.dangabito.projectjpa.entity.Disquera;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

/**
 * @author super Clase que implementa las transacciones para la tabla disquera.
 */
public class DisqueraDaoImpl implements DisqueraDAO {

	private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
			.createEntityManagerFactory("persistenceDangabito");

	/**
	 * 
	 */
	public DisqueraDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void guardar(Disquera disquera) {
		EntityManager em=ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction eTransaction= em.getTransaction();
		eTransaction.begin();
		try {
			em.persist(disquera);
			eTransaction.commit();
		} catch (Exception e) {
			if(eTransaction!=null) {
				eTransaction.rollback();
			}
			e.printStackTrace();
		}finally {
			em.close();
		}
	}

	@Override
	public void actualizar(Disquera disquera) {
		EntityManager em=ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		try {
			em.merge(disquera);
			et.commit();
		} catch (Exception e) {
			if(et!=null) {
			   et.rollback();
			}
			e.printStackTrace();
		}finally {
			em.close();
		}
	}

	@Override
	public void eliminar(Long id) {
		EntityManager em=ENTITY_MANAGER_FACTORY.createEntityManager();
		Disquera disquera = em.find(Disquera.class, id);
		System.out.println("Consultando objeto a eliminar :"+ disquera.getIdDisquera());
		EntityTransaction et=em.getTransaction();
		et.begin();
		try {
			em.remove(disquera);
			et.commit();
		} catch (Exception e) {
			if(et!=null) {
				et.rollback();
			}
			e.printStackTrace();
		}finally {
			em.close();
		}
	}

	@Override
	public List<Disquera> consultar() {
	         EntityManager em= ENTITY_MANAGER_FACTORY.createEntityManager();
	         TypedQuery<Disquera> queryDisqueraQuery= (TypedQuery<Disquera>) em.createQuery("FROM Disquera ORDER BY descripcion");
	         return queryDisqueraQuery.getResultList();
	}

	@Override
	public Disquera consultarById(Long id) {
		EntityManager em=ENTITY_MANAGER_FACTORY.createEntityManager();
		Disquera disquera= em.find(Disquera.class, id);
		if(disquera==null) {
			throw new EntityNotFoundException("La disquera con id "+ id + "no se encontro");
		}
		return disquera;
	}

}
