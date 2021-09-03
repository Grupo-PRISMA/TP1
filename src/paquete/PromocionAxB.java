package paquete;

public class PromocionAxB extends Promocion {
	private static final String ID = "AxB";
	private Atraccion atraccionGratis;

	public PromocionAxB(TipoDeAtraccion tipo, String descuento, Atraccion[] atracciones) {
		super(tipo, atracciones);
		this.atraccionGratis = Atraccion.getAtraccionPorNombre(descuento);
		super.id = PromocionAxB.ID;
	}
		
	public Atraccion getAtraccionGratis() {
		return this.atraccionGratis;
	}

	@Override
	public void calculoPromocion() {
		super.costoTotal = (atracciones[0].getCosto() + atracciones[1].getCosto());		
	}	
}