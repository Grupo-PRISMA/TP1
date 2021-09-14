package promocionesTests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import atraccion.Atraccion;
import atraccion.TipoDeAtraccion;
import manejadorDeArchivos.LecturaDeArchivos;
import promociones.PromocionAbsoluta;


public class PromocionAbsolutaTest {

	@Test
	public void verificarCostoTotal() {
		LecturaDeArchivos manejadorArchivos = new LecturaDeArchivos();
		ArrayList<Atraccion> atraccion = manejadorArchivos.getAtracciones();
		PromocionAbsoluta promocionAbsoluta = new PromocionAbsoluta(TipoDeAtraccion.DEGUSTACION, 3, atraccion);
		double costoTotalSinDescuento = 0;
		for(Atraccion atraccion2 : atraccion) {
			costoTotalSinDescuento += atraccion2.getCosto();
		}
		double constoTotal = costoTotalSinDescuento - promocionAbsoluta.getDescuento();
		assertEquals(constoTotal, promocionAbsoluta.getCostoTotal(),0.0001);	
	}
	
	
	@Test
	public void descuentoEs3() {
		LecturaDeArchivos manejadorArchivos = new LecturaDeArchivos();
		ArrayList<Atraccion> atraccion = manejadorArchivos.getAtracciones();
		PromocionAbsoluta promocionAbsoluta = new PromocionAbsoluta(TipoDeAtraccion.DEGUSTACION, 3, atraccion);
		assertEquals(3, promocionAbsoluta.getDescuento(),0.0001);	
	}
	
}
