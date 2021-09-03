package paquete;

public class PromocionAbsoluta extends Promocion {
	private static final String ID = "absoluta";
	private double descuentoDouble;

	public PromocionAbsoluta(TipoDeAtraccion tipo, String descuento, Atraccion[] atracciones) {
		super(tipo, atracciones);
		this.descuentoDouble = Double.parseDouble(descuento);
		super.id = PromocionAbsoluta.ID;
	}	

	@Override
	public void calculoPromocion() {
		super.costoTotal =(atracciones[0].getCosto() + atracciones[1].getCosto()) - descuentoDouble;
	}

	@Override
	public String toString() {
		return "PromocionAbsoluta [descuentoDouble=" + descuentoDouble + "]";
	}	
	
	
}