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

	public Sugerencia[] crearSugerencia(ArrayList<Visitante> visitantes, ArrayList<Atraccion> atracciones, ArrayList<Promocion> promociones) {
		for (Visitante visitante : visitantes) {
			TipoDeAtraccion tipoDeAtraccionPreferida = visitante.getPreferencia();
			
			for(int i = 0; i < promociones.size(); i++) {
				if(tipoDeAtraccionPreferida == promociones.get(i).getTipo() && promociones.get(i).tieneCupo()) {
					if(visitante.getPresupuesto() >= promociones.get(i).getCostoTotal() && visitante.getTiempoDisponibleHs() >= promociones.get(i).getDuracionTotal()) {
						boolean respuesta = visitante.aceptaSugerenciaPromocion(promociones.get(i));
					}
				}	
			}
			
			for(int i = 0; i < atracciones.size(); i++) {
				if(tipoDeAtraccionPreferida == atracciones.get(i).getTipo() && atracciones.get(i).getCupoPersonas() > 0) {
					if(visitante.getPresupuesto() >= atracciones.get(i).getCosto() && visitante.getTiempoDisponibleHs() >= atracciones.get(i).getDuracion()) {
						boolean respuesta = visitante.aceptaSugerenciaAtraccion(atracciones.get(i));
					}
				}	
			}
			
			for(int i = 0; i < promociones.size(); i++) {
				if(tipoDeAtraccionPreferida != promociones.get(i).getTipo() && promociones.get(i).tieneCupo()) {
					if(visitante.getPresupuesto() >= promociones.get(i).getCostoTotal() && visitante.getTiempoDisponibleHs() >= promociones.get(i).getDuracionTotal()) {
						//visitante.aceptaSugerencia(promocion.get(i));
					}
				}	
			}
			
			for(int i = 0; i < atracciones.size(); i++) {
				if(tipoDeAtraccionPreferida != atracciones.get(i).getTipo() && atracciones.get(i).getCupoPersonas() > 0) {
					if(visitante.getPresupuesto() >= atracciones.get(i).getCosto() && visitante.getTiempoDisponibleHs() >= atracciones.get(i).getDuracion()) {
						//visitante.aceptaSugerencia(atraccion.get(i));
					}
				}	
			}
			
		}
			


		return null;
	}

	@Override
	public String toString() {
		return "Carga:\n" + "Visitantes:\n" + visitantes + "\n" + "Atracciones:\n" + atracciones + "\n"
				+ "Promociones:\n" + promociones + "\n";
	}
}
