package promociones;

import java.util.ArrayList;

import atraccion.Atraccion;
import atraccion.TipoDeAtraccion;

public class PromocionAbsoluta extends Promocion {
	private double descuento;

	public PromocionAbsoluta(TipoDeAtraccion tipo, double descuento, ArrayList<Atraccion> atracciones) {
		super(tipo, atracciones);
		this.descuento = descuento;
	}

	public double getDescuento() {
		return this.descuento;
	}

	/*@Override
	public String toString() {
		return "Tipo de Atraccion = " + tipo + "\tDescuento = " + descuento + "\nAtracciones = "
				+ atracciones + "\n";
	}*/
}