package paquete;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Pattern;

public abstract class ManejadorArchivos {
	public static Visitante[] obtenerVisitantesDesdeArchivo() {
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;

		Visitante[] visitantes = null;

		try {
			archivo = new File("entrada/visitantes.txt");
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);

			int cantidad = Integer.parseInt(br.readLine());
			visitantes = new Visitante[cantidad];
			int indice = 0;
			
			String linea = br.readLine();
			while (linea != null) {
				String[] datosVisitantes = linea.split(",");

				String nombre = datosVisitantes[0];
				TipoDeAtraccion tipo = TipoDeAtraccion.valueOf(datosVisitantes[1]);
				double presupuesto = Integer.parseInt(datosVisitantes[2]);
				double tiempoDisponibleHs = Integer.parseInt(datosVisitantes[3]);

				visitantes[indice++] = new Visitante(nombre, presupuesto, tiempoDisponibleHs, tipo);
				linea = br.readLine();
			}

			return visitantes;

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fr != null) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();

			}
		}

		return visitantes;
	}

	public static Atraccion[] obtenerAtraccionesDesdeArchivo() {
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;

		Atraccion[] atracciones = null;

		try {
			archivo = new File("entrada/atracciones.txt");
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);

			int cantidad = Integer.parseInt(br.readLine());
			atracciones = new Atraccion[cantidad];

			int indice = 0;
			String linea = br.readLine();
			while (linea != null) {
				String[] datosAtracciones = linea.split(",");

				String nombre = datosAtracciones[0];
				TipoDeAtraccion tipo = TipoDeAtraccion.valueOf(datosAtracciones[1]);
				double costo = Double.parseDouble(datosAtracciones[2]);
				double duracionHs = Double.parseDouble(datosAtracciones[3]);
				int cupoPersonas = Integer.parseInt(datosAtracciones[4]);

				atracciones[indice++] = new Atraccion(nombre, tipo, costo, duracionHs, cupoPersonas);
				linea = br.readLine();
			}

			return atracciones;

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fr != null) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();

			}
		}

		return atracciones;
	}

	public static Promocion[] obtenerPromocionesDesdeArchivo() {
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;

		// PromocionAbsoluta[] promocionAbsoluta = null;
		// PromocionAxB[] promocionAxB = null;
		Promo[] promocion = null;

		try {
			archivo = new File("entrada/promociones.txt");
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);

			int cantidad = Integer.parseInt(br.readLine());

			promocion = new Promo[cantidad];
			// promocion = new PromocionPorcentual[cantidad];
			// promocionAbsoluta = new PromocionAbsoluta[cantidad];
			// promocionAxB = new PromocionAxB[cantidad];

			int indice = 0;
			double descuento = 0;
			Atraccion descuento2 = null;

			//expresion regular, compara un string si cumple con determinado patron, en este caos número
			Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
			String linea = br.readLine();
			while (linea != null) {
				String[] datosPromociones = linea.split(",");

				String id = datosPromociones[0];
				TipoDeAtraccion tipo = TipoDeAtraccion.valueOf(datosPromociones[1]);

				if (pattern.matcher(datosPromociones[2]).matches()) {
					descuento = Double.parseDouble(datosPromociones[2]);
				} else {
					descuento2 = buscarAtraccion(datosPromociones[2]);
				}

				String[] datosAtracciones = datosPromociones[3].split(";");
				Atraccion[] atracciones = new Atraccion[datosAtracciones.length];
				Atraccion[] a = obtenerAtraccionesDesdeArchivo();

				int i = 0, j = 0, x = 0;
				for (i = 0; i < a.length; i++) {
					for (j = 0; j < datosAtracciones.length; j++) {
						if (a[i].getNombre().equals(datosAtracciones[j])) {
							atracciones[x] = a[i];
							x++;
							//System.out.println(a[i]);
							j = datosAtracciones.length;
						}
					}
				}
				//System.out.println("----------------------");

				if (id.equals("porcentual")) {
					promocion[indice++] = new PromocionPorcentual(tipo, descuento, atracciones);
				} else if (id.equals("absoluta")) {
					promocion[indice++] = new PromocionAbsoluta(tipo, descuento, atracciones);
				} else if (id.equals("AxB")) {
					promocion[indice++] = new PromocionAxB(tipo, descuento2, atracciones);
				}

				linea = br.readLine();
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fr != null) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();

			}
		}

		return promocion;
	}

	public static Atraccion buscarAtraccion(String atraccion) {
		Atraccion[] a = obtenerAtraccionesDesdeArchivo();
		Atraccion atraccionEncontrada = null;
		int i = 0;

		while (i < a.length && atraccionEncontrada == null) {
			if (a[i].getNombre().equals(atraccion)) {
				atraccionEncontrada = a[i];
			} else {
				i++;
			}
		}

		return atraccionEncontrada;
	}

}
