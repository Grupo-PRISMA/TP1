package plataformaWeb;

import java.util.ArrayList;

import atraccion.Atraccion;
import manejadorDeArchivos.EscrituraSalidaDeArchivos;
import manejadorDeArchivos.LecturaDeArchivos;
import promociones.Promocion;
import sugerencia.Sugerencia;
import visitante.Visitante;

public class PlataformaWeb {
	private ArrayList<Atraccion> atracciones;
	private ArrayList<Visitante> visitantes;
	private ArrayList<Promocion> promociones;

	public PlataformaWeb() {
		LecturaDeArchivos manejadorArchivos = new LecturaDeArchivos();

		this.atracciones = manejadorArchivos.getAtracciones();
		this.visitantes = manejadorArchivos.getVisitantes();
		this.promociones = manejadorArchivos.getPromociones();
	}
	
	private boolean validaRequisitos(Visitante visitante, boolean cupo, double costo, double duracion) {
		return cupo	&& visitante.getPresupuesto() >= costo && visitante.getTiempoDisponibleHs() >= duracion;
	}
	
	private boolean validaRequisitosPromocionPreferencia(Visitante visitante, Promocion promocion) {
		return visitante.getPreferencia() == promocion.getTipo() &&
				this.validaRequisitos(visitante, promocion.hayCupo(), promocion.getCostoTotal(), promocion.getDuracionTotal());
	}
	
	private boolean validaRequisitosAtraccionPreferencia(Visitante visitante, Atraccion atraccion) {
		return atraccion.getTipo() == visitante.getPreferencia() &&
				this.validaRequisitos(visitante, atraccion.hayCupo(), atraccion.getCosto(), atraccion.getDuracion());
	}
	
	private boolean validaRequisitosPromocion(Visitante visitante, Promocion promocion) {
		return promocion.getTipo() != visitante.getPreferencia() &&
				this.validaRequisitos(visitante, promocion.hayCupo(), promocion.getCostoTotal(), promocion.getDuracionTotal());
	}
	
	private boolean validaRequisitosAtraccion(Visitante visitante, Atraccion atraccion) {
		return atraccion.getTipo() != visitante.getPreferencia() &&
				this.validaRequisitos(visitante, atraccion.hayCupo(), atraccion.getCosto(), atraccion.getDuracion());
	}

	public void sugerir() {
		for (Visitante visitante : this.visitantes) {

			System.out.println("-".repeat(50));
			System.out.println("Visitante: " + visitante.getNombre());

	
			ArrayList<Sugerencia> itinerario = this.crearSugerencias(visitante);
			this.mostrarItinerario(visitante, itinerario);
			this.guardarEnArchivoDeSalida(visitante, itinerario);
		}
	}
	
	public void guardarEnArchivoDeSalida(Visitante visitante, ArrayList<Sugerencia> itinerario) {
		EscrituraSalidaDeArchivos.salidaItinerario(visitante.getNombre() + ".txt", this.datosItinerario(visitante, itinerario));
	}
	
	private ArrayList<Sugerencia> crearSugerencias(Visitante visitante) {
		ArrayList<Sugerencia> sugerenciasAceptadas = new ArrayList<Sugerencia>();
		
		sugerenciasAceptadas = this.crearSugerenciasConPreferencia(visitante, sugerenciasAceptadas);
		sugerenciasAceptadas = this.crearSugerenciasSinPreferencia(visitante, sugerenciasAceptadas);
		
		return sugerenciasAceptadas;
	}
	
	private ArrayList<Sugerencia> crearSugerenciasConPreferencia(Visitante visitante, ArrayList<Sugerencia> sugerencias) {
		sugerencias = this.crearSugerenciasPromocionesConPreferencias(visitante, sugerencias);
		sugerencias = this.crearSugerenciasAtraccionesConPreferencias(visitante, sugerencias);
		
		return sugerencias;
	}
	
	private ArrayList<Sugerencia> crearSugerenciasPromocionesConPreferencias(Visitante visitante, ArrayList<Sugerencia> sugerencias) {
		for (Promocion promocion : this.promociones) {
			Sugerencia sugerencia = new Sugerencia(promocion);
			System.out.println("verificando promocion" + promocion);
			if (this.validaRequisitosPromocionPreferencia(visitante, promocion)) {
				
				System.out.println("cumple");
				if (visitante.decidirSugerencia(sugerencia)) {
					System.out.println("aceptada");
					sugerencias.add(sugerencia);
					promocion.bajarCupo();
				} 
			} 
			
			System.out.println("=====");
		}
		
		return sugerencias;
	}
	
