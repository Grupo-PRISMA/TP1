package paquete;

import java.util.ArrayList;

public class PromocionPorcentual extends Promocion {
	private double descuento;

	public PromocionPorcentual(TipoDeAtraccion tipo, double descuento, ArrayList<Atraccion> atracciones) {
		super(tipo, atracciones);
		this.descuento = descuento;
	}

	public double getDescuento() {
		return super.getCostoTotal() * (this.descuento / 100);
	}

/*
	@Override
	public String toString() {
		return "Tipo = " + id + "\tTipo de Atraccion = " + tipo + "\tDescuento = " + descuento + "\tAtracciones = "
				+ atracciones[0].getNombre() + ", " + atracciones[1].getNombre() + "\n";
	}
*/
}