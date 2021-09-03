package paquete;

public class PromocionAxB extends Promocion {

	private Atraccion atraccionGratis;
	private double costoTotal;

	public PromocionAxB(TipoDeAtraccion tipo, String nombreDescuento, Atraccion[] atracciones, String descuento) {
		super(tipo, nombreDescuento, atracciones);
		this.atraccionGratis = Atraccion.getAtraccionPorNombre(descuento);
	}
		
	public Atraccion getAtraccionGratis() {
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