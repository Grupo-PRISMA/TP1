package paquete;

import java.util.Arrays;

public abstract class Promocion {
	protected TipoDeAtraccion tipo;
	protected String tipoDeAtraccion;
	protected Atraccion[] atracciones;

	public Promocion(TipoDeAtraccion tipo, String nombreDescuento, Atraccion[] atracciones) {
		this.tipo = tipo;
		this.tipoDeAtraccion = nombreDescuento;
		this.atracciones = atracciones;
	}

	public TipoDeAtraccion getTipo() {
		return this.tipo;
	}

	public String getNombreDescuento() {
		return this.tipoDeAtraccion;
	}

	public Atraccion[] getAtracciones() {
		return this.atracciones;
	}

	@Override
	public String toString() {
		return "Tipo = " + tipo + ", Nombre Promo = " + tipoDeAtraccion + ", Atracciones = "
				+ Arrays.toString(atracciones) + "\n";
	}
	
	public abstract double getCostoTotal();
	
	public abstract void calculoPromocion();
}