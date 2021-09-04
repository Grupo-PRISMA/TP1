package paquete;

public class PromocionAbsoluta extends Promo {
	private static final String ID = "absoluta";
	
	private double descuento;

	public PromocionAbsoluta(TipoDeAtraccion tipo, double descuento, Atraccion[] atracciones) {
		super(tipo, atracciones);
		this.descuento = descuento;
		super.id = PromocionAbsoluta.ID;
	}	

	@Override
	public void calculoPromocion() {
		super.costoTotal = (atracciones[0].getCosto() + atracciones[1].getCosto()) - descuento;
	}

	@Override
	public String toString() {
		return "Tipo = " + id + "\tTipo de Atraccion = " + tipo + "\tDescuento = " + descuento + "\tAtracciones = " + atracciones[0].getNombre() + ", " + atracciones[1].getNombre()+"\n";
	}
	
	
}