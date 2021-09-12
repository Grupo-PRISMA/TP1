package paquete;

import java.util.ArrayList;
import java.util.Scanner;

public class Visitante {
	private String nombre;
	private double presupuesto;
	private double tiempoDisponibleHs;
	private TipoDeAtraccion preferencia;

	public Visitante(String nombre, TipoDeAtraccion preferencia, double presupuesto, double tiempoDisponibleHs) {
		this.nombre = nombre;
		this.presupuesto = presupuesto;
		this.tiempoDisponibleHs = tiempoDisponibleHs;
		this.preferencia = preferencia;
		//this.itinerario = new ArrayList<Sugerencia>();
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
	
	public boolean decidirSugerencia(Sugerencia sugerencia) {	
		char respuesta;
		Scanner entrada = new Scanner(System.in);	
		
		do {
			System.out.println("Acepta sugerencia? Ingrese S o N");
			String a = entrada.nextLine();
			System.out.println(a);
			respuesta = a.charAt(0);
			respuesta = Character.toUpperCase(respuesta);
		} while (respuesta != 'S' && respuesta != 'N' && entrada.hasNextLine());
		//System.out.println("fin do while");
		//entrada.close();
		//System.out.println("cierra scanner");
		
		//promo.setAceptada(Character.toUpperCase(respuesta) == 'S');
		if(respuesta == 'S') {
			this.presupuesto -= sugerencia.getCosto();
			this.tiempoDisponibleHs -= sugerencia.getDuracionHs();
		}
		
		return respuesta == 'S';
		//return false;
	}
	
	@Override
	public String toString() {
		return "Nombre = " + nombre + ", Presupuesto = " + presupuesto + ", Tiempo Disponible Hs = "
				+ tiempoDisponibleHs + ", Preferencia = " + preferencia + "\n";
	}

}
