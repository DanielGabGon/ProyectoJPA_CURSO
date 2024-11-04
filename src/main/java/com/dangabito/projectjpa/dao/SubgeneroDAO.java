package com.dangabito.projectjpa.dao;

import java.util.List;

import com.dangabito.projectjpa.entity.SubGenero;

/**
 * @Dangabito
 * Interface DAO que realiza el CRUD con JPA para la tabla de subgenero.
 */
public interface SubgeneroDAO {
	
	/**
	 * Metodo que permite guardar un subgenero
	 * @param subGenero {@link SubGenero} objeto a guardar. 
	 */
	void guardar(SubGenero subGenero );
	
	/**
	 * Metodo que permite actualizar un subgenero.
	 * @param subGenero {@link SubGenero} objeto a actualizar.
	 */
	void actualizar (SubGenero subGenero);
	
	/**
	 * Metodo que permite eliminar un subgenero por su idenificador.
	 * @param id {@link Long} identificador del subgenero a eliminar.
	 */
	void eliminar(Long id);
	
	/**
	 * Metodo que permitre consultar la lista de subgeneros.
	 * @return {@l List} lista de subgeneros consultados.
	 */ 
	List<SubGenero> consultarGeneros();
	
	/**
	 * Metodo que permite cosnultar sun SubGenero a partir de su identificador.
	 * @param id {@link Long} identificador del subgenero a consultar.
	 * @return {@link subgenero} un objeto subgenero consultado.
	 */
	SubGenero consultarById(Long id);

}
