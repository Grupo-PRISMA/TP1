package paquete;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;

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
			String[] lista = this.getAtraccionesEnPromocion(datos); 
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

	private String[] getAtraccionesEnPromocion(ArrayList<String[]> datos) {
		String[] nombres = new String[0];

		for (String[] dato : datos) {
			nombres = new String[dato.length - 3];
			for (int i = 3; i < dato.length; i++) {
				nombres[i - 3] = dato[i];
			}
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

/*
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public final class ManejadorArchivos
{
	private static String RUTA_ARCHIVOS = "entrada"+ File.separator;
	private static String ARCHIVO_ATRACCIONES = RUTA_ARCHIVOS + "atracciones.csv";
	private static String ARCHIVO_VISITANTES = RUTA_ARCHIVOS + "visitantes.csv";
	private static String ARCHIVO_PROMOCIONES = RUTA_ARCHIVOS + "promociones.csv";

	private static ArrayList<Atraccion> atracciones = new ArrayList<>();
	private static ArrayList<Visitante> visitantes = new ArrayList<>();
	private static ArrayList<Promocion> promociones = new ArrayList<>();

	public static void main(String[] args) // para testeo
	{
		ManejadorArchivos.cargarArchivos();
		System.out.println(ManejadorArchivos.atracciones.get(0).getNombre()); // Moria. OK
		System.out.println(ManejadorArchivos.visitantes.get(1).getNombre()); // Gandalf. OK
		System.out.println(ManejadorArchivos.promociones.get(2).getTipo()); // Paisaje. OK
	}

	public static void cargarArchivos()
	{
		ManejadorArchivos.cargarAtracciones();
		ManejadorArchivos.cargarPromociones();
		ManejadorArchivos.cargarVisitantes();
	}

	private static void cargarAtracciones()
	{
		ArrayList<String[]> datos = ManejadorArchivos.leerArchivo(ARCHIVO_ATRACCIONES);
		ManejadorArchivos.atracciones = ManejadorArchivos.generarAtracciones(datos);
	}

	private static void cargarPromociones() {
		ArrayList<String[]> datos = ManejadorArchivos.leerArchivo(ARCHIVO_PROMOCIONES);
		ManejadorArchivos.promociones = ManejadorArchivos.generarPromociones(datos);
	}

	private static void cargarVisitantes()
	{
		ArrayList<String[]> datos = ManejadorArchivos.leerArchivo(ARCHIVO_VISITANTES);
		ManejadorArchivos.visitantes = ManejadorArchivos.generarVisitantes(datos);
	}

	private static ArrayList<String[]> leerArchivo(String ruta)
	{
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

	private static ArrayList<Atraccion> generarAtracciones(ArrayList<String[]> datos)
	{
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

		return atracciones;
	}

	private static ArrayList<Visitante> generarVisitantes(ArrayList<String[]> datos)
	{
		ArrayList<Visitante> visitantes = new ArrayList<>();

		for (String[] datosVisitante : datos) {
			Visitante visitante = new Visitante( // el orden de los campos en el archivo no coincide con el orden de los parametros del constructor -_-
				datosVisitante[0],
				Double.parseDouble(datosVisitante[2]),
				Double.parseDouble(datosVisitante[3]),
				TipoDeAtraccion.valueOf(datosVisitante[1])
			);

			visitantes.add(visitante);
		}

		return visitantes;
	}

	private static ArrayList<Promocion> generarPromociones(ArrayList<String[]> datos) {
		ArrayList<Promocion> promociones = new ArrayList<>();

		for (String[] datosPromociones : datos) {
			Promocion promocion;
			String[] lista = ManejadorArchivos.construirListaAtracciones(datos); // ver si java tiene algo para extraer una porcion de un array list
			ArrayList<Atraccion> atracciones = ManejadorArchivos.buscarAtracciones(lista);

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
	private static String[] construirListaAtracciones(ArrayList<String[]> datos) {
		String[] nombres = new String[0];

		for (String[] dato : datos) {
			nombres = new String[dato.length - 3];
			for (int i = 3; i < dato.length; i++) {
				nombres[i - 3] = dato[i];
			}
		}

		return nombres;
	}

	private static ArrayList<Atraccion> buscarAtracciones(String[] nombres) {
		ArrayList<Atraccion> atracciones = new ArrayList<>();
		int i = 0;

		for (Atraccion atraccion : ManejadorArchivos.atracciones) {
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

	private static Atraccion buscarAtraccion(String nombre) {
		String[] nombreArray = new String[1];
		nombreArray[0] = nombre;
		ArrayList<Atraccion> atracciones = ManejadorArchivos.buscarAtracciones(nombreArray);

		return atracciones.isEmpty() ? null : atracciones.get(0);
	}
}
*/