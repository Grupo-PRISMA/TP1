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
		return nombre;
	}
	
	public TipoDeAtraccion getPreferencia() {
		return preferencia;
	}

	public double getPresupuesto() {
		return presupuesto;
	}

	public double getTiempoDisponibleHs() {
		return tiempoDisponibleHs;
	}

	public boolean aceptaSugerencia(Sugerencia sugerencia) {
		char rta;
		Scanner entradaEscaner = new Scanner(System.in);
		System.out.println("¿Acepta sugerencia? (S/N)");
		rta = entradaEscaner.nextLine().charAt(0);
		entradaEscaner.close();
		sugerencia.setAceptada(Character.toUpperCase(rta) == 'S');
		this.itinerario.add(sugerencia);

		return Character.toUpperCase(rta) == 'S';
	}

	@Override
	public String toString() {
		return "Visitante [Nombre = " + nombre + ", Presupuesto = " + presupuesto + ", Tiempo Disponible Hs = "
				+ tiempoDisponibleHs + ", Preferencia = " + preferencia + "]";
	}
	
}
