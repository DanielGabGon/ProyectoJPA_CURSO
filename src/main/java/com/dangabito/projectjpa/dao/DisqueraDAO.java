package com.dangabito.projectjpa.dao;

import java.util.List;

import com.dangabito.projectjpa.entity.Disquera;
import com.dangabito.projectjpa.entity.Disquera;

/**
 * @author super
 * Interface que genera el DAO para las transacciones del CRUD a la tabla de disquera.
 */
public interface DisqueraDAO {
	
	
	void guardar(Disquera disquera);
	
	void actualizar(Disquera disquera);
	
	void eliminar(Long id);
	
	List<Disquera> consultar();
	
	Disquera consultarById(Long id);

	/**
	 * Metodo que permite consultar con JPQL a paratir de una decripcion.
	 * @param descripcion {@link String} descripcion de la disquera.
	 * @return {@link Disquera} la disquera consultada.
	 */
	Disquera consultarByDescripcionJPQL(String descripcion);
	
	/**
	 * Metodo que permite consultar con SQL Nativo a partir de una decripcion.
	 * @param descripcion {@link String} descripcion de la disquera.
	 * @return {@link Disquera} la disquera consultada.
	 */
	Disquera consultarByDescripcionNative(String descripcion);
}
