package paquete;

import java.util.Arrays;

public abstract class Promocion {
	protected String id;
	protected TipoDeAtraccion tipo;
	protected Atraccion[] atracciones;
	protected double costoTotal;

	public Promocion(TipoDeAtraccion tipo, Atraccion[] atracciones) {
		this.tipo = tipo;
		this.atracciones = atracciones;
		this.costoTotal = 0;
	}

	public String getId() {
		return id;
	}

	public TipoDeAtraccion getTipo() {
		return this.tipo;
	}

	public Atraccion[] getAtracciones() {
		return this.atracciones;
	}
	
	public double getCostoTotal(){
		return this.costoTotal;
	}
	
	public abstract void calculoPromocion();

	@Override
	public String toString() {
		return "Promocion [Id = " + id + ", tipo = " + tipo + ", atracciones = " + Arrays.toString(atracciones)
				+ ", costoTotal = " + costoTotal + "]";
	}
}