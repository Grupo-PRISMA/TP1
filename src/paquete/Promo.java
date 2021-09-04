package paquete;

public class Promo extends Promocion {

	public Promo(TipoDeAtraccion tipo, Atraccion[] atracciones) {
		super(tipo, atracciones);
	}

	@Override
	public void calculoPromocion() {
	}

	@Override
	protected double getDuracionHs() {
		return 0;
	}

}
