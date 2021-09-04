package paquete;

public class Sugerencia {
	
	private Atraccion[] atracciones;
	private double costo;
	private double duracionHs;
	private boolean aceptada;

	public Sugerencia(Atraccion[] atracciones, double costo, double duracionHs) {
		this.atracciones = atracciones;
		this.costo = costo;
		this.duracionHs = duracionHs;
		this.aceptada = false;
	}

	public void setAceptada(boolean aceptada) {
		this.aceptada = aceptada;
	}

	@Override
	public String toString() {
		return "Sugerencia [nombre=" + atracciones + ", costo=" + costo + ", duracionHs=" + duracionHs + ", aceptada="
				+ aceptada + "]";
	}
}
