package paquete;

import java.util.ArrayList;
import java.util.Scanner;

public class Visitante {
	private String nombre;
	private double presupuesto;
	private double tiempoDisponibleHs;
	private TipoDeAtraccion preferencia;

	private ArrayList<Sugerencia> itinerario;

	public Visitante(String nombre, double presupuesto, double tiempoDisponibleHs, TipoDeAtraccion preferencia) {
		this.nombre = nombre;
		this.presupuesto = presupuesto;
		this.tiempoDisponibleHs = tiempoDisponibleHs;
		this.preferencia = preferencia;
		this.itinerario = new ArrayList<Sugerencia>();
	}

	public String getNombre() {
		return this.nombre;
	}

	public TipoDeAtraccion getPreferencia() {
		return this.preferencia;
	}

	public double getPresupuesto() {
		return this.presupuesto;
	}

	public double getTiempoDisponibleHs() {
		return this.tiempoDisponibleHs;
	}

	public boolean aceptaSugerencia(Sugerencia sugerencia) {
		char respuesta;
		Scanner entradaEscaner = new Scanner(System.in);
		System.out.println("Acepta sugerencia? (S/N)");
		respuesta = entradaEscaner.nextLine().charAt(0);
		entradaEscaner.close();
		sugerencia.setAceptada(Character.toUpperCase(respuesta) == 'S');
		this.itinerario.add(sugerencia);

		return Character.toUpperCase(respuesta) == 'S';
	}

	@Override
	public String toString() {
		return "Nombre = " + nombre + ", Presupuesto = " + presupuesto + ", Tiempo Disponible Hs = "
				+ tiempoDisponibleHs + ", Preferencia = " + preferencia + "\n";
	}

	public boolean tieneHs() {
		return getTiempoDisponibleHs() > 0;
	}

	public boolean tienePresupuesto() {
		return getPresupuesto() > 0;
	}

}
