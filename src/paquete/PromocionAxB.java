package paquete;

public class PromocionAxB extends Promo {
	private static final String ID = "AxB";
	private Atraccion atraccionGratis;

	public PromocionAxB(TipoDeAtraccion tipo, Atraccion atraccionGratis, Atraccion[] atracciones) {
		super(tipo, atracciones);
		this.atraccionGratis = atraccionGratis;
		super.id = PromocionAxB.ID;
	}
		
	public Atraccion getAtraccionGratis() {
		return this.atraccionGratis;
	}

	@Override
	public void calculoPromocion() {
		super.costoTotal = (atracciones[0].getCosto() + atracciones[1].getCosto());		
	}

	@Override
	public String toString() {
		return "Tipo = " + id + "\tTipo de Atraccion = " + tipo + "\tAtraccion Gratis = " + atraccionGratis.getNombre() + "\tAtracciones = " + atracciones[0].getNombre() + ", " + atracciones[1].getNombre()+"\n";
		
	}	
	
	
}