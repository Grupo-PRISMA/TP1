package paquete;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class PlataformaWeb {
	private ArrayList<Atraccion> atracciones;
	private ArrayList<Visitante> visitantes;
	private ArrayList<Promocion> promociones;

	public PlataformaWeb() {
		ManejadorArchivos manejadorArchivos = new ManejadorArchivos();

		this.atracciones = manejadorArchivos.getAtracciones();
		this.visitantes = manejadorArchivos.getVisitantes();
		this.promociones = manejadorArchivos.getPromociones();
	}

	public void crearSugerencia(ArrayList<Visitante> visitantes, ArrayList<Atraccion> atracciones, ArrayList<Promocion> promociones) {
		ArrayList<Sugerencia> todasLasSugerencias = new ArrayList<Sugerencia>();
		for (Visitante visitante : visitantes) {
			TipoDeAtraccion tipoDeAtraccionPreferida = visitante.getPreferencia();
			
			// Falta considerar esta parte del enunciado: 
			//Tampoco deberá ofertarse una atracción que ya haya sido incluida en una 
			//promoción anteriormente comprada por el mismo usuario.
			while (visitante.getPresupuesto() > 0 && visitante.getTiempoDisponibleHs() > 0) {
				for (int i = 0; i < promociones.size(); i++) {
					if (tipoDeAtraccionPreferida == promociones.get(i).getTipo() && promociones.get(i).tieneCupo()) {
						if (visitante.getPresupuesto() >= promociones.get(i).getCostoTotal()
								&& visitante.getTiempoDisponibleHs() >= promociones.get(i).getDuracionTotal()) {
							SugerenciaPromocion sugerencia = new SugerenciaPromocion(promociones.get(i));
							boolean respuesta = visitante.aceptaSugerenciaPromocion(sugerencia);
							if (respuesta) {
								todasLasSugerencias.add(sugerencia);
								visitante.setPresupuesto(promociones.get(i).getCostoTotal());
								visitante.setTiempoDisponibleHs(promociones.get(i).getDuracionTotal());
							}
						}
					}
				}

				for (int i = 0; i < atracciones.size(); i++) {
					if (tipoDeAtraccionPreferida == atracciones.get(i).getTipo()
							&& atracciones.get(i).getCupoPersonas() > 0) {
						if (visitante.getPresupuesto() >= atracciones.get(i).getCosto()
								&& visitante.getTiempoDisponibleHs() >= atracciones.get(i).getDuracion()) {
							SugerenciaAtraccion sugerencia = new SugerenciaAtraccion(atracciones.get(i));
							boolean respuesta = visitante.aceptaSugerenciaAtraccion(sugerencia);
							if (respuesta) {
								todasLasSugerencias.add(sugerencia);
								visitante.setPresupuesto(atracciones.get(i).getCosto());
								visitante.setTiempoDisponibleHs(atracciones.get(i).getDuracion());
							}
						}
					}
				}

				for (int i = 0; i < promociones.size(); i++) {
					if (tipoDeAtraccionPreferida != promociones.get(i).getTipo() && promociones.get(i).tieneCupo()) {
						if (visitante.getPresupuesto() >= promociones.get(i).getCostoTotal()
								&& visitante.getTiempoDisponibleHs() >= promociones.get(i).getDuracionTotal()) {
							SugerenciaPromocion sugerencia = new SugerenciaPromocion(promociones.get(i));
							boolean respuesta = visitante.aceptaSugerenciaPromocion(sugerencia);
							if (respuesta) {
								todasLasSugerencias.add(sugerencia);
								visitante.setPresupuesto(promociones.get(i).getCostoTotal());
								visitante.setTiempoDisponibleHs(promociones.get(i).getDuracionTotal());
							}
						}
					}
				}

				for (int i = 0; i < atracciones.size(); i++) {
					if (tipoDeAtraccionPreferida != atracciones.get(i).getTipo()
							&& atracciones.get(i).getCupoPersonas() > 0) {
						if (visitante.getPresupuesto() >= atracciones.get(i).getCosto()
								&& visitante.getTiempoDisponibleHs() >= atracciones.get(i).getDuracion()) {
							SugerenciaAtraccion sugerencia = new SugerenciaAtraccion(atracciones.get(i));
							boolean respuesta = visitante.aceptaSugerenciaAtraccion(sugerencia);
							if (respuesta) {
								todasLasSugerencias.add(sugerencia);
								visitante.setPresupuesto(atracciones.get(i).getCosto());
								visitante.setTiempoDisponibleHs(atracciones.get(i).getDuracion());
							}
						}
					}
				}

			}
			visitante.itinerario = todasLasSugerencias;
		}

	}

	@Override
	public String toString() {
		return "Carga:\n" + "Visitantes:\n" + visitantes + "\n" + "Atracciones:\n" + atracciones + "\n"
				+ "Promociones:\n" + promociones + "\n";
	}
}
