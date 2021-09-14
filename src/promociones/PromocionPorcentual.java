package promociones;

import java.util.ArrayList;

import atraccion.Atraccion;
import atraccion.TipoDeAtraccion;

public class PromocionPorcentual extends Promocion {
	private double descuento;

	public PromocionPorcentual(TipoDeAtraccion tipo, double descuento, ArrayList<Atraccion> atracciones) {
		super(tipo, atracciones);
		this.descuento = descuento;
	}
	
	public double getCostoTotal(){
		double costoTotal = 0;

		for (Atraccion atraccion : this.atracciones) {
			costoTotal += atraccion.getCosto();
		}

		return Math.round(costoTotal * (1 - descuento));
	}

	public double getDescuento() {
		return 0;
	}

	@Override
	public String toString() {
		return "[" + atracciones.get(0).getNombre() + ", " + atracciones.get(1).getNombre() + "]\nPrecio original: " + super.getCostoSinDescuento() + 
				" Duracion: " + this.getDuracionTotal() + "\n Precio con descuento: " + this.getCostoTotal();

	}
}