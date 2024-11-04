package com.dangabito.projectjpa.dao.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.dangabito.projectjpa.dao.SubgeneroDAO;
import com.dangabito.projectjpa.dao.impl.SubGeneroDaoImpl;
import com.dangabito.projectjpa.entity.Genero;
import com.dangabito.projectjpa.entity.SubGenero;

/**
 * @author Dangabito
 * Clase TEST para comprobar el funcionamiento de los metodos del CRUD de subgenero.
 */
class SubGeneroDaoImplTest {
	
	private SubgeneroDAO subgeneroDAO= new SubGeneroDaoImpl();

	@Test
	void testSubGeneroDaoImpl() {
		fail("Not yet implemented");
	}

	@Test
	void testGuardar() {
		SubGenero subGenero= new SubGenero();
		subGenero.setDescripcion("Hard Core");
		subGenero.setFechaCreacion(LocalDateTime.now());
		subGenero.setFechaModificacion(LocalDateTime.now());
		subGenero.setEstatus(true);
		
		Genero genero = new Genero();
		genero.setDescripcion("Metal");
		genero.setFechaCreacion(LocalDateTime.now());
		genero.setEstatus(true);
		subGenero.setGenero(genero);
		this.subgeneroDAO.guardar(subGenero);
	}

	@Test
	void testActualizar() {
	  SubGenero subGeneroconsulta=this.subgeneroDAO.consultarById(4L);
	  subGeneroconsulta.setDescripcion("Trash Metal");
	  subGeneroconsulta.getGenero().setDescripcion("Metal Trash");
	  this.subgeneroDAO.actualizar(subGeneroconsulta);
	}

	@Test
	void testEliminar() {
		this.subgeneroDAO.eliminar(4L);
	}

	@Test
	void testConsultarById() {
		fail("Not yet implemented");
	}

	@Test
	void testConsultarGeneros() {
		List<SubGenero> consulta= this.subgeneroDAO.consultarGeneros();
		assertTrue(consulta.size()>0);
		  consulta.forEach(c->{
		    	 System.out.println(c.getDescripcion());

		    	 System.out.println(c.getGenero().getDescripcion());
		    	 });
	}

}
