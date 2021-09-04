package paquete;

import java.util.Arrays;

public class PlataformaWeb {
	private Visitante[] visitantes;
	private Atraccion[] atracciones;
	private Promocion[] promociones;

	public PlataformaWeb() {

	}

	public void construirVisitantes(Visitante[] visitantes) {
		this.visitantes = visitantes;
	}

	public void construirAtracciones(Atraccion[] atracciones) {
		this.atracciones = atracciones;
	}

	public void construirPromociones(Promocion[] promociones) {
		this.promociones = promociones;
	}

	public Atraccion obtenerAtraccionesPorTipo(TipoDeAtraccion tipo) {
		for (Atraccion atraccion : atracciones) {
			if (atraccion.getTipo().equals(tipo)) {
				return atraccion;
			}
		}
		return null;
	}

	private Promocion obtenerPromocionPorTipo(TipoDeAtraccion tipoDeAtraccionPreferida) {
		for (Promocion promocion : promociones) {
			if (promocion.getTipo().equals(tipoDeAtraccionPreferida)) {
				return promocion;
			}
		}
		return null;
	}

	@Override
	public String toString() {
		return "Carga:\n" + "Visitantes:\n" + Arrays.toString(visitantes) + "\n" + "Atracciones:\n"
				+ Arrays.toString(atracciones) + "\n" + "Promociones:\n" + Arrays.toString(promociones) + "\n";
	}

	public Sugerencia[] crearSugerencia(Visitante[] visitantes, Atraccion[] atracciones, Promo[] promociones) {
		for (Visitante visitante : visitantes) {
			int i = 0;
			TipoDeAtraccion tipoDeAtraccionPreferida = visitante.getPreferencia();
			Promocion promo = obtenerPromocionPorTipo(tipoDeAtraccionPreferida);
			Sugerencia sugerencia = new Sugerencia(promo.getAtracciones(), promo.getCostoTotal(),
					promo.getDuracionHs());

			while (visitante.tienePresupuesto() && visitante.tieneHs()) {
				if (visitante.getPresupuesto() >= promo.getCostoTotal()
						&& visitante.getTiempoDisponibleHs() >= promo.getDuracionHs()
						&& promo.getAtracciones()[0].getCupoPersonas() >= 0) {

				}
				visitante.aceptaSugerencia(sugerencia);
			}

		}

		return null;
	}

}
