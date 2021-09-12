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


	/*@Override
	public String toString() {
		return "Tipo de Atraccion = " + tipo + "\tAtraccion Gratis = " + atraccionGratis.getNombre()
				+ "\nAtracciones = " + atracciones + "\n";

	}*/
	
	@Override	
	public boolean hayCupo() {
		return super.hayCupo() && this.atraccionGratis.hayCupo();
	}
}