	private ArrayList<Sugerencia> crearSugerenciasAtraccionesConPreferencias(Visitante visitante, ArrayList<Sugerencia> sugerencias) {
		System.out.println("ATRACCIONES CON PREFRENCIA");
		for (Atraccion atraccion : this.atracciones) {
			Sugerencia sugerencia = new Sugerencia(atraccion);
			
			if (!sugerencia.estaEn(sugerencias) && this.validaRequisitosAtraccionPreferencia(visitante, atraccion)) {
				System.out.println("valida");
				System.out.println("Atracción " + atraccion.getNombre() + "\n");
				
				if (visitante.decidirSugerencia(sugerencia)) {
					sugerencias.add(sugerencia);
					atraccion.bajarCupo();
					System.out.println("acepta");
				} else {
					System.out.println("rechaza");
				}
			} else {
				System.out.println("repetido o no valido");
			}
		}
		
		return sugerencias;
	}
	
	private ArrayList<Sugerencia> crearSugerenciasSinPreferencia(Visitante visitante, ArrayList<Sugerencia> sugerencias) {
		sugerencias = this.crearSugerenciasPromocionesSinPreferencias(visitante, sugerencias);
		sugerencias = this.crearSugerenciasAtraccionesSinPreferencias(visitante, sugerencias);
		
		return sugerencias;
	}
	
	private ArrayList<Sugerencia> crearSugerenciasPromocionesSinPreferencias(Visitante visitante, ArrayList<Sugerencia> sugerencias) {
		System.out.println("PROMOCIONES SIN PREFERENCIAS");
		
		for (Promocion promocion :  this.promociones) {
			Sugerencia sugerencia = new Sugerencia(promocion);
			System.out.println("la promo es " + promocion);
			if (!sugerencia.estaEn(sugerencias) && this.validaRequisitosPromocion(visitante, promocion)) {
				System.out.println("valido");
				
				if (visitante.decidirSugerencia(sugerencia)) {
					sugerencias.add(sugerencia);
					promocion.bajarCupo();
					System.out.println("acepta");
				} else {
					System.out.println("rechaza");
				}
			} else {
				System.out.println("no valido");
			}
		}
		
		return sugerencias;
	}
	
	private ArrayList<Sugerencia> crearSugerenciasAtraccionesSinPreferencias(Visitante visitante, ArrayList<Sugerencia> sugerencias) {
		System.out.println("ATRACCIONES SIN PREFERENCIAS");
		
		for (Atraccion atraccion : this.atracciones) {
			Sugerencia sugerencia = new Sugerencia(atraccion);
			
			if (!sugerencia.estaEn(sugerencias) && this.validaRequisitosAtraccion(visitante, atraccion)) {
				System.out.println("valida");
				System.out.println("Atracción " + atraccion.getNombre() + "\n");
				if (visitante.decidirSugerencia(sugerencia)) {
					sugerencias.add(sugerencia);
					atraccion.bajarCupo();
				}
			} 
		}
		
		return sugerencias;
	}
	
	public String datosItinerario(Visitante visitante, ArrayList<Sugerencia> itinerario) {
		double costoTotal = 0;
		double duracionTotal = 0;
		ArrayList<String> nombres = null;
		String cadenaNombres = "";
	
		String texto = "\n" + "-".repeat(50);
		texto += "\nHola " + visitante.getNombre() + "\nBienvenido a Tierra Media";
		texto += "\nEsperamos que disfrutes de nuestras atracciones";
		texto += "\n" + "-".repeat(50);
		texto += "\nAtracciones de tu itinerario";
		texto += "\n" + "-".repeat(50);
	
		for (Sugerencia sugerencia : itinerario) {
			nombres = sugerencia.getNombresAtracciones();
			for(int i = 0; i < nombres.size(); i++) {
				String cadena = nombres.get(i);
				cadenaNombres += cadena + "\n";
				//System.out.println(cadenaNombres);
			}
			//System.out.println(nombres);
			costoTotal += sugerencia.getCosto();
			duracionTotal += sugerencia.getDuracion();
		}
		
		//System.out.println("Costo total= " + costoTotal + "\nDuración total= " + duracionTotal);
		return texto + "\n" + cadenaNombres + "\nCosto total= " + costoTotal + "\nDuración total= " + duracionTotal;
	}
	public void mostrarItinerario(Visitante visitante, ArrayList<Sugerencia> itinerario) {
		System.out.println(this.datosItinerario(visitante, itinerario));
	}


	@Override
	public String toString() {
		return "Carga:\n" + "Visitantes:\n" + visitantes + "\n" + "Atracciones:\n" + atracciones + "\n"
				+ "Promociones:\n" + promociones + "\n";
	}
}
