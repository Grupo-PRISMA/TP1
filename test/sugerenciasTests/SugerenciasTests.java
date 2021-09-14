package sugerenciasTests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import atraccion.Atraccion;
import atraccion.TipoDeAtraccion;
import manejadorDeArchivos.LecturaDeArchivos;
import promociones.PromocionAxB;
import sugerencia.Sugerencia;

public class SugerenciasTests {

	@Test
	public void constructosDeSugerenciaDePromocionAxB() {
		LecturaDeArchivos manejadorArchivos = new LecturaDeArchivos();
		ArrayList<Atraccion> atraccion = manejadorArchivos.getAtracciones();
		Atraccion atraccionGratis = atraccion.get(5);
		PromocionAxB promocionAxB = new PromocionAxB(TipoDeAtraccion.PAISAJE, atraccionGratis, atraccion);
		Sugerencia sugerencia = new Sugerencia(promocionAxB);
		assertEquals("Kashyyk", promocionAxB.getNombreAtraccionGratis());
		assertEquals(atraccionGratis.getNombre(), promocionAxB.getNombreAtraccionGratis());
	}
	
	@Test
	public void contructorDeSugerenciaDeAtraccion() {
		LecturaDeArchivos manejadorArchivos = new LecturaDeArchivos();
		ArrayList<Atraccion> atraccion = manejadorArchivos.getAtracciones();
		Sugerencia sugerencia = new Sugerencia(atraccion.get(0));
		System.out.println(atraccion.get(0));
		assertEquals("Geonosis", atraccion.get(0).getNombre());
		assertEquals(35, atraccion.get(0).getCosto(),0.001);
		assertEquals(1,atraccion.get(0).getDuracion(),0.001);
		assertEquals(30,atraccion.get(0).getCupoPersonas());
	}
	
	@Test 
	public void quitarCuposDe30A10() {
		LecturaDeArchivos manejadorArchivos = new LecturaDeArchivos();
		ArrayList<Atraccion> atraccion = manejadorArchivos.getAtracciones();
		Sugerencia sugerencia = new Sugerencia(atraccion.get(0));
		assertEquals(30, atraccion.get(0).getCupoPersonas());
		for(int i = 0;i<20;i++) {
			atraccion.get(0).bajarCupo();
			
		}
		assertEquals(10, atraccion.get(0).getCupoPersonas());
	}

}
