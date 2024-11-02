/**
 * 
 */
package com.dangabito.projectjpa.dao.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.dangabito.projectjpa.dao.DisqueraDAO;
import com.dangabito.projectjpa.dao.impl.DisqueraDaoImpl;
import com.dangabito.projectjpa.entity.Disquera;

import jakarta.persistence.EntityManager;

/**
 * 
 */
class DisqueraDaoImplTest {

	private DisqueraDAO disqueraDAO = new DisqueraDaoImpl();

	/**
	 * Test method for
	 * {@link com.dangabito.projectjpa.dao.impl.DisqueraDaoImpl#DisqueraDaoImpl()}.
	 */
	@Test
	void testDisqueraDaoImpl() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link com.dangabito.projectjpa.dao.impl.DisqueraDaoImpl#guardar(com.dangabito.projectjpa.entity.Disquera)}.
	 */
	@Test
	void testGuardar() {
		Disquera disquera = new Disquera();
		disquera.setDescripcion("Sony");
		disquera.setFechaCreacion(LocalDateTime.now());
		disquera.setFechaModificacion(LocalDateTime.now());
		disquera.setEstatus(true);

		this.disqueraDAO.guardar(disquera);
	}

	/**
	 * Test method for {@link com.dangabito.projectjpa.dao.impl.DisqueraDaoImpl#actualizar(com.dangabito.projectjpa.entity.Disquera)}.
	 */
	@Test
	void testActualizar() {
	Disquera disquera=this.disqueraDAO.consultarById(9L);
	System.out.println("consultado:"+ disquera.getDescripcion());
	disquera.setDescripcion("Disquera pepe forz");
          this.disqueraDAO.actualizar(disquera);
	}

	/**
	 * Test method for
	 * {@link com.dangabito.projectjpa.dao.impl.DisqueraDaoImpl#eliminar(com.dangabito.projectjpa.entity.Disquera)}.
	 */
	@Test
	void testEliminar() {
	    Long idLong=9L;
		this.disqueraDAO.eliminar(idLong);
	}

	/**
	 * Test method for
	 * {@link com.dangabito.projectjpa.dao.impl.DisqueraDaoImpl#consultar()}.
	 */
	@Test
	void testConsultar() {
	     List<Disquera> consulta= this.disqueraDAO.consultar();
	     assertTrue(consulta.size()>0);
	     consulta.forEach(c->{ 
	    	 System.out.println(c.getDescripcion());
	    	 });
	}

	/**
	 * Test method for
	 * {@link com.dangabito.projectjpa.dao.impl.DisqueraDaoImpl#consultarById(java.lang.Long)}.
	 */
	@Test
	void testConsultarById() {
		Disquera disquera = this.disqueraDAO.consultarById(9L);
		System.out.println("Disquera :" + disquera.getDescripcion());
	}

}
