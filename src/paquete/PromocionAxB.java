package paquete;

public class PromocionAxB extends Promocion {

	private String atraccionGratis;
	private double costoTotal;

	public PromocionAxB(TipoDeAtraccion tipo, String nombreDescuento, Atraccion[] atracciones, String descuento) {
		super(tipo, nombreDescuento, atracciones);
		this.atraccionGratis = descuento;
	}
		
	public String getAtraccionGratis() {
		return atraccionGratis;
	}

	@Override
	public double getCostoTotal() {
		return costoTotal;
	}

	@Override
	public void calculoPromocion() {
		costoTotal = (atracciones[0].getCosto() + atracciones[1].getCosto());		
	}	
}