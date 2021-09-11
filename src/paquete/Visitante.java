package paquete;

import java.util.ArrayList;
import java.util.Scanner;

public class Visitante {
	private String nombre;
	private double presupuesto;
	private double tiempoDisponibleHs;
	private TipoDeAtraccion preferencia;

	ArrayList<Sugerencia> itinerario;

	public Visitante(String nombre, TipoDeAtraccion preferencia, double presupuesto, double tiempoDisponibleHs) {
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

	public boolean tieneHs() {
		return getTiempoDisponibleHs() > 0;
	}

	public boolean tienePresupuesto() {
		return getPresupuesto() > 0;
	}

	public void setPresupuesto(double presupuesto) {
		this.presupuesto -= presupuesto;
	}

	public void setTiempoDisponibleHs(double tiempoDisponibleHs) {
		this.tiempoDisponibleHs -= tiempoDisponibleHs;
	}

	public boolean aceptaSugerenciaAtraccion(SugerenciaAtraccion sugerencia) {
		char respuesta;
		Scanner entradaEscaner = new Scanner(System.in);
		System.out.println("Acepta sugerencia? (S/N)");
		respuesta = entradaEscaner.nextLine().charAt(0);
		entradaEscaner.close();
		// promo.setAceptada(Character.toUpperCase(respuesta) == 'S');
		
		return Character.toUpperCase(respuesta) == 'S';
	}
	
	public boolean aceptaSugerenciaPromocion(SugerenciaPromocion sugerencia) {
		char respuesta;
		Scanner entradaEscaner = new Scanner(System.in);
		System.out.println("Acepta sugerencia? (S/N)");
		respuesta = entradaEscaner.nextLine().charAt(0);
		entradaEscaner.close();
		// promo.setAceptada(Character.toUpperCase(respuesta) == 'S');

		return Character.toUpperCase(respuesta) == 'S';
	}
	
	@Override
	public String toString() {
		return "Nombre = " + nombre + ", Presupuesto = " + presupuesto + ", Tiempo Disponible Hs = "
				+ tiempoDisponibleHs + ", Preferencia = " + preferencia + "\n";
	}

}
