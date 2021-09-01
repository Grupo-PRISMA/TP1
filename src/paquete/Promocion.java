package paquete;

import java.util.Arrays;

public abstract class Promocion {
	private TipoDeAtraccion tipo;
	private String nombreDescuento;
	private Atraccion[] atracciones;

	public Promocion(TipoDeAtraccion tipo, String promo, Atraccion[] atracciones) {
			this.tipo = tipo;
			this.nombreDescuento = promo;
			this.atracciones = atracciones;
		}

	public TipoDeAtraccion getTipo() {
		return tipo;
	}

	public String getPromo() {
		return nombreDescuento;
	}

	public Atraccion[] getAtracciones() {
		return atracciones;
	}

	@Override
	public String toString() {
		return "Tipo = " + tipo + ", Promo = " + nombreDescuento + ", Atracciones = " + Arrays.toString(atracciones) + "\n";
	}
}
