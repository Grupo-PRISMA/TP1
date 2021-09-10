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