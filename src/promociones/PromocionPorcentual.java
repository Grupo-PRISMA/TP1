package promociones;

import java.util.ArrayList;

import atraccion.Atraccion;
import atraccion.TipoDeAtraccion;

public class PromocionPorcentual extends Promocion {
	private double descuento;

	public PromocionPorcentual(TipoDeAtraccion tipo, double descuento, ArrayList<Atraccion> atracciones) {
		super(tipo, atracciones);
		this.descuento = descuento;
	}
	
	public double getCostoTotal(){
		double costoTotal = 0;

		for (Atraccion atraccion : this.atracciones) {
			costoTotal += atraccion.getCosto();
		}

		return costoTotal * (1 - descuento / 100);
	}

	public double getDescuento() {
		return 0;
	}

	/*@Override
	public String toString() {
		return "Tipo de Atraccion = " + tipo + "\tDescuento = " + descuento + "\nAtracciones = "
				+ atracciones + "\n";
	}*/
}