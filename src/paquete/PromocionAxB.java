package paquete;

import java.util.ArrayList;

public class PromocionAxB extends Promocion {
	private Atraccion atraccionGratis;

	public PromocionAxB(TipoDeAtraccion tipo, Atraccion atraccionGratis, ArrayList<Atraccion> atracciones) {
		super(tipo, atracciones);
		this.atraccionGratis = atraccionGratis;
	}

	public double getDescuento() {
		return 0;
	}

	public double getDuracionTotal() {
		return super.getDuracionTotal() + this.atraccionGratis.getDuracion();
	}

/*
	@Override
	public String toString() {
		return "Tipo = " + id + "\tTipo de Atraccion = " + tipo + "\tAtraccion Gratis = " + atraccionGratis.getNombre()
				+ "\tAtracciones = " + atracciones[0].getNombre() + ", " + atracciones[1].getNombre() + "\n";

	}
*/
}