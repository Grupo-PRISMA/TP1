package paquete;

public class Sugerencia {

	private String nombre;
	private double costo;
	private double duracionHs;
	private boolean aceptada;

	public Sugerencia(String nombre, double costo, double duracionHs) {
		this.nombre = nombre;
		this.costo = costo;
		this.duracionHs = duracionHs;
		this.aceptada = false;
	}

	public void setAceptada(boolean aceptada) {
		this.aceptada = aceptada;
	}

	@Override
	public String toString() {
		return "Sugerencia [nombre=" + nombre + ", costo=" + costo + ", duracionHs=" + duracionHs + ", aceptada="
				+ aceptada + "]";
	}
}
