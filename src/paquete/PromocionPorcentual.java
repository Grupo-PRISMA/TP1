package paquete;

public class PromocionPorcentual extends Promocion {
	private double PORCENTAJE;
	
	public PromocionPorcentual(TipoDeAtraccion tipo, String nombreDescuento, Atraccion[] atracciones, double PORCENTAJE) {
		super(tipo, nombreDescuento, atracciones);
		this.PORCENTAJE = PORCENTAJE;
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