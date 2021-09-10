package paquete;

import java.util.ArrayList;

public class PromocionAbsoluta extends Promocion {
	private double descuento;

	public PromocionAbsoluta(TipoDeAtraccion tipo, double descuento, ArrayList<Atraccion> atracciones) {
		super(tipo, atracciones);
		this.descuento = descuento;
	}

	public double getDescuento() {
		return this.descuento;
	}

/*
	@Override
	public String toString() {
		return "Tipo = " + id + "\tTipo de Atraccion = " + tipo + "\tDescuento = " + descuento + "\tAtracciones = "
				+ atracciones[0].getNombre() + ", " + atracciones[1].getNombre() + "\n";
	}
*/
}