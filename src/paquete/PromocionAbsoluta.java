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


	@Override
	public String toString() {
		return "Tipo de Atraccion = " + tipo + "\tDescuento = " + descuento + "\nAtracciones = "
				+ atracciones + "\n";
	}
	
	@Override	
	public boolean tieneCupo() {
		int contador = 0;
		for(int i = 0; i < super.atracciones.size(); i++) {
			if (super.atracciones.get(i).getCupoPersonas() > 0) {
				contador++;
			}
		}
		
		return contador == super.atracciones.size();
	}

}