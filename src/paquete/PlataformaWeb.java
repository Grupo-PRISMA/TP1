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

	@Override
	public String toString() {
		return "Carga:\n" + "Visitantes:\n" + Arrays.toString(visitantes) + "\n" + "Atracciones:\n"
				+ Arrays.toString(atracciones) + "\n" + "Promociones:\n" + Arrays.toString(promociones) + "\n";
	}
}
