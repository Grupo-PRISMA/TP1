package paquete;

import java.util.ArrayList;

public class Sugerencia {
	
	private Promocion promocion;
	private Atraccion atraccion;
	private double costo;
	private double duracionHs;
	private boolean aceptada;

	
	//revisar la existencia de la clase sugerencia
	
	public Sugerencia(Promocion promo, Atraccion atraccion, double costo, double duracionHs) {
		this.promocion = promo;
		this.atraccion = atraccion;
		this.costo = costo;
		this.duracionHs = duracionHs;
		this.aceptada = false;
	}

	public void setAceptada(boolean aceptada) {
		this.aceptada = aceptada;
	}

	public double getCosto() {
		return costo;
	}

	public double getDuracionHs() {
		return duracionHs;
	}

	@Override
	public String toString() {
		return "Sugerencia [nombre=" + atraccion + ", costo=" + costo + ", duracionHs=" + duracionHs + ", aceptada="
				+ aceptada + "]";
	}

}
