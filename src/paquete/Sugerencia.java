package paquete;

import java.util.ArrayList;

public class Sugerencia {
	
	private ArrayList<String> nombresAtracciones;
	private double costo;
	private double duracionHs;
	
	public Sugerencia(Promocion promo) {
		this.nombresAtracciones = this.extraerNombre(promo.getAtracciones());
		this.costo = promo.getCostoTotal();
		this.duracionHs = promo.getDuracionTotal();
	}
	
	public Sugerencia(Atraccion atraccion) {
		this.nombresAtracciones = new ArrayList<>();
		this.nombresAtracciones.add(atraccion.getNombre());
		this.costo = atraccion.getCosto();
		this.duracionHs = atraccion.getDuracion();
	}
	
	private ArrayList<String> extraerNombre(ArrayList<Atraccion> atracciones) {
		ArrayList<String> lista = new ArrayList<String>();
		
		for(Atraccion atraccion : atracciones) {
			lista.add(atraccion.getNombre());
		}
		
		return lista;
	}
	
	public ArrayList<String> getNombresAtracciones() {
		return this.nombresAtracciones;
	}

	public double getCosto() {
		return this.costo;
	}

	public double getDuracionHs() {
		return this.duracionHs;
	}

	@Override
	public String toString() {
		return "Sugerencia [costo=" + costo + ", duracionHs=" + duracionHs + "]";
	}

	public boolean estaEn(ArrayList<Sugerencia> sugerencias) {
		for(String nombre : this.nombresAtracciones) {
			if (sugerencias.contains(nombre)) {
				return true;
			}
		}
		
		return false;
	}
}
