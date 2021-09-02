package paquete;

public class PromocionAbsoluta extends Promocion {
	private double DESCUENTO_FIJO;
	
	public PromocionAbsoluta(TipoDeAtraccion tipo, String nombreDescuento, Atraccion[] atracciones, double DESCUENTO_FIJO) {
		super(tipo, nombreDescuento, atracciones);
		this.DESCUENTO_FIJO = DESCUENTO_FIJO;
	}

	@Override
	public double calculoPromocion() {
		
		return 0;
	}

	@Override
	public double getCostoTotal() {
		
		return 0;
	}		
}