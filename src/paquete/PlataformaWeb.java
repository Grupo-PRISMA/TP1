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

	/*public Atraccion obtenerAtraccionesPorTipo(TipoDeAtraccion tipo) {
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
	}*/
	/*
	public Sugerencia sugerirPromocion(Visitante visitante) {  
		Sugerencia sugerencia = null;
		
		for(Promocion promo : this.promociones) {
			if(promo.getTipo() == visitante.getPreferencia()) {
				if(promo.costoTotal <= visitante.getPresupuesto()) {
					if(promo.duracionHs <= visitante.getTiempoDisponibleHs()) {
						sugerencia = new Sugerencia (promo, null, promo.costoTotal, promo.duracionHs);
						//visitante.aceptarSugerencia(sugerencia); 
					}
				}
			}
		}

		
		return sugerencia;
	}

	public Atraccion [] getAtracciones() {
		return this.atracciones;
	}
	*/
	
	
	
	

	/*public Sugerencia[] crearSugerencia(Visitante[] visitantes, Atraccion[] atracciones, Promo[] promociones) {
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
	}*/
	


	@Override
	public String toString() {
		return "Carga:\n" + "Visitantes:\n" + visitantes + "\n" + "Atracciones:\n"
				+ atracciones + "\n" + "Promociones:\n" + promociones + "\n";
	}
}
