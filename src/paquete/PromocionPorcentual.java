package paquete;

public class PromocionPorcentual extends Promocion {
	private static final String ID = "porcentual";
	private double doubleDescuento;
	
	
	public PromocionPorcentual(TipoDeAtraccion tipo, String descuento, Atraccion[] atracciones) {
		super(tipo, atracciones);
		this.doubleDescuento = Double.parseDouble(descuento);
		super.id = PromocionPorcentual.ID;
	}

	@Override
	public void calculoPromocion() {
		super.costoTotal = (atracciones[0].getCosto() + atracciones[1].getCosto()) * doubleDescuento;	
	}	
}