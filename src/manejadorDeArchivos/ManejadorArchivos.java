package manejadorDeArchivos;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;

import atraccion.Atraccion;
import atraccion.TipoDeAtraccion;
import promociones.Promocion;
import promociones.PromocionAbsoluta;
import promociones.PromocionAxB;
import promociones.PromocionPorcentual;
import visitante.Visitante;

public class ManejadorArchivos {

	private ArrayList<Atraccion> atracciones;
	private ArrayList<Visitante> visitantes;
	private ArrayList<Promocion> promociones;

	public ManejadorArchivos() {
		this.cargarAtracciones();
		this.cargarPromociones();
		this.cargarVisitantes();
	}

	public ArrayList<Promocion> getPromociones() {
		return this.promociones;
	}
	
	public ArrayList<Atraccion> getAtracciones() {
		return this.atracciones;
	}
	
	public ArrayList<Visitante> getVisitantes() {
		return this.visitantes;
	}

	private void cargarAtracciones() {
		ArrayList<String[]> datos = this.leerArchivo("entrada/atracciones.txt");
		this.atracciones = this.generarAtracciones(datos);
	}

	private void cargarPromociones() {
		ArrayList<String[]> datos = this.leerArchivo("entrada/promociones.txt");
		this.promociones = this.generarPromociones(datos);
	}

	private void cargarVisitantes() {
		ArrayList<String[]> datos = this.leerArchivo("entrada/visitantes.txt");
		this.visitantes = this.generarVisitantes(datos);
	}

	private ArrayList<String[]> leerArchivo(String ruta) {
		ArrayList<String[]> datos = new ArrayList<>();

		try {
			BufferedReader lector = new BufferedReader(new FileReader(new File(ruta)));
			String linea;

			while ((linea = lector.readLine()) != null) {
				datos.add(linea.split(";"));
			}
		} catch (Exception e) {
			System.out.println("ERROR!!!\n" + e.getMessage());
		}

		return datos;
	}

	private ArrayList<Atraccion> generarAtracciones(ArrayList<String[]> datos) {
		ArrayList<Atraccion> atracciones = new ArrayList<>();

		for (String[] datosAtraccion : datos) {
			Atraccion atraccion = new Atraccion(
				datosAtraccion[0],
				TipoDeAtraccion.valueOf(datosAtraccion[1]),
				Double.parseDouble(datosAtraccion[2]),
				Double.parseDouble(datosAtraccion[3]),
				Integer.parseInt(datosAtraccion[4])
			);

			atracciones.add(atraccion);
		}
		
		Collections.sort(atracciones);
		
		return atracciones;
	}

	private ArrayList<Visitante> generarVisitantes(ArrayList<String[]> datos) {
		ArrayList<Visitante> visitantes = new ArrayList<>();

		for (String[] datosVisitante : datos) {
			Visitante visitante = new Visitante(
				datosVisitante[0],
				TipoDeAtraccion.valueOf(datosVisitante[1]),
				Double.parseDouble(datosVisitante[2]),
				Double.parseDouble(datosVisitante[3])
			);

			visitantes.add(visitante);
		}

		return visitantes;
	}

	private ArrayList<Promocion> generarPromociones(ArrayList<String[]> datos) {
		ArrayList<Promocion> promociones = new ArrayList<>();

		for (String[] datosPromociones : datos) {
			Promocion promocion;
			String[] lista = this.getAtraccionesEnPromocion(datosPromociones);
			ArrayList<Atraccion> atracciones = this.buscarAtracciones(lista);

			if (datosPromociones[0].equals(Promocion.TIPO_ABSOLUTA)) {
				promocion = new PromocionAbsoluta(
					TipoDeAtraccion.valueOf(datosPromociones[1]),
					Double.parseDouble(datosPromociones[2]),
					atracciones
				);
			} else if (datosPromociones[0].equals(Promocion.TIPO_PORCENTUAL)) {
				promocion = new PromocionPorcentual(
					TipoDeAtraccion.valueOf(datosPromociones[1]),
					Double.parseDouble(datosPromociones[2]),
					atracciones
				);
			} else {
				promocion = new PromocionAxB(
					TipoDeAtraccion.valueOf(datosPromociones[1]),
					buscarAtraccion(datosPromociones[2]),
					atracciones
				);
			}

			promociones.add(promocion);
		}

		return promociones;
	}

	private String[] getAtraccionesEnPromocion(String[] dato) {
		String[] nombres = new String[dato.length - 3];
		
		for (int i = 3; i < dato.length; i++) {
			nombres[i - 3] = dato[i];
		}

		return nombres;
	}

	private ArrayList<Atraccion> buscarAtracciones(String[] nombres) {
		ArrayList<Atraccion> atracciones = new ArrayList<>();
		int i = 0;

		for (Atraccion atraccion : this.atracciones) {
			for (String nombre : nombres) {
				if (atraccion.getNombre().equals(nombre)) {
					i++;
					atracciones.add(atraccion);
					break;
				}
			}

			if (i == nombres.length) {
				break;
			}
		}

		return atracciones;
	}

	private Atraccion buscarAtraccion(String nombre) {
		String[] nombreArray = new String[1];
		nombreArray[0] = nombre;
		ArrayList<Atraccion> atracciones = this.buscarAtracciones(nombreArray);

		return atracciones.isEmpty() ? null : atracciones.get(0);
	}
}