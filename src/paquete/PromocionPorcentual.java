package paquete;

public class PromocionPorcentual extends Promocion {
	private double doubleDescuento;
	private double costoTotal;
	
	public PromocionPorcentual(TipoDeAtraccion tipoDeAtraccion, String descuento, Atraccion[] atracciones) {
		super(tipoDeAtraccion, descuento, atracciones);
		this.doubleDescuento = Double.parseDouble(descuento);
	}

	@Override
	public double getCostoTotal() {
		return costoTotal;
	}

	@Override
	public void calculoPromocion() {
		costoTotal = (atracciones[0].getCosto() + atracciones[1].getCosto()) * doubleDescuento;	
	}	
}