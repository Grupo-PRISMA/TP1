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


	@Override
	public String toString() {
		return "Tipo de Atraccion = " + tipo + "\tAtraccion Gratis = " + atraccionGratis.getNombre()
				+ "\nAtracciones = " + atracciones + "\n";

	}
	
	@Override	
	public boolean tieneCupo() {
		int contador = 0;
		for(int i = 0; i < super.atracciones.size(); i++) {
			if (super.atracciones.get(i).getCupoPersonas() > 0) {
				contador++;
			}
		}
		
		return contador == super.atracciones.size() && this.atraccionGratis.getCupoPersonas() > 0;
	}
}