package paquete;

import java.util.ArrayList;

public abstract class Promocion
{
	public static String TIPO_ABSOLUTA = "absoluta";
	public static String TIPO_AxB = "AxB";
	public static String TIPO_PORCENTUAL = "porcentual";
	
	protected TipoDeAtraccion tipo;
	protected ArrayList<Atraccion> atracciones = new ArrayList<>();

	public Promocion(TipoDeAtraccion tipo, ArrayList<Atraccion> atracciones) {
		this.tipo = tipo;
		this.atracciones = atracciones;
	}

	public TipoDeAtraccion getTipo() {
		return this.tipo;
	}

	public ArrayList<Atraccion> getAtracciones() {
		return this.atracciones;
	}
	
	public double getCostoTotal(){
		double costoTotal = 0;

		for (Atraccion atraccion : this.atracciones) {
			costoTotal += atraccion.getCosto();
		}

		return costoTotal - this.getDescuento();
	}
	
	public double getDuracionTotal() {
		double duracionTotal = 0;

		for (Atraccion atraccion : this.atracciones) {
			duracionTotal += atraccion.getDuracion();
		}

		return duracionTotal;
	}

	public abstract double getDescuento();

	/*
	@Override
	public String toString() {
		return "Promocion [Id = " + id + ", tipo = " + tipo + ", atracciones = " + Arrays.toString(atracciones)
				+ ", costoTotal = " + costoTotal + "]";
	}
	*/
}