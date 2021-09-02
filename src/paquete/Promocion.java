package paquete;

import java.util.Arrays;

public abstract class Promocion {
	private TipoDeAtraccion tipo;
	private String nombreDescuento;
	private Atraccion[] atracciones;

	public Promocion(TipoDeAtraccion tipo, String nombreDescuento, Atraccion[] atracciones) {
		this.tipo = tipo;
		this.nombreDescuento = nombreDescuento;
		this.atracciones = atracciones;
	}

	public TipoDeAtraccion getTipo() {
		return this.tipo;
	}

	public String getNombreDescuento() {
		return this.nombreDescuento;
	}

	public Atraccion[] getAtracciones() {
		return this.atracciones;
	}

	@Override
	public String toString() {
		return "Tipo = " + tipo + ", Nombre Promo = " + nombreDescuento + ", Atracciones = "
				+ Arrays.toString(atracciones) + "\n";
	}
	
	public abstract double calculoPromocion();
	
	public abstract double getCostoTotal();
}
