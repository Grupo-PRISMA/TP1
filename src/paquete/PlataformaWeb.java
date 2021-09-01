package paquete;

import java.util.Arrays;

public class PlataformaWeb {
	private Visitante[] usuarios;
	private Atraccion[] atracciones;
	private Promocion[] promociones;

	public PlataformaWeb() {

	}

	public void agregarTodosUsuarios(Visitante[] usuarios) {
		this.usuarios = usuarios;
	}

	public void agregarTodasAtracciones(Atraccion[] atracciones) {
		this.atracciones = atracciones;
	}

	public void agregarTodasPromociones(Promocion[] promociones) {
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
		return "Carga:\n" + "Usuarios:\n" + Arrays.toString(usuarios) + "\n" + "Atracciones:\n"
				+ Arrays.toString(atracciones) + "\n" + "Promociones:\n" + Arrays.toString(promociones) + "\n";
	}
}
