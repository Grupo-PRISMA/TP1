package paquete;

public class PromocionAxB extends Promocion {
	private Atraccion [] actividadGratis;
	
	public PromocionAxB(TipoDeAtraccion tipo, String nombreDescuento, Atraccion[] atracciones, Atraccion [] actividadGratis) {
		super(tipo, nombreDescuento, atracciones);
		this.actividadGratis = actividadGratis;
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