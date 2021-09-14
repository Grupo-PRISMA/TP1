package promociones;

import java.util.ArrayList;

import atraccion.Atraccion;
import atraccion.TipoDeAtraccion;

public class PromocionAbsoluta extends Promocion {
	private double descuento;

	public PromocionAbsoluta(TipoDeAtraccion tipo, double descuento, ArrayList<Atraccion> atracciones) {
		super(tipo, atracciones);
		this.descuento = descuento;
	}

	public double getDescuento() {
		return this.descuento;
	}

	@Override
	public String toString() {
		return "[" + atracciones.get(0).getNombre() + ", " + atracciones.get(1).getNombre() + "]\nPrecio original: " + super.getCostoSinDescuento() + 
				" Duracion: " + this.getDuracionTotal() + "\n Precio con descuento: " + super.getCostoTotal();

	}
}