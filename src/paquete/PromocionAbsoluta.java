package paquete;

public class PromocionAbsoluta extends Promocion {
	
	private double descuentoDouble;
	private double costoTotal;

	public PromocionAbsoluta(TipoDeAtraccion tipo, String nombreDescuento, Atraccion[] atracciones, String descuento) {
		super(tipo, nombreDescuento, atracciones);
		this.descuentoDouble = Double.parseDouble(descuento);
	}	

	@Override
	public double getCostoTotal() {
		return costoTotal;
	}

	@Override
	public void calculoPromocion() {
		costoTotal =(atracciones[0].getCosto() + atracciones[1].getCosto()) - descuentoDouble;
	}	
